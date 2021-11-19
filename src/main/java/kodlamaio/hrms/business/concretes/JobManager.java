package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.entities.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Job positions listed");
	}
	
	
	

	private Result isTitlesExist(String titles) {
		if(jobDao.findByTitles(titles) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	

	@Override
	public Result add(Job job) {
		if(!this.isTitlesExist(job.getTitles()).isSuccess()) {
			return new ErrorResult("Titles already exist");
		}
		this.jobDao.save(job);
		return new SuccessResult("Job titles added");
	}
}
