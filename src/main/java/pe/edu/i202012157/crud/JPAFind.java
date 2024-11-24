package pe.edu.i202012157.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202012157.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        try {
            Country peru = em.find(Country.class, "PER");
            if (peru != null) {
                System.out.println("Ciudades peruanas con población mayor a 700,000:");
                peru.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName() +
                                " - Población: " + city.getPopulation()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
