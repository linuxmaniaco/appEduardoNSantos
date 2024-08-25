package br.edu.infnet.appEduardoSantos.model.service;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import br.edu.infnet.appEduardoSantos.model.domain.Produto;
import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import br.edu.infnet.appEduardoSantos.model.repository.AlimentoRepository;
import br.edu.infnet.appEduardoSantos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluirProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public Collection<Produto> obterProduto(){
        return produtoRepository.findAll();
    }

//    public Alimento obterAlimentoPorId(Integer id){
//        return  produtoRepository.findById(id).orElse(null);
//    }

//    public void excluirAlimento(Integer id){
//        produtoRepository.deleteById(id);
//    }

    public int obterQtde(){
        return (int) produtoRepository.count();
    }

    public Collection<Produto> obterProdutosPorVendedor(Integer id){
        return produtoRepository.findByVendedorId(id);
    }

    public Collection<Produto> obterProdutosPorVendedor(Vendedor vendedor){
        return produtoRepository.findByVendedorId(vendedor.getId());
    }
}
