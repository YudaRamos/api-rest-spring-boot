package me.parzibyte.dao;

import me.parzibyte.modelo.CategoriaModel;
import me.parzibyte.modelo.ProductoModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<CategoriaModel, Integer> {
    public abstract CategoriaModel findByNombre(String nombre);
}
