package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.verifications.abstracts.MyApproveService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.entities.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private MyApproveService myApproveService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			MyApproveService myApproveService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.myApproveService = myApproveService;
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");
		
	}
	
	
	
	private Result isEmailExist(String email) {
		if(employerDao.findByEmail(email) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	
	
	

	@Override
	public Result add(Employer employer) {
		if(!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("email already exist");
		}
		
		
		if(!this.myApproveService.isApprovedFromMe(employer).isSuccess()) {
			return new ErrorResult("Employer not approved form H.R personel");
		}
		if(!this.emailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Check your email please");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}
	
}
