package br.edu.infnet.appEduardoSantos.model.repository;

import br.edu.infnet.appEduardoSantos.model.domain.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}
