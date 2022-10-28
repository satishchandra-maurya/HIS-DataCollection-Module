package in.satish.binding;

import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponse {

	private Long caseNumber;
	private Map<Integer, String> planname;
}
