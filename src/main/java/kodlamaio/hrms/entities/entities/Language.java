package kodlamaio.hrms.entities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "language_name", unique = true)
	private String languageName;
	
	@Column(name = "language_level")
	@Size(min = 1, max = 5)
	@NotBlank
	@NotNull
	private int languageLevel;
	
	
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	
	
}
