package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkedinAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkedinAddressDao;
import kodlamaio.hrms.entities.entities.LinkedinAddress;

@Service
public class LinkedinAddressManager implements LinkedinAddressService {

	private LinkedinAddressDao linkedinAddressDao;

	@Autowired
	public LinkedinAddressManager(LinkedinAddressDao linkedinAddressDao) {
		super();
		this.linkedinAddressDao = linkedinAddressDao;
	}

	@Override
	public DataResult<List<LinkedinAddress>> getAll() {
		
		return new SuccessDataResult<List<LinkedinAddress>>(this.linkedinAddressDao.findAll(), "LinkedIn addresses listed");
	}

	@Override
	public Result add(LinkedinAddress linkedinAddress) {
		this.linkedinAddressDao.save(linkedinAddress);
		return new SuccessResult("LinkedIn address added");
	}
	
	
	
	
}
