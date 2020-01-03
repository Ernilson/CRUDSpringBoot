/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CrudSpringBoot.ServiceImpl;

import br.com.CrudSpringBoot.Model.CadModel;
import br.com.CrudSpringBoot.Repositories.CadRepository;
import br.com.CrudSpringBoot.Service.CadService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eupen
 */
@Service
public class CadServiceImpl implements CadService {
    
    private CadRepository cdao;

    @Autowired
    public CadServiceImpl(CadRepository cdao) {
        this.cdao = cdao;
    }
    
    @Override
    public List<CadModel> listAll() {
        List<CadModel> cm = new ArrayList<>();
        cdao.findAll().forEach(cm::add); //fun with Java 8
        return cm;
    }

    @Override
    public CadModel getById(Long id) {
         return cdao.findById(id).orElse(null);
    }

    @Override
    public CadModel saveOrUpdate(CadModel cm) {
         cdao.save(cm);
        return cm;
    }

    @Override
    public void delete(Long id) {
        cdao.deleteById(id);
    }

    @Override
    public CadModel saveOrUpdateCadastro(CadModel cm) {
         cdao.save(cm);
        return cm;
    }
    
    
}
