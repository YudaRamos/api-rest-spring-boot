package me.parzibyte.service;

import me.parzibyte.dao.UsuarioRepository;
import me.parzibyte.modelo.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //devuelve la lista de usuarios
    public ArrayList<UsuarioModel> obtenerUsuario() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //el metodo save si le enviamos el id_usuario lo toma como una actualización
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    //al usar Optional no lanza error en caso de que el id no exista
    public Optional<UsuarioModel> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean eliminarusuario(Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
