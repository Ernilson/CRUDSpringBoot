/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CrudSpringBoot.Controller;

import br.com.CrudSpringBoot.Model.CadModel;
import br.com.CrudSpringBoot.ServiceImpl.CadServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author eupen
 */
@Controller
@RequestMapping
public class CadController {
    
    @Autowired
    private CadServiceImpl service;
    
    @RequestMapping("index.htm")
    public String inicio(){        
        return "/listar";
    }    
   
    @RequestMapping(method = RequestMethod.GET, value="/listar")
    public ModelAndView listar(){
      ModelAndView v = new ModelAndView("index");
      List<CadModel> cadastro = service.listAll();
      v.addObject("cadastro", cadastro);
        return v;  
    }
    
    //Metodo para incluir novo cadastro
    @RequestMapping(method = RequestMethod.GET, value = "/novo")
    public ModelAndView novoCadastro(){
      ModelAndView v = new ModelAndView("Adicionar.html");
       v.addObject(new CadModel());
       v.setViewName("Adicionar");
       return v;
    }   
    
     //Metodo para salvar cadastro
    @RequestMapping(method = RequestMethod.POST, value="/salvar")
    public String salvar(CadModel c){
       service.saveOrUpdate(c);
        return "index";
    }
    
    
}
