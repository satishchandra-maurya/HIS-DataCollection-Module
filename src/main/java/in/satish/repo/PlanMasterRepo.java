package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.PlanMaster;

public interface PlanMasterRepo extends JpaRepository<PlanMaster, Serializable>{

	
}
