package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.entities.JobAdvertisment;

public interface JobAdvertismentDao extends JpaRepository<JobAdvertisment, Integer> {
	
	
//	@Query("select j from JobAdvertisment j where j.employer.companyName >= :companyName and j.isActive = true")  
//	List<JobAdvertisment> findByCompanyNameAndIsActive(String companyName);
	
	
//	@Query("select j from JobAdvertisment j where j.applicationDeadline >= :applicationDeadline")
//    List<JobAdvertisment> findAllWithApplicationDeadlineAfter(@Param("applicationDeadline") Date applicationDeadline);
	
	
	List<JobAdvertisment> findAllByIsActiveTrue();
	
	
	List<JobAdvertisment> findAllByEmployer_CompanyNameAndIsActiveTrue(@Param("companyName") String companyName);
	
	
	List<JobAdvertisment> findAllByOrderByApplicationDeadlineAsc();
	
	//add metotu için bir query gerekebilir
	
}
