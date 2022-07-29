package br.com.otima.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuario")
public class UsuarioEntity {

	@Id
	@SequenceGenerator(name = "usuarioseq", sequenceName = "usuarioseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioseq")
	private Integer id;

	private String username;

	private String nome;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "senha")
	private String password;

	private String email;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private Set<PerfilEntity> roles = new HashSet<>();

}