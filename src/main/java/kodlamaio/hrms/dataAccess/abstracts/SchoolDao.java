package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	
	List<School> findAllByResume_IdOrderByGraduateDate(int resumeId);
	
	List<School> findAllByResume_IdOrderByGraduateDateDesc(int resumeId);
	
	
}
