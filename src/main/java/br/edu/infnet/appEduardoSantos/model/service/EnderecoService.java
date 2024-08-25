package br.edu.infnet.appEduardoSantos.model.service;


import br.edu.infnet.appEduardoSantos.client.EnderecoClient;
import br.edu.infnet.appEduardoSantos.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoClient enderecoClient;
    public Endereco obterPorCep(String cep){
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setLogradouro("Rua Um, 20");
        endereco.setComplemento("Casa");
        endereco.setBairro("Maré");
        endereco.setLocalidade("Rio de Janeiro");
        endereco.setUf("RJ");
        return enderecoClient.findByCep(cep);
    }
}
