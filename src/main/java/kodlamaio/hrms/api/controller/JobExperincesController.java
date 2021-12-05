package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.JobExperince;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/jobexperinces")
public class JobExperincesController {

	private JobExperinceService jobExperinceService;

	@Autowired
	public JobExperincesController(JobExperinceService jobExperinceService) {
		super();
		this.jobExperinceService = jobExperinceService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<JobExperince>> getAll(){
		return this.jobExperinceService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobExperince jobExperince) {
		return this.jobExperinceService.add(jobExperince);
	}
	
	
	@GetMapping(value = "/getallbyresumeiddateofend")
	public DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEnd(@RequestParam int resumeId){
		return this.jobExperinceService.findAllByResume_IdOrderByDateOfEnd(resumeId);
	}
	
	@GetMapping(value = "/getallbyresumeiddateofenddesc")
	public DataResult<List<JobExperince>> findAllByResume_IdOrderByDateOfEndDesc(@RequestParam int resumeId, @RequestParam Direction direction){
		return this.jobExperinceService.findAllByResume_IdOrderByDateOfEndDesc(resumeId, direction);
	}
}
