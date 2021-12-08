package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.entities.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;


	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
	}



	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seekers listed");
	}

	
	
	private Result isEmailExist(String email) {
		if(this.jobSeekerDao.findByEmail(email) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result isNationalityIdExist(String nationalityId) {
		if(this.jobSeekerDao.findByNationalityId(nationalityId) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	
	
	
	
	@Override
	public Result add(JobSeeker jobSeeker) throws Exception {
		if(!this.isEmailExist(jobSeeker.getEmail()).isSuccess() || !this.isNationalityIdExist(jobSeeker.getNationalityId()).isSuccess()) {
			return new ErrorResult("failed");
		}
		
		
		
		  Result checkedPerson; 
		  
		  checkedPerson = mernisCheckService.checkIfRealPerson(jobSeeker);
		  
		  
		  if(!this.mernisCheckService.checkIfRealPerson(jobSeeker).isSuccess()) {
			  
			  return new ErrorResult("Person not a valid");
			  
			  //mernis doğrulaması tamamlanmıştır.
		  }
		  
		 
		 
		
		if(!this.emailVerificationService.verifyEmail(jobSeeker.getEmail()).isSuccess()) {
			return new ErrorResult("Check your email please");
		}
		
		this.jobSeekerDao.saveAndFlush(jobSeeker);
		return new SuccessResult("Job seeker saved");
	}
}
