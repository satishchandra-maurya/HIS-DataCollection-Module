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
@Table(name="DC_INCOME")
public class DcIncome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INCOME_ID")
	private Integer incomeId;
	
	@Column(name="CASE_NUMBER")
	private Long caseNumber;
	
	@Column(name="EMP_INCOME")
	private Double empIncome;
	
	@Column(name="PROPERTY_INCOME")
	private Double propertyIncome;
}
