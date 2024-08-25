package br.edu.infnet.appEduardoSantos.client;

import br.edu.infnet.appEduardoSantos.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//https://viacep.com.be/ws/
//21044750/json/

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoClient {

    @GetMapping(value = "/{cep}/json/")
    Endereco findByCep(@PathVariable String cep);
}
