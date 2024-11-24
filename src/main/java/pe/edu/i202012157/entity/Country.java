package pe.edu.i202012157.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String code;

    private String name;

    private String continent;

    private String region;

    private float surfaceArea;

    private int population;

    private String localName;

    private String governmentForm;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<CountryLanguage> languages;


    public Country() {
    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int population, String localName, String governmentForm, Set<City> cities, Set<CountryLanguage> languages) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.cities = cities;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", cities=" + cities +
                ", languages=" + languages +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<CountryLanguage> languages) {
        this.languages = languages;
    }
}