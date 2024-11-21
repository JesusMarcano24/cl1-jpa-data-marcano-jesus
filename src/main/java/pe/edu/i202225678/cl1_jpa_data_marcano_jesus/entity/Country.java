package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {

    public enum Continent {
        ASIA("Asia"),
        EUROPE("Europe"),
        NORTH_AMERICA("North America"),
        AFRICA("Africa"),
        OCEANIA("Oceania"),
        ANTARCTICA("Antarctica"),
        SOUTH_AMERICA("South America");

        private final String value;

        Continent(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Id
    @Column(name = "Code", nullable = false)
    private String code;

    private String name;

    @Convert(converter = ContinentConverter.class)
    private Continent continent;

    private String region;

    private double surfaceArea;

    private int indepYear;

    private int population;

    private double lifeExpectancy;

    private double gnp;

    private double gnpOld;

    private String localName;

    private String governmentForm;

    private String headOfState;

    private int capital;

    private String code2;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    private List<CountryLanguage> languages;
}
