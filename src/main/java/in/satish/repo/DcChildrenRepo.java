package in.satish.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.DcChildren;

public interface DcChildrenRepo extends JpaRepository<DcChildren, Serializable>{

	public List<DcChildren> findByCaseNumber(Long caseNumber);
}
