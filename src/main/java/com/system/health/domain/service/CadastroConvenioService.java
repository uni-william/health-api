package com.system.health.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.system.health.domain.exception.EntidadeEmUsoException;
import com.system.health.domain.exception.EntidadeNaoEncontradaException;
import com.system.health.domain.model.Convenio;
import com.system.health.domain.repository.ConvenioRepository;

@Service
public class CadastroConvenioService {
	
	private static final String MSG_CONVENIO_EM_USO = "Convênio de código %d não pode ser removida pois está em uso";
	private static final String MSG_CONVENIO_NAO_ENCONTRADO = "Não existe cadastro de convênio com o código %d";
	@Autowired
	private ConvenioRepository convenioRepository;

	public Convenio salvar(Convenio convenio) {
		return convenioRepository.save(convenio);
	}

	public Convenio buscarPorId(Long id) {
		Convenio convenio = convenioRepository.findById(id)
		.orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_CONVENIO_NAO_ENCONTRADO, id)));
		return convenio;
	}

	public void excluir(Long id) {
		try {
			convenioRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_CONVENIO_NAO_ENCONTRADO, id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_CONVENIO_EM_USO, id));
		}

	}

}
