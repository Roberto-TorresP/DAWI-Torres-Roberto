package pe.edu.i202012157.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode")
    private Country country;

    private String isOfficial;

    private float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguageId id, Country country, String isOfficial, float percentage) {
        this.id = id;
        this.country = country;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
