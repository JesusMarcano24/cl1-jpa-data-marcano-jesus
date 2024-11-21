package pe.edu.i202225678.cl1_jpa_data_marcano_jesus;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity.Country;
import pe.edu.i202225678.cl1_jpa_data_marcano_jesus.entity.CountryLanguage;
import pe.edu.i202225678.cl1_jpa_data_marcano_jesus.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataMarcanoJesusApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMarcanoJesusApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		Optional<Country> optional = countryRepository.findById("ARG");
		optional.ifPresentOrElse(
				(country) -> {
					System.out.println("Idiomas de Argentina:");
					System.out.println("aaasa" + country.getLanguages());
					List<CountryLanguage> languages = new ArrayList<>(country.getLanguages());
					languages.forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					System.out.println("Idiomas de Perú:");
					countryRepository.findById("PER").ifPresent(peru -> {
						List<CountryLanguage> languages = new ArrayList<>(peru.getLanguages());
						languages.forEach(language -> System.out.println(language.getLanguage()));
					});
				}
		);

		// usando deleteAllById()
		System.out.println("Eliminando países 'COL' y 'ARG'...");

		List<String> lista = List.of("COL", "ARG");

		lista.stream().filter((id) -> {
            return countryRepository.existsById(id);
        }).collect(Collectors.toList());
        lista.stream().filter(countryRepository::existsById).collect(Collectors.toList());

		countryRepository.deleteAllById(lista);

		System.out.println("Países eliminados.");

		// Volvemos a ejecutar ifPresentOrElse()
		Optional<Country> optional2 = countryRepository.findById("ARG");
		optional2.ifPresentOrElse(
				(country) -> {
					System.out.println("Idiomas de Argentina:");
					System.out.println("aaasa" + country.getLanguages());
					List<CountryLanguage> languages = new ArrayList<>(country.getLanguages());
					languages.forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					System.out.println("Idiomas de Perú:");
					countryRepository.findById("PER").ifPresent(peru -> {
						List<CountryLanguage> languages = new ArrayList<>(peru.getLanguages());
						languages.forEach(language -> System.out.println(language.getLanguage()));
					});
				}
		);
	}
}
