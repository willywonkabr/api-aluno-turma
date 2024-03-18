package br.edu.infnet.apialunoturma.model.service;

import br.edu.infnet.apialunoturma.model.domain.Turma;
import br.edu.infnet.apialunoturma.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository repository;
	public void criar(Turma turma) {
		this.repository.save(turma);
	}
	public Optional<Turma> getTurma(UUID id) {
		return this.repository.findById(id);
	}
	public List<Turma> getTodasTurmas() {
		return this.repository.findAll();
	}
}
