package org.example.domain;

import java.io.Serializable;

public class Calzado implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String marca;
    private double precio;

    // Constructores, getters y setters

    public Calzado() {
    }

    public Calzado(int id, String marca, double precio) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                '}';
    }
}