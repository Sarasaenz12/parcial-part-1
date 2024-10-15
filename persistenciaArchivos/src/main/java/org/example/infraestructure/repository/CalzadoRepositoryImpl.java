package org.example.infraestructure.repository;

import org.example.domain.Calzado;
import org.example.interfaces.CalzadoRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalzadoRepositoryImpl implements CalzadoRepository {
    private static final String FILE_NAME = "calzado.dat";

    @Override
    public List<Calzado> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Calzado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Calzado findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Calzado calzado) {
        List<Calzado> calzados = findAll();
        calzados.add(calzado);
        saveAll(calzados);
    }

    @Override
    public void update(Calzado calzado) {
        List<Calzado> calzados = findAll();
        for (int i = 0; i < calzados.size(); i++) {
            if (calzados.get(i).getId() == calzado.getId()) {
                calzados.set(i, calzado);
                break;
            }
        }
        saveAll(calzados);
    }
        /*        .map(p -> p.getId() == calzado.getId() ? calzado : p)
                .collect(Collectors.toList());
        saveAll(calzados);
    }
*/
    @Override
    public void delete(int id) {
        List<Calzado> calzados = findAll();
        calzados = calzados.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(calzados);
    }

    private void saveAll(List<Calzado> calzados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(calzados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
