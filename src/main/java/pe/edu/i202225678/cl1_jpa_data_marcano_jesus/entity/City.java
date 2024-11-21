package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String Name;

    private String District;

    private int Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    @ToString.Exclude
    private Country country;

}