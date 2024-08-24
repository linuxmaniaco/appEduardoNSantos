package br.edu.infnet.appEduardoSantos.controller;

import br.edu.infnet.appEduardoSantos.model.domain.Papelaria;
import br.edu.infnet.appEduardoSantos.model.service.PapelariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PapelariaController {

    @Autowired
    private PapelariaService papelariaService;

    @GetMapping(value = "papelaria/obter")
    public Collection<Papelaria> obterPapelaria(){
        return papelariaService.obterPapelaria();
    }

    @GetMapping(value = "papelaria/obter/{id}")
    public Papelaria obterPapelariaPorId(@PathVariable Integer id){
        return papelariaService.obterPapelariaPorId(id);
    }

    @PostMapping(value = "papelaria/incluir")
    public String incluirPapelaria(@RequestBody Papelaria papelaria){
        papelariaService.incluirPapelaria(papelaria);
        return "Item de papelaria incluido com sucesso!";
    }

    @DeleteMapping(value = "papelaria/{id}/excluir")
    public String excluirPapelariaPorId(@PathVariable Integer id){
        papelariaService.excluirPapelariaPorId(id);
        return "Item de papelaria excluiro com sucesso!";
    }
}
