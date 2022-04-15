package me.parzibyte.controller;

import me.parzibyte.modelo.CategoriaModel;
import me.parzibyte.modelo.UsuarioModel;
import me.parzibyte.service.CategoriaService;
import me.parzibyte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ArrayList<CategoriaModel> obtenerCategoria() {
        return categoriaService.obtenerCategoria();
    }

    //el metodo save() del servicio devuelve un usuario con el id incluido
    @PostMapping
    public CategoriaModel guardarcategoria(@RequestBody CategoriaModel categoria) {
        return this.categoriaService.guardarCategoria(categoria);
    }
    //especificamos al controlador que la ruta debe especificar el parámetro id
    @GetMapping(path = "/{id}")
    public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id") Integer id) {
        return this.categoriaService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public CategoriaModel obtenerPorNombre(@RequestParam("nombre")String nombre){
        return this.categoriaService.obtenerPorNombre(nombre);
    }

}
