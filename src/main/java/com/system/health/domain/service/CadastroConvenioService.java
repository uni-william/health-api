package com.system.health.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.health.domain.exception.ConvenioNaoEncontradoException;
import com.system.health.domain.exception.EntidadeEmUsoException;
import com.system.health.domain.model.Convenio;
import com.system.health.domain.repository.ConvenioRepository;

@Service
public class CadastroConvenioService {
	
	private static final String MSG_COVENIO_EM_USO = "Convenio de códIgo %d não pode ser removida pois está em uso";
	
	@Autowired
	private ConvenioRepository convenioRepository;

	@Transactional
	public Convenio salvar(Convenio convenio) {
		return convenioRepository.save(convenio);
	}

	public Convenio buscarPorId(Long id) {
		Convenio convenio = convenioRepository.findById(id)
		.orElseThrow(() -> new ConvenioNaoEncontradoException(id));
		return convenio;
	}

	@Transactional
	public void excluir(Long id) {
		try {
			convenioRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new ConvenioNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_COVENIO_EM_USO, id));
		}

	}

}
