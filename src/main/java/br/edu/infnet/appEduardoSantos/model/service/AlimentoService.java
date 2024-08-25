package br.edu.infnet.appEduardoSantos.model.service;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import br.edu.infnet.appEduardoSantos.model.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public void incluirAlimento(Alimento alimento){
        alimentoRepository.save(alimento);
    }

    public Collection<Alimento> obterAlimento(){
        return alimentoRepository.findAll();
    }

    public Collection<Alimento> obterAlimento(String orderByDetalhes){
        return alimentoRepository.findAll(Sort.by(Sort.Direction.ASC, orderByDetalhes));
    }

    public Alimento obterAlimentoPorId(Integer id){
        return  alimentoRepository.findById(id).orElse(null);
    }

    public void excluirAlimento(Integer id){
        alimentoRepository.deleteById(id);
    }

    public int obterQtde(){
        return (int) alimentoRepository.count();
    }

    public Collection<Alimento> obterBebida(Boolean bebida){
        return alimentoRepository.findByBebida(bebida);
    }
}
