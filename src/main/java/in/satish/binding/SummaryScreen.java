package in.satish.binding;

import java.util.List;

import lombok.Data;

@Data
public class SummaryScreen {
	
	private IncomeDetail income;
	private EducationDetails edu;
	private List<Children> kids;
	private String planName;
	
	
}
