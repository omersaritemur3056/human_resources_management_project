package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.JobExperince;
import kodlamaio.hrms.entities.entities.Resume;
import kodlamaio.hrms.entities.entities.School;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findAllById(int id);
	
	//Resume findById(int id);
	
	
	//List<School> findByOrderByGraduateDate();
	
	
	//List<School> findByOrderByGraduateDateDesc();
	
	
	
	//List<JobExperince> findByOrderByDateOfEndDesc();
	
	
}
