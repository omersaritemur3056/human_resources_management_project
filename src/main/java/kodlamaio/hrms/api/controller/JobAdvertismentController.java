package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.JobAdvertismentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertismentDto;
import kodlamaio.hrms.entities.entities.JobAdvertisment;

@RestController
@RequestMapping("/api/job_advertisments")
public class JobAdvertismentController {

	private JobAdvertismentService jobAdvertismentService;

	@Autowired
	public JobAdvertismentController(JobAdvertismentService jobAdvertismentService) {
		super();
		this.jobAdvertismentService = jobAdvertismentService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisment>> getAll(){
		return this.jobAdvertismentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertismentDto jobAdvertismentDto) {
		return this.jobAdvertismentService.add(jobAdvertismentDto);
	}
	
//	@PostMapping("/add")
//	public Result add(@RequestBody JobAdvertisment jobAdvertisment) {
//		return this.jobAdvertismentService.add(jobAdvertisment);
//	}

	
//	@GetMapping("/getCompanyNameAndIsActive")
//	public DataResult<List<JobAdvertisment>> getByCompanyNameAndIsActive(@RequestParam("companyName") String companyName)
//	{
//		return this.jobAdvertismentService.getByCompanyNameAndIsActive(companyName);
//	}
	
//	@GetMapping("/getActiveAdvertismentAfter")
//	public DataResult<List<JobAdvertisment>> getActiveAdvertismentAfter(@RequestParam("applicationDeadline") @DateTimeFormat(pattern = "yyyy-MM-dd") Date applicationDeadline) {
//				 
//		return this.jobAdvertismentService.getAdvertismentAfter(applicationDeadline);
//	}
	
	@GetMapping("/getAllActives")
    DataResult<List<JobAdvertisment>> getAllActives(){
        return this.jobAdvertismentService.getAllActives();
    }
	
	@GetMapping("/getAllActivesByCompanyName")
    DataResult<List<JobAdvertisment>> findAllCompanyNameAndIsActive(@RequestParam("companyName") String companyName){
        return this.jobAdvertismentService.findAllCompanyNameAndIsActive(companyName);
    }
	
	@GetMapping("/getAllOrderByApplicationDeadlineAsc")
    DataResult<List<JobAdvertisment>> getAllOrderByApplicationDeadlineAsc(){
        return this.jobAdvertismentService.findAllByOrderByApplicationDeadlineAsc();
    }
	
	
}
