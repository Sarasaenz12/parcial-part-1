package org.arle.entity;

import jakarta.persistence.*;

public class CalzadoListener {

    @PrePersist
    public void prePersist(Calzado calzado) {
        System.out.println("Calzado a ser persistido: " + calzado);
    }

    @PostPersist
    public void postPersist(Calzado calzado) {
        System.out.println("Calzado persistido: " + calzado);
    }

    @PreUpdate
    public void preUpdate(Calzado calzado) {
        System.out.println("Calzado a ser actualizado: " + calzado);
    }

    @PostUpdate
    public void postUpdate(Calzado calzado) {
        System.out.println("Calzado actualizado: " + calzado);
    }

    @PreRemove
    public void preRemove(Calzado calzado) {
        System.out.println("Calzado a ser eliminado: " + calzado);
    }

    @PostRemove
    public void postRemove(Calzado calzado) {
        System.out.println("Calzado eliminado: " + calzado);
    }
}
