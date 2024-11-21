package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryLanguageId implements Serializable {

    private String CountryCode;
    private String Language;
}