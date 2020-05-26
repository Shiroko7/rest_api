package com.example.rest_api.medico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//basicamente una tabla de la BD 

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "estado")
    private String estado;

    public Medico()
    {

    }

    public Long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCargo()
    {
        return cargo;
    }

    public String getEstado()
    {
        return estado;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }    
    


}