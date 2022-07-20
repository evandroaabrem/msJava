package br.com.otima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otima.dto.PosteDto;
import br.com.otima.entity.PosteEntity;
import br.com.otima.service.PosteService;

@RestController
@RequestMapping("/api-poste")
public class PosteController {

	@Autowired
	private PosteService posteService;

	@DeleteMapping("/{id}")
	public ResponseEntity<PosteDto> deleteById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(posteService.deleteById(id));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PosteDto> getById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(posteService.getById(id));
	}

	@GetMapping()
	public ResponseEntity<Page<PosteDto>> getAll(Pageable pageable) {
		return ResponseEntity.ok().body(posteService.getAll(pageable));
	}
	
	
	@PostMapping()
	public ResponseEntity<PosteEntity> savePoste(@RequestBody PosteDto posteDto) {
		return ResponseEntity.ok().body(posteService.savePoste(posteDto));
	}
	
	@PutMapping()
	public ResponseEntity<PosteEntity> updatePoste(@RequestBody PosteDto posteDto) {
		return ResponseEntity.ok().body(posteService.updatePoste(posteDto));
	}

}
