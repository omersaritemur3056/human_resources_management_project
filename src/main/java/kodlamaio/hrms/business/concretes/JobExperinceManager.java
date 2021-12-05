package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperinceDao;
import kodlamaio.hrms.entities.entities.JobExperince;

@Service
public class JobExperinceManager implements JobExperinceService {

	private JobExperinceDao jobExperinceDao;

	@Autowired
	public JobExperinceManager(JobExperinceDao jobExperinceDao) {
		super();
		this.jobExperinceDao = jobExperinceDao;
	}

	@Override
	public DataResult<List<JobExperince>> getAll() {
		
		return new SuccessDataResult<List<JobExperince>>(this.jobExperinceDao.findAll(), "Job experinces listed");
	}

	@Override
	public Result add(JobExperince jobExperince) {
		this.jobExperinceDao.save(jobExperince);
		return new SuccessResult("Job experince added");
	}

	@Override
	public DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEnd(int resumeId) {
		
		return new SuccessDataResult<List<JobExperince>>(this.jobExperinceDao.findAllByResume_IdOrderByDateOfEnd(resumeId), "Listed Jobseeker's experinces");
	}

	@Override
	public DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEndDesc(int resumeId, Direction direction) {
		
		return new SuccessDataResult<List<JobExperince>>(this.jobExperinceDao.findAllByResume_IdOrderByDateOfEndDesc(resumeId), "Listed the experinces order by DESC");
	}
	
	
	
}
