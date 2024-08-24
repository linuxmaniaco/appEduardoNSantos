package br.edu.infnet.appEduardoSantos.model.service;

import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {


    @Autowired
    private VendedorRepository vendedorRepository;

    private final Map<Integer, Vendedor> vendedorMap = new HashMap<Integer, Vendedor>();


    public void incluirVendedor(Vendedor vendedor){
        vendedorRepository.save(vendedor);
    }

    public Collection<Vendedor> obterVendedor(){
        return vendedorRepository.findAll();
    }

    public Vendedor obterVendedorPorId(Integer id){
        return vendedorRepository.findById(id).orElse(null);
    }

    public void excluirVendedor(Integer id){
        vendedorRepository.deleteById(id);
    }

    public int obterQtde(){
        return (int) vendedorRepository.count();
    }
}