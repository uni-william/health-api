package com.system.health.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.health.api.model.ConvenioModel;
import com.system.health.domain.model.Convenio;

@Component
public class ConvenioModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ConvenioModel toModel(Convenio convenio) {
		return modelMapper.map(convenio, ConvenioModel.class);
	}
	
	public List<ConvenioModel> toCollectionModel(List<Convenio> convenios) {
		return convenios.stream()
				.map(convenio -> toModel(convenio))
				.collect(Collectors.toList());
	}
	

}
