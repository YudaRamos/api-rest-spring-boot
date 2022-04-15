package me.parzibyte.service;

import me.parzibyte.dao.ProductoRepository;
import me.parzibyte.modelo.ProductoModel;
import me.parzibyte.modelo.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    //devuelve la lista de productos
    public ArrayList<ProductoModel> obtenerProducto() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    //el metodo save si le enviamos el id_usuario lo toma como una actualización
    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    //al usar Optional no lanza error en caso de que el id no exista
    public Optional<ProductoModel> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public ProductoModel obtenerPorCategoria(Integer categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public boolean eliminarProducto(Integer id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
