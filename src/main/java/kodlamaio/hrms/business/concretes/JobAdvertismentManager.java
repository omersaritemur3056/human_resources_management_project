package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertismentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertismentDao;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.JobAdvertisment;

@Service
public class JobAdvertismentManager implements JobAdvertismentService {

	private JobAdvertismentDao jobAdvertismentDao;
	private CityDao cityDao;
    private EmployerDao employerDao;

	@Autowired
	public JobAdvertismentManager(JobAdvertismentDao jobAdvertismentDao, CityDao cityDao, EmployerDao employerDao) {
		super();
		this.jobAdvertismentDao = jobAdvertismentDao;
		this.cityDao = cityDao;
        this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<JobAdvertisment>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAll(), "Job advertisment listed");
	}

	@Override
	public Result add(JobAdvertismentDto jobAdvertismentDto) {
		
		JobAdvertisment jobAdvertisment = new JobAdvertisment();
		
		jobAdvertisment.setActive(jobAdvertisment.isActive()?true:false);  //buna true parametresi geçilebilir ancak swagger kısmında false denemek için boş bıraktım. Bu sayede false atayabildim.
        jobAdvertisment.setMinSalary(jobAdvertismentDto.getMinSalary());
        jobAdvertisment.setMaxSalary(jobAdvertismentDto.getMaxSalary());
        jobAdvertisment.setDescription(jobAdvertismentDto.getDescription());
        jobAdvertisment.setOpenPositions(jobAdvertismentDto.getOpenPositions());
        jobAdvertisment.setApplicationDeadline(jobAdvertismentDto.getApplicationDeadline());
        jobAdvertisment.setReleaseDateTime(jobAdvertismentDto.getReleaseDateTime());
        
        jobAdvertisment.setCity(this.cityDao.findCityById(jobAdvertismentDto.getCityId()));
        jobAdvertisment.setCity(this.cityDao.findCityByCityName(jobAdvertismentDto.getCityName()));
        jobAdvertisment.setEmployer(this.employerDao.findEmployerById(jobAdvertismentDto.getEmployerId())); //ileride yazılacak manipülasyonlar id üzerinde gerçekleşir.(update, delete gibi)
        jobAdvertisment.setEmployer(this.employerDao.findEmployerByCompanyName(jobAdvertismentDto.getCompanyName()));
        
		this.jobAdvertismentDao.save(jobAdvertisment);
		return new SuccessResult("Job advertisment added");
	}

	
//	@Override
//	public Result add(JobAdvertisment jobAdvertisment) {
//		this.jobAdvertismentDao.save(jobAdvertisment);
//		return new SuccessResult("Job advertisment listed");
//	}
	
//	@Override
//	public DataResult<List<JobAdvertisment>> findByCompanyNameAndIsActive(String companyName) {
//		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findByCompanyNameAndIsActive(companyName),"Listed the advertisment");
//	}
	
//	@Override
//	public DataResult<List<JobAdvertisment>> findAdvertismentAfter(Date applicationDeadline) {
//		return new SuccessDataResult<List<JobAdvertisment>> (this.jobAdvertismentDao.findAllWithApplicationDeadlineAfter(applicationDeadline),  "Listed Job advertisment ordered by released datetime");
//	}
	
	
	
	
	
	@Override
    public DataResult<List<JobAdvertisment>> findAllActives() {
        return new SuccessDataResult<>(this.jobAdvertismentDao.findAllByIsActiveTrue());
    }

	@Override
	public DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAllByEmployer_CompanyNameAndIsActiveTrue(companyName), "Listed the advertisments");
	}

	@Override
	public DataResult<List<JobAdvertisment>> findAllByOrderByApplicationDeadlineAsc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisment>>(this.jobAdvertismentDao.findAllByOrderByApplicationDeadlineAsc(),"Listed job advertisment order by order application deadline ascend");
	}

	
	
	
}
