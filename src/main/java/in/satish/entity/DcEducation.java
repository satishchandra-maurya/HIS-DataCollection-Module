package in.satish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_EDUCATION")
public class DcEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EDU_ID")
	private Integer eduId;
	
	@Column(name="CASE_NUMBER")
	private Long caseNumber;
	
	@Column(name="GRADUTATION_YEAR")
	private Long graduationYear;
					
	@Column(name="HIGHEST_QUALIFICATION")
	private String highestQualification;
}
