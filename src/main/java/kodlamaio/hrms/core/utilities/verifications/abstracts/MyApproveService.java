package kodlamaio.hrms.core.utilities.verifications.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Employer;

public interface MyApproveService { //benim onayımdan geçiti mi bakim? :)

	public Result isApprovedFromMe(Employer employer);
} 
