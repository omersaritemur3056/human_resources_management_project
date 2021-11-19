package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HumanResourcerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<HumanResourcer>> getAll() {
		
		return new SuccessDataResult<List<HumanResourcer>>(this.humanResourcerDao.findAll(), "İnsan kaynakları personeli eklendi");
	}

	
	
	
	@Override
	public Result add(HumanResourcer humanResourcer) {

		this.humanResourcerDao.save(humanResourcer);
		return new SuccessResult("İnsan kaynakları personeli eklendi");
	}
	
}
