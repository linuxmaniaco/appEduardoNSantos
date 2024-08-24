package br.edu.infnet.appEduardoSantos.model.repository;

import br.edu.infnet.appEduardoSantos.model.domain.ServicoImpressao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoImpressaoRepository extends JpaRepository<ServicoImpressao, Integer> {
}
