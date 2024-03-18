package br.edu.infnet.apialunoturma.model.repository;

import br.edu.infnet.apialunoturma.model.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, UUID> {
}
