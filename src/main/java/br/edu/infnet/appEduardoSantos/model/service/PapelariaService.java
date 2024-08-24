package br.edu.infnet.appEduardoSantos.model.service;

import br.edu.infnet.appEduardoSantos.model.domain.Papelaria;
import br.edu.infnet.appEduardoSantos.model.repository.PapelariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PapelariaService {

    @Autowired
    private PapelariaRepository papelariaRepository;

    public void incluirPapelaria(Papelaria papelaria){
        papelariaRepository.save(papelaria);
    }

    //obterLilsta
    public Collection<Papelaria> obterPapelaria(){
        return papelariaRepository.findAll();
    }

    public Papelaria obterPapelariaPorId(Integer id){
        return papelariaRepository.findById(id).orElse(null);
    }

    public void excluirPapelariaPorId(Integer id){
        papelariaRepository.deleteById(id);
    }
}
