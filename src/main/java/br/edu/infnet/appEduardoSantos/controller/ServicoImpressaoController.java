package br.edu.infnet.appEduardoSantos.controller;

import br.edu.infnet.appEduardoSantos.model.domain.ServicoImpressao;
import br.edu.infnet.appEduardoSantos.model.service.ServicoImpressaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ServicoImpressaoController {

    @Autowired
    ServicoImpressaoService servicoImpressaoService;

    @GetMapping(value = "servico/obterServicos")
    public Collection<ServicoImpressao> obterServicoImpressao(){
        return servicoImpressaoService.obterServicoImpressao();
    }

    @GetMapping(value = "servico/obterServicoId/{id}")
    public ServicoImpressao obterServicoImpressaoPorId(@PathVariable Integer id){
        return servicoImpressaoService.obterServicoImpressaoPorId(id);
    }

    @PostMapping(value = "servico/incluirServico")
    public String incluirServicoImpressao(@RequestBody ServicoImpressao servicoImpressao){
        servicoImpressaoService.incluirServicoImpressao(servicoImpressao);
        return "Serviço incluído com sucesso!";
    }

    @DeleteMapping(value = "servico/{id}/excluir")
    public String excluirServicoImpressao(@PathVariable Integer id){
        servicoImpressaoService.excluirServicoImpressao(id);
        return "Serviço excluido com sucesso!";
    }
}
