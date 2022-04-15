package me.parzibyte.dao;

import me.parzibyte.modelo.ListaModel;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ListasRepository extends CrudRepository<ListaModel, Integer> {

    public abstract ListaModel findByFecha(Date fecha);
    public abstract ListaModel findByNombre(String nombre);
}
