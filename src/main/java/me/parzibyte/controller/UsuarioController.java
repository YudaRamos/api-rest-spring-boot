package me.parzibyte.controller;

import me.parzibyte.modelo.UsuarioModel;
import me.parzibyte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuario() {
        return usuarioService.obtenerUsuario();
    }

    //el metodo save() del servicio devuelve un usuario con el id incluido
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }
    //especificamos al controlador que la ruta debe especificar el parámetro id
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public UsuarioModel obtenerPorEmail(@RequestParam("email")String email){
        return this.usuarioService.obtenerPorEmail(email);
    }
}
