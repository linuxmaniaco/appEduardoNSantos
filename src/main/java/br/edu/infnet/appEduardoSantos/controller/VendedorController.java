package br.edu.infnet.appEduardoSantos.controller;

import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping(value = "vendedor/obter")
    public Collection<Vendedor> obterVendedor(){
        return vendedorService.obterVendedor();
    }

    @GetMapping(value = "vendedor/obter/{id}")
    public Vendedor ObtervendedorPorId(@PathVariable Integer id){
        return vendedorService.obterVendedorPorId(id);
    }

    @PostMapping(value = "vendedor/incluir")
    public String incluirVendedor(@RequestBody Vendedor vendedor){
        vendedorService.incluirVendedor(vendedor);
        return "Vendedor Inlcuido com sucesso!";
    }

    @DeleteMapping(value = "vendedor/{id}/excluir")
    public String ixclurVendedor(@PathVariable Integer id){
        vendedorService.excluirVendedor(id);
        return "Vendedor ixcluído com sucesso";
    }

    @GetMapping(value = "vendedor/obterQtde")
    public int obterQtde(){
        return vendedorService.obterQtde();
    }
}
