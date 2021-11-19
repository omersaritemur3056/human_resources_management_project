package kodlamaio.hrms.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.abstracts.MyApproveService;
import kodlamaio.hrms.entities.entities.Employer;

@Service   //Servis işlemi gören böyle classlara bu anotasyonu vermezsen hata fırlatır
public class MyApproveManager implements MyApproveService { 

	@Override
	public Result isApprovedFromMe(Employer employer) {  //Egoistiz şu sıralar :)
		
		return new SuccessResult(); 
	}   

	
}
