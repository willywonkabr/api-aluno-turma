package br.edu.infnet.apialunoturma.model.service;

import br.edu.infnet.apialunoturma.model.domain.Aluno;
import br.edu.infnet.apialunoturma.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	public void criar(Aluno aluno) {
		this.repository.save(aluno);
	}
	public Optional<Aluno> getAluno(UUID id) {
		return this.repository.findById(id);
	}
	public List<Aluno> getTodosAlunos() {
		return this.repository.findAll();
	}
}
