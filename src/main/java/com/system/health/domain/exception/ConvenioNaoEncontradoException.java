package com.system.health.domain.exception;

public class ConvenioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public ConvenioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ConvenioNaoEncontradoException(Long cozinhaId) {
		this(String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId));
	}

}
