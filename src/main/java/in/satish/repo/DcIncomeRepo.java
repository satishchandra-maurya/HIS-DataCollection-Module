package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.DcIncome;

public interface DcIncomeRepo extends JpaRepository<DcIncome, Serializable>{

	public DcIncome findByCaseNumber(Long caseNumber);
}
