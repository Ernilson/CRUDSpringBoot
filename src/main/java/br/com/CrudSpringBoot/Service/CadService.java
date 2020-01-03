/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CrudSpringBoot.Service;

import br.com.CrudSpringBoot.Model.CadModel;
import java.util.List;

/**
 *
 * @author eupen
 */

public interface CadService {
    
     List<CadModel> listAll();

    CadModel getById(Long id);

    CadModel saveOrUpdate(CadModel cm);

    void delete(Long id);

    CadModel saveOrUpdateCadastro(CadModel cm);
}
