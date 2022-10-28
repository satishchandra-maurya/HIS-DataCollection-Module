package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.DcCases;

public interface DcCasesRepo extends JpaRepository<DcCases, Serializable>{

}
