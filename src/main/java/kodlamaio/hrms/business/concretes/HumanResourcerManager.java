package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HumanResourcerService;
import kodlamaio.hrms.dataAccess.abstracts.HumanResourcerDao;
import kodlamaio.hrms.entities.entities.HumanResourcer;

@Service
public class HumanResourcerManager implements HumanResourcerService {

	private HumanResourcerDao humanResourcerDao;

	@Autowired
	public HumanResourcerManager(HumanResourcerDao humanResourcerDao) {
		super();
		this.humanResourcerDao = humanResourcerDao;
	}

	@Override
	public List<HumanResourcer> getAll() {
		
		return this.humanResourcerDao.findAll();
	}
	
}
