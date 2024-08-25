package br.edu.infnet.appEduardoSantos.controller;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import br.edu.infnet.appEduardoSantos.model.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping(value = "alimento/obter")
    public Iterable<Alimento> obterAlimento(){
        return alimentoService.obterAlimento();
    }


    @GetMapping(value = "alimento/obter/{id}")
    public Alimento obterAlimentoPorId(@PathVariable Integer id){
        return alimentoService.obterAlimentoPorId(id);
    }

    @PostMapping(value = "alimento/incluir")
    public String incluir(@RequestBody Alimento alimento){
        alimentoService.incluirAlimento(alimento);
        return "Alimento incluido com sucesso";
    }

    @DeleteMapping(value = "alimento/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        alimentoService.excluirAlimento(id);
        return "O alimento"+ id +" foi excluido com sucesso!";
    }
}
