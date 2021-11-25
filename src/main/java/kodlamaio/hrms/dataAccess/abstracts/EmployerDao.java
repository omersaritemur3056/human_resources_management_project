package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer findByEmail(String email);
	Employer findByEmailIgnoreCase(String email);
	Employer findByWebSiteIgnoreCase(String webSite);
	
	Employer getEmployerById(int id);
	Employer getEmployerByCompanyName(String companyName);
}
