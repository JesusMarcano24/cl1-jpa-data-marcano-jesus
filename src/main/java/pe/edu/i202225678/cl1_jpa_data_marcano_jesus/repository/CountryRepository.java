package pe.edu.i202225678.cl1_jpa_data_marcano_jesus.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}