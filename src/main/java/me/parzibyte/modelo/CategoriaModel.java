package me.parzibyte.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria",unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer propietario;

    public CategoriaModel() {
    }

    public CategoriaModel(String nombre, String descripcion, Integer propietario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPropietario() {
        return propietario;
    }

    public void setPropietario(Integer propietario) {
        this.propietario = propietario;
    }
}
