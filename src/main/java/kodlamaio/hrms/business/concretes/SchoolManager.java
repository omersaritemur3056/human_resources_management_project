package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.entities.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Schools listed");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School added");
	}
	
	@Override
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDate(int resumeId) {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByResume_IdOrderByGraduateDate(resumeId), "Listed Jobseeker's experinces");
	}

	@Override
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDateDesc(int resumeId, Direction direction) {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByResume_IdOrderByGraduateDateDesc(resumeId), "Listed the experinces order by DESC");
	}
}
