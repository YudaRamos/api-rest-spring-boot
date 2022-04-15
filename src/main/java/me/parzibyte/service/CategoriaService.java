package me.parzibyte.service;

import me.parzibyte.dao.CategoriaRepository;
import me.parzibyte.dao.ProductoRepository;
import me.parzibyte.modelo.CategoriaModel;
import me.parzibyte.modelo.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class CategoriaService {
    @Autowired
    CategoriaRepository categoriarepository;

    //devuelve la lista de productos
    public ArrayList<CategoriaModel> obtenerCategoria() {
        return (ArrayList<CategoriaModel>) categoriarepository.findAll();
    }

    //el metodo save si le enviamos el id_usuario lo toma como una actualización
    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriarepository.save(categoria);
    }

    //al usar Optional no lanza error en caso de que el id no exista
    public Optional<CategoriaModel> obtenerPorId(Integer id) {
        return categoriarepository.findById(id);
    }

    public CategoriaModel obtenerPorNombre(String nombre) {
        return categoriarepository.findByNombre(nombre);
    }

    public boolean eliminarCategoria(Integer id) {
        try {
            categoriarepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
