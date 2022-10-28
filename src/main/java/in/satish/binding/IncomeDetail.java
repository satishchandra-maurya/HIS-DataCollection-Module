package in.satish.binding;

import lombok.Data;

@Data
public class IncomeDetail {

	private Integer incomeId;
	private Long caseNumber;
	private Double salaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
}
