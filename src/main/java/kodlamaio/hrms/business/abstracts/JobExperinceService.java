package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.JobExperince;

public interface JobExperinceService {

	DataResult<List<JobExperince>> getAll();
	Result add(JobExperince jobExperince);
	
	DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEnd(int resumeId);
	
	DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEndDesc(int resumeId, Direction direction);
}
