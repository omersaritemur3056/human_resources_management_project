package kodlamaio.hrms;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		
//		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//				"cloud_name", "dsfebmcdy",
//				"api_key", "889147229764614",
//				"api_secret", "EP8_6KWo4PJYnZUoPKDZvfqjf7M",
//				"secure", true));
//		
//		File file = new File("my_image.jpg");
//		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
