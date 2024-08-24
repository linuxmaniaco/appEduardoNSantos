package br.edu.infnet.appEduardoSantos.model.repository;

import br.edu.infnet.appEduardoSantos.model.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
}
