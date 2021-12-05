package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.City;

public interface CityDao extends JpaRepository<City, Integer> {

	City findCityById(int id);
	City findCityByCityName(String cityName);
}
