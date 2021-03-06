package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.JobAdvertisment;

public interface JobAdvertismentService {

	DataResult<List<JobAdvertisment>> getAll();
	
	Result add(JobAdvertismentDto jobAdvertismentDto); //buna bir query gerekebilir
	
	//Result add(JobAdvertisment jobAdvertisment);
	
	//DataResult<List<JobAdvertisment>> getByCompanyNameAndIsActive(String companyName); 
	
	//DataResult<List<JobAdvertisment>> getAdvertismentAfter(Date applicationDeadline);
	
	DataResult<List<JobAdvertisment>> findAllActives();
	
	DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(String companyName);
	
	DataResult<List<JobAdvertisment>> findAllByOrderByApplicationDeadlineAsc();
	
	
}
