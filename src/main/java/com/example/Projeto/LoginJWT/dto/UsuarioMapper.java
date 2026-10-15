package com.example.Projeto.LoginJWT.dto;

import com.example.Projeto.LoginJWT.entity.Usuario;

public class UsuarioMapper {

  public static Usuario of(UsuarioCriacaoDto usuarioCriacaoDto) {
    Usuario usuario = new Usuario();

    usuario.setEmail(usuarioCriacaoDto.getEmail());
    usuario.setSenha(usuarioCriacaoDto.getSenha());

    return usuario;
  }

  public static Usuario of(UsuarioLoginDto usuarioLoginDto) {
    Usuario usuario = new Usuario();

    usuario.setEmail(usuarioLoginDto.getEmail());
    usuario.setSenha(usuarioLoginDto.getSenha());

    return usuario;
  }

  public static UsuarioTokenDto of(Usuario usuario, String token) {
    UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();

    usuarioTokenDto.setUserId(usuario.getId());
    usuarioTokenDto.setEmail(usuario.getEmail());
    usuarioTokenDto.setToken(token);

    return usuarioTokenDto;
  }

  public static UsuarioSessaoDto ofSessao(UsuarioTokenDto tokenDto) {
    UsuarioSessaoDto dto = new UsuarioSessaoDto();

    dto.setUserId(tokenDto.getUserId());
    dto.setEmail(tokenDto.getEmail());

    return dto;
  }

  public static UsuarioListarDto of(Usuario usuario) {
    UsuarioListarDto usuarioListarDto = new UsuarioListarDto();

    usuarioListarDto.setId(usuario.getId());
    usuarioListarDto.setEmail(usuario.getEmail());

    return usuarioListarDto;
  }
}