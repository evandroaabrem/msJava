package br.com.otima.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.otima.validation.IdentificacaoConstraint;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "poste")
public class PosteEntity {
	
	@Id
	@SequenceGenerator(name = "perfilseq", sequenceName = "perfilseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfilseq")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "bairro")
	@NotEmpty(message="Mandatory completion")
	@Length(min=2, max=100, message="The length must be between 2 and 100 characters")
	private String bairro;

	@Column(name = "identificacao")
	@IdentificacaoConstraint
	private String identificacao;



}
