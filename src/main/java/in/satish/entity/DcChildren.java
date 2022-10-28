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
@Table(name="DC_CHILDRENS")
public class DcChildren {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CHILDREN_ID")
	private Integer childrenId;
	
	@Column(name="CASE_NUMBER")
	private Long caseNumber;
	
	@Column(name="CHILDREN_SSN")
	private Long childrenSsn;
	
	@Column(name="CHILDREN_AGE")					
	private Integer childrenAge;
	
	@Column(name="CHILDREN_NAME")					
	private String childrenName;
	
	
}
