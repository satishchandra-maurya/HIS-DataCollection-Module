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
@Table(name="DC_CAESES")
public class DcCases {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CASE_NUMBER")
	private Long caseNumber;
	
	@Column(name="APP_ID")
	private Integer appId;
	
	@Column(name="PLAN_ID")
	private Integer planId;
}
