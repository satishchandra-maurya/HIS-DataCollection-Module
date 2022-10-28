package in.satish.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_APP")
public class CitizenApp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="APP_ID")
	private Integer appId;
				
	@Column(name="FULLNAME")
	private String fullName;
					
	@Column(name="EMAIL")
	private String email;
		
	@Column(name="PHONE_NUMBER")
	private Long phoneNo;
					
	@Column(name="GENDER")
	private String gender;				
	
	@Column(name="SSN")
	private Long ssn;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
}
