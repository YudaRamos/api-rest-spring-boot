/*

  ____          _____               _ _           _       
 |  _ \        |  __ \             (_) |         | |      
 | |_) |_   _  | |__) |_ _ _ __ _____| |__  _   _| |_ ___ 
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) | |_| | | |  | (_| | |   / /| | |_) | |_| | ||  __/
 |____/ \__, | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |        
        |___/                               |___/         
    
____________________________________
/ Si necesitas ayuda, contáctame en \
\ https://parzibyte.me               /
 ------------------------------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
Creado por Parzibyte (https://parzibyte.me). Este encabezado debe mantenerse intacto,
excepto si este es un proyecto de un estudiante.
*/
package me.parzibyte.controller;


import me.parzibyte.dao.ProductoRepository;
import me.parzibyte.modelo.ProductoModel;
import me.parzibyte.modelo.UsuarioModel;
import me.parzibyte.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
/**
@RestController
@RequestMapping(path = "/producto")
@CrossOrigin(origins = "http://localhost")*/
@RestController
@RequestMapping("/producto")
public class ProductosController {

    //realiza la inyeccion de dependencias
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> obtenerProducto() {
        return productoService.obtenerProducto();
    }

    //el metodo save() del servicio devuelve un usuario con el id incluido @PostMapping(value = "/crear")
    @PostMapping
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return this.productoService.guardarProducto(producto);
    }

   /**
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> findProductById(@PathVariable(value = "id") Integer id) {
        Optional<ProductoModel> producto = productoService.obtenerPorId(id);

        if(producto.isPresent()) {
            return ResponseEntity.ok().body(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    //especificamos al controlador que la ruta debe especificar el parámetro id
    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Integer id) {
        return this.productoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ProductoModel obtenerPorCategoria(@RequestParam("categoria")Integer categoria){
        return this.productoService.obtenerPorCategoria(categoria);
    }
/**
 *
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable() Long id) {
        productoRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ProductoModel editar(@RequestBody ProductoModel productoModel) {
        return productoRepository.save(productoModel);
    }*/
}
