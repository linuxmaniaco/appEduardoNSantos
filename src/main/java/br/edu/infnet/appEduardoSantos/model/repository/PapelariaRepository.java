package br.edu.infnet.appEduardoSantos.model.repository;

import br.edu.infnet.appEduardoSantos.model.domain.Papelaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PapelariaRepository extends JpaRepository<Papelaria, Integer> {

    Collection<Papelaria> findByMarcaContaining(String marca);
}
