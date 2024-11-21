package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Country.Continent, String> {

    @Override
    public String convertToDatabaseColumn(Country.Continent continent) {
        if (continent == null) {
            return null;
        }
        return continent.toString();
    }

    @Override
    public Country.Continent convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        for (Country.Continent continent : Country.Continent.values()) {
            if (continent.toString().equals(dbData)) {
                return continent;
            }
        }
        throw new IllegalArgumentException("Unknown continent value: " + dbData);
    }
}