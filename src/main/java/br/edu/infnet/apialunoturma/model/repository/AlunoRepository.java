package br.edu.infnet.apialunoturma.model.repository;

import br.edu.infnet.apialunoturma.model.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
}
