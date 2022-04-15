package me.parzibyte.dao;

import me.parzibyte.modelo.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Integer> {
public abstract UsuarioModel findByEmail(String email);
}
