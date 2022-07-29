package br.com.otima.entity;

import javax.persistence.*;

import br.com.otima.enumeration.PerfilEnum;

@Entity
@Table(name = "perfil")
public class PerfilEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "nome", length = 20)
  private PerfilEnum name;

  public PerfilEntity() {

  }

  public PerfilEntity(PerfilEnum name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PerfilEnum getName() {
    return name;
  }

  public void setName(PerfilEnum name) {
    this.name = name;
  }
}