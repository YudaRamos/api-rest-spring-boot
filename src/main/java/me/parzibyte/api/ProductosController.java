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
package me.parzibyte.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping(path = "/producto")
@CrossOrigin(origins = "http://localhost")
public class ProductosController {
    //realiza la inyeccion de dependencias
    @Autowired
    private ProductoRepository productoRepository;
    //@PostMapping
    @PostMapping(value = "/crear")
    public Producto crearAlumno( @Validated @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
    //@GetMapping
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public Iterable<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findUserById(@PathVariable(value = "id") long id) {
        Optional<Producto> producto = productoRepository.findById(id);

        if(producto.isPresent()) {
            return ResponseEntity.ok().body(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable() Long id) {
        productoRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public Producto editar(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}
