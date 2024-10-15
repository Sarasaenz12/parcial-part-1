package org.example.interfaces;

import org.example.domain.Calzado;

import java.util.List;

public interface CalzadoRepository {
    List<Calzado> findAll();
    Calzado findById(int id);
    void save(Calzado calzado);
    void update(Calzado calzado);
    void delete(int id);
}