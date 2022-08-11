package com.example.midestino.model;

import java.io.Serializable;

public class ItemList implements Serializable {
    private String nombre;
    private String descripcion;
    private String image;


    public String getnombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

    public String getImageResource() {return image;}

    public ItemList(String nombre, String descripcion, String imageResource) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = imageResource;
    }

}
