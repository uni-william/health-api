package com.system.health.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConvenioInput {
	
	@NotBlank
	private String nome;
	
}
