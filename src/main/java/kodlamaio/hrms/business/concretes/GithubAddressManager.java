package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GithubAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GithubAddressDao;
import kodlamaio.hrms.entities.entities.GithubAddress;

@Service
public class GithubAddressManager implements GithubAddressService {

	private GithubAddressDao githubAddressDao;

	@Autowired
	public GithubAddressManager(GithubAddressDao githubAddressDao) {
		super();
		this.githubAddressDao = githubAddressDao;
	}

	@Override
	public DataResult<List<GithubAddress>> getAll() {
		
		return new SuccessDataResult<List<GithubAddress>>(this.githubAddressDao.findAll(), "GitHub addresses listed");
	}

	@Override
	public Result add(GithubAddress githubAddress) {
		this.githubAddressDao.save(githubAddress);
		return new SuccessResult("GitHub Address added");
	}
	
	
	
	
}
