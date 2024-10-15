package org.example.aplication.service;

import org.example.domain.Calzado;
import org.example.interfaces.CalzadoRepository;

import java.util.List;

public class CalzadoServiceImpl implements CalzadoService {
    private final CalzadoRepository calzadoRepository;

    public CalzadoServiceImpl(CalzadoRepository calzadoRepository) {
        this.calzadoRepository = calzadoRepository;
    }

    @Override
    public List<Calzado> findAll() {
        return calzadoRepository.findAll();
    }

    @Override
    public Calzado findById(int id) {
        return calzadoRepository.findById(id);
    }

    @Override
    public void save(Calzado calzado) {
        validarCalzado(calzado);
        calzadoRepository.save(calzado);
    }

    @Override
    public void update(Calzado calzado) {
        validarCalzado(calzado);
        calzadoRepository.update(calzado);
    }

    @Override
    public void delete(int id) {
        calzadoRepository.delete(id);
    }

    private void validarCalzado(Calzado calzado) {
        if (calzado.getMarca().isEmpty()) {
            throw new IllegalArgumentException("La marca del calzado no puede estar vacío");
        }
        if (calzado.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del calzado debe ser mayor a cero");
        }
    }
}
