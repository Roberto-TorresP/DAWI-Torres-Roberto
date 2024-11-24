package pe.edu.i202012157.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202012157.entity.City;
import pe.edu.i202012157.entity.Country;
import pe.edu.i202012157.entity.CountryLanguage;
import pe.edu.i202012157.entity.CountryLanguageId;

import java.util.HashSet;
import java.util.Set;


public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear país imaginario
            Country country = new Country();
            country.setCode("XYZ");
            country.setName("Imaginaria");
            country.setContinent("South America");
            country.setRegion("Fictional Region");
            country.setSurfaceArea(100000);
            country.setPopulation(1000000);
            country.setLocalName("Imaginaria");
            country.setGovernmentForm("Republic");

            // Crear ciudades
            Set<City> cities = new HashSet<>();
            for (int i = 1; i <= 3; i++) {
                City city = new City();
                city.setName("Ciudad " + i);
                city.setDistrict("District " + i);
                city.setPopulation(100000 * i);
                city.setCountry(country);
                cities.add(city);
            }
            country.setCities(cities);

            // Crear lenguajes
            Set<CountryLanguage> languages = new HashSet<>();
            String[] langs = {"Imagines", "Ficticio"};
            for (String lang : langs) {
                CountryLanguage cl = new CountryLanguage();
                cl.setId(new CountryLanguageId(country.getCode(), lang));
                cl.setCountry(country);
                cl.setIsOfficial("T");
                cl.setPercentage(50.0f);
                languages.add(cl);
            }
            country.setLanguages(languages);

            em.persist(country);
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
