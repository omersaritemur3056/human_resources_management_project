package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.GithubAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.GithubAddress;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/githubadresses")
public class GithubAddressesControllers {

	private GithubAddressService githubAddressService;

	@Autowired
	public GithubAddressesControllers(GithubAddressService githubAddressService) {
		super();
		this.githubAddressService = githubAddressService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<GithubAddress>> getAll(){
		return this.githubAddressService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody GithubAddress githubAddress) {
		return this.githubAddressService.add(githubAddress);
	}
	
	
	
}
