package com.system.health.api.core.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableModelOpenApi {
	
	@ApiModelProperty(example = "0", value =  "Número da página (começa em 0)")
	private int page;
	
	@ApiModelProperty(example = "10", value =  "Quantidade de elementos por página")
	private int size;
	
	@ApiModelProperty(example = "nome, asc", value = "Nome do campo de ordenação")
	private List<String> sort;

}
