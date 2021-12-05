package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.entities.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service  //bu anotasyonu unutmak yok businesste kullanacağız
public class MernisCheckManager implements MernisCheckService {

	
	@Override
	public Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()),
				jobSeeker.getFirstName().toUpperCase(new Locale("tr","TR")),
				jobSeeker.getLastName().toUpperCase(new Locale("tr","TR")),
				Integer.parseInt(jobSeeker.getBirthOfYear()));
		
		if(!result) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

}
