package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.HumanResourcerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.HumanResourcer;

@RestController
@RequestMapping("/api/human_resourcers")
public class HumanResourcerController {
	
	private HumanResourcerService humanResourcerService;

	@Autowired
	public HumanResourcerController(HumanResourcerService humanResourcerService) {
		super();
		this.humanResourcerService = humanResourcerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<HumanResourcer>> getAll(){
		return this.humanResourcerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody HumanResourcer humanResourcer) {
		return this.humanResourcerService.add(humanResourcer);
	}
}
