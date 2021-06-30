package com.system.health.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.health.api.model.input.ConvenioInput;
import com.system.health.domain.model.Convenio;

@Component
public class ConvenioInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Convenio toDomainObject(ConvenioInput convenioInput) {
		return modelMapper.map(convenioInput, Convenio.class);
	}
	
	public void copyToDomainObject(ConvenioInput convenioInput, Convenio convenio) {
		modelMapper.map(convenioInput, convenio);
	}

}
