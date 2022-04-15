package me.parzibyte.service;

import me.parzibyte.dao.ListasRepository;
import me.parzibyte.dao.ProductoRepository;
import me.parzibyte.modelo.ListaModel;
import me.parzibyte.modelo.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class ListasService {
    @Autowired
    ListasRepository listasRepository;

    //devuelve la lista de productos
    public ArrayList<ListaModel> obtenerLista() {
        return (ArrayList<ListaModel>) listasRepository.findAll();
    }

    //el metodo save si le enviamos el id_usuario lo toma como una actualización
    public ListaModel guardarLista(ListaModel lista) {
        return listasRepository.save(lista);
    }

    //al usar Optional no lanza error en caso de que el id no exista
    public Optional<ListaModel> obtenerPorId(Integer id) {
        return listasRepository.findById(id);
    }

    public ListaModel obtenerPorNombre(String nombre) {
        return listasRepository.findByNombre(nombre);
    }

    public boolean eliminarProducto(Integer id) {
        try {
            listasRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
