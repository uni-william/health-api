package com.system.health.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.system.health.domain.model.Convenio;
import com.system.health.domain.repository.ConvenioRepository;
import com.system.health.domain.service.CadastroConvenioService;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {

	@Autowired
	private ConvenioRepository convenioRepository;

	@Autowired
	private CadastroConvenioService cadastroConvenio;

	@GetMapping
	public List<Convenio> listar() {
		return convenioRepository.findAll();
	}

	@GetMapping("/{id}")
	public Convenio findById(@PathVariable Long id) {
		Convenio convenio = cadastroConvenio.buscarPorId(id);
		return convenio;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Convenio adicionar(@RequestBody Convenio convenio) {
		return cadastroConvenio.salvar(convenio);
	}

	@PutMapping("/{id}")
	public Convenio atualizar(@PathVariable Long id, @RequestBody Convenio convenio) {
		Convenio convenioSalva = cadastroConvenio.buscarPorId(id);
		BeanUtils.copyProperties(convenio, convenioSalva, "id");
		return cadastroConvenio.salvar(convenioSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cadastroConvenio.excluir(id);

	}

}
