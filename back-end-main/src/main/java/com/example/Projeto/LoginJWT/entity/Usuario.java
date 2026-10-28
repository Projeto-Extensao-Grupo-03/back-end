package com.example.Projeto.LoginJWT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "acesso")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // Mapeia para a coluna "usuario" do banco, mas mantém o nome "email" no Java para facilitar com o JWT
  @Column(name = "usuario")
  private String email;

  private String senha;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}