package br.edu.infnet.apialunoturma.controller;

import br.edu.infnet.apialunoturma.model.domain.Turma;
import br.edu.infnet.apialunoturma.model.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/turmas")
public class TurmaController {
	@Autowired
	private TurmaService service;
	@GetMapping
	public ResponseEntity<List<Turma>> getTodasTurmas() {
		List<Turma> turmas = this.service.getTodasTurmas();
		return new ResponseEntity<>(turmas, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Turma> get(@PathVariable("id")UUID id) {
		return this.service.getTurma(id).map(turma -> {
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping
	public ResponseEntity<Turma> criar(@RequestBody Turma turma) {
		this.service.criar(turma);
		return new ResponseEntity<>(turma, HttpStatus.CREATED);
	}
}
