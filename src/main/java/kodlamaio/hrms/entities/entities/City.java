package kodlamaio.hrms.entities.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cities")
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","cities","job","job_advertisments","jobAdvertisments"})
public class City {

	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "country_name")
	private String countryName;
	

	//@JsonManagedReference
	@JsonIgnore(value = true)
	@OneToMany(mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobAdvertisment> jobAdvertisments;
}
