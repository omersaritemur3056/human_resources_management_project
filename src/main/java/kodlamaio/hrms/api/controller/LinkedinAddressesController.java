package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.LinkedinAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.LinkedinAddress;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/linkedinaddresses")
public class LinkedinAddressesController {

	private LinkedinAddressService linkedinAddressService;

	@Autowired
	public LinkedinAddressesController(LinkedinAddressService linkedinAddressService) {
		super();
		this.linkedinAddressService = linkedinAddressService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<LinkedinAddress>> getAll(){
		return this.linkedinAddressService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody LinkedinAddress linkedinAddress) {
		return this.linkedinAddressService.add(linkedinAddress);
	}
	
	
	
}
