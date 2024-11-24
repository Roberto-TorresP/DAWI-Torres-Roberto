package pe.edu.i202012157.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202012157.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country country = em.find(Country.class, "XYZ");
            if (country != null) {
                em.remove(country);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

