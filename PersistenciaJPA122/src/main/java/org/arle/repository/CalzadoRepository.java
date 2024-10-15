package org.arle.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.arle.entity.Calzado;

import java.util.List;

public class CalzadoRepository {

    private final EntityManagerFactory emf;

    public CalzadoRepository() {

        emf = Persistence.createEntityManagerFactory("calzadpPU");
    }

    public void crear(Calzado calzado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(calzado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Calzado leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Calzado.class, id);
        } finally {
            em.close();
        }
    }

    public List<Calzado> leerTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Calzado p", Calzado.class)
                    .getResultList();
        }
    }

    public void actualizar(Calzado calzado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(calzado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Calzado calzado = em.find(Calzado.class, id);
            if (calzado != null) {
                em.remove(calzado);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}