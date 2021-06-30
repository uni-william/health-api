package com.system.health.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.system.health.api.assembler.ConvenioInputDisassembler;
import com.system.health.api.assembler.ConvenioModelAssembler;
import com.system.health.api.model.ConvenioModel;
import com.system.health.api.model.input.ConvenioInput;
import com.system.health.domain.exception.ConvenioNaoEncontradoException;
import com.system.health.domain.exception.NegocioException;
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

	@Autowired
	private ConvenioModelAssembler convenioModelAssembler;
	
	@Autowired
	private ConvenioInputDisassembler convenioInputDisassembler;	

	@GetMapping
	public List<ConvenioModel> listar() {
		return convenioModelAssembler.toCollectionModel(convenioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ConvenioModel findById(@PathVariable Long id) {
		Convenio convenio = cadastroConvenio.buscarPorId(id);
		return convenioModelAssembler.toModel(convenio);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ConvenioModel adicionar(@RequestBody @Valid ConvenioInput convenioInput) {
		try {
			Convenio convenio = convenioInputDisassembler.toDomainObject(convenioInput);
			return convenioModelAssembler.toModel(cadastroConvenio.salvar(convenio));
		} catch (ConvenioNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{id}")
	public ConvenioModel atualizar(@PathVariable Long id, @RequestBody @Valid ConvenioInput convenioInput) {
		Convenio convenioSalva = cadastroConvenio.buscarPorId(id);
		convenioInputDisassembler.copyToDomainObject(convenioInput, convenioSalva);
		try {
			return convenioModelAssembler.toModel(cadastroConvenio.salvar(convenioSalva));
		} catch (ConvenioNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cadastroConvenio.excluir(id);
	}
}
