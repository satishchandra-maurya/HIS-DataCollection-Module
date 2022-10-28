package in.satish.binding;

import java.util.List;

import lombok.Data;

@Data
public class ChildrenRequest {

	private Long caseNumber;
	
	private List<Children> childs;
}
