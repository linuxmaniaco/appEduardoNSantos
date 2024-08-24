package br.edu.infnet.appEduardoSantos.model.service;

import br.edu.infnet.appEduardoSantos.model.domain.ServicoImpressao;
import br.edu.infnet.appEduardoSantos.model.repository.ServicoImpressaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServicoImpressaoService {

    @Autowired
    private ServicoImpressaoRepository servicoImpressaoRepository;

    public void incluirServicoImpressao(ServicoImpressao servicoImpressao){
       servicoImpressaoRepository.save(servicoImpressao);
    }

    public Collection<ServicoImpressao> obterServicoImpressao(){
        return servicoImpressaoRepository.findAll();
    }

    public ServicoImpressao obterServicoImpressaoPorId(Integer id){
        return servicoImpressaoRepository.findById(id).orElse(null);
    }

    public void excluirServicoImpressao(Integer id){
        servicoImpressaoRepository.deleteById(id);
    }
}
