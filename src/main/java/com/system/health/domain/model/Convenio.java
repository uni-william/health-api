package com.system.health.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Convenio {
	
	@Id
	@SequenceGenerator(sequenceName="convenio_id_seq", name="convenio_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="convenio_seq", strategy=GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;

}