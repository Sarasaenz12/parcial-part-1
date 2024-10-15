package org.example.aplication.service;

import org.example.domain.Calzado;

import java.util.List;

public interface CalzadoService {
    List<Calzado> findAll();
    Calzado findById(int id);
    void save(Calzado calzado);
    void update(Calzado calzado);
    void delete(int id);
}