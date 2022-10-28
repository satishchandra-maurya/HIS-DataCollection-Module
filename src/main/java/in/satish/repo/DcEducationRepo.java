package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.DcEducation;

public interface DcEducationRepo extends JpaRepository<DcEducation, Serializable>{

	public DcEducation findByCaseNumber(Long caseNumber);
}
