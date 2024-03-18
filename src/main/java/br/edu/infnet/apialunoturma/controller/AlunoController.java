package br.edu.infnet.apialunoturma.controller;

import br.edu.infnet.apialunoturma.model.domain.Aluno;
import br.edu.infnet.apialunoturma.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoService service;
	@GetMapping
	public ResponseEntity<List<Aluno>> getTodosAlunos() {
		List<Aluno> aluno = this.service.getTodosAlunos();
		return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Aluno> get(@PathVariable("id")UUID id) {
		return this.service.getAluno(id).map(aluno -> {
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
		this.service.criar(aluno);
		return new ResponseEntity<>(aluno, HttpStatus.CREATED);
	}
}
