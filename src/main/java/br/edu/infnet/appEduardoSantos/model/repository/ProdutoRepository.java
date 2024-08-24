package br.edu.infnet.appEduardoSantos.model.repository;

import br.edu.infnet.appEduardoSantos.model.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
