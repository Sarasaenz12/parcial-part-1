package org.arle.service;

import org.arle.entity.Calzado;
import org.arle.repository.CalzadoRepository;

import java.util.List;

public class CalzadoService {

    private final CalzadoRepository repository;

    public CalzadoService() {
        this.repository = new CalzadoRepository();
    }

    public void crearCalzado(Calzado calzado) {
        repository.crear(calzado);
    }

    public Calzado obtenerCalzado(Long id) {
        return repository.leer(id);
    }

    public List<Calzado> obtenerTodosLosCalzado() {
        return repository.leerTodos();
    }

    public void actualizarCalzado(Calzado calzado) {
        repository.actualizar(calzado);
    }

    public void eliminarCalzado(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
