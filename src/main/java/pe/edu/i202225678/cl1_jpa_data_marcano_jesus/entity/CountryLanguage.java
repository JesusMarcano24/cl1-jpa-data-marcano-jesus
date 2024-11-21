package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(CountryLanguageId.class)
@Table(name = "countrylanguage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryLanguage {

    @Id
    private String CountryCode;

    @Id
    private String Language;

    private String IsOfficial;

    private double Percentage;

    @ManyToOne
    @JoinColumn (name = "CountryCode", insertable = false, updatable = false)
    @ToString.Exclude
    private Country country;
}