package me.parzibyte.modelo;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "listas")
public class ListaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lista",unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private Date fechaCreacion;

    public ListaModel() {
    }

    public ListaModel(String nombre, Date fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
