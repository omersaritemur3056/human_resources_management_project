package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertismentDto {

	private int id;
    private int cityId;
    private int employerId;
    private String description;
    private String cityName;
    private int minSalary;
    private int maxSalary;
    private String companyName;
    private Date applicationDeadline;
    private int openPositions;
    private boolean isActive;
    
   @Null(message = "must be null")
    private LocalDateTime releaseDateTime = LocalDateTime.now();
}
