package br.com.otima.controller;

import br.com.otima.service.PosteService;
import br.com.otima.specification.SpecificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	public ResponseEntity<Page<PosteDto>> getAll(SpecificationTemplate.PosteSpec spec,
												 @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
		return ResponseEntity.ok().body(posteService.getAll(spec, pageable));
	}
	
	
	@PostMapping()
	public ResponseEntity<PosteEntity> savePoste(@Validated @RequestBody PosteDto posteDto) {
		return ResponseEntity.ok().body(posteService.savePoste(posteDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PosteEntity> updatePoste(@PathVariable(value = "id") Integer id,@Validated @RequestBody PosteDto posteDto) {
		return ResponseEntity.ok().body(posteService.updatePoste(id, posteDto));
	}

}
