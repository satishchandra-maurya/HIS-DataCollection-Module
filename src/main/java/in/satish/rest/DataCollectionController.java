package in.satish.rest;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.satish.binding.Children;
import in.satish.binding.ChildrenRequest;
import in.satish.binding.CreateCaseResponse;
import in.satish.binding.EducationDetails;
import in.satish.binding.IncomeDetail;
import in.satish.binding.PlanSelection;
import in.satish.binding.SummaryScreen;
import in.satish.service.DataCollectionService;

@RestController
public class DataCollectionController {
	
	@Autowired
	private DataCollectionService dataCollectionService;
	
	@GetMapping("/createCase/{appId}")
	public ResponseEntity<CreateCaseResponse> saveCases(@PathVariable Integer appId){
		
		Long caseNumber = dataCollectionService.loadCaseNumber(appId);
		Map<Integer, String> planMap = dataCollectionService.getPlanCategory();
		
		CreateCaseResponse response = new CreateCaseResponse();
		response.setCaseNumber(caseNumber);
		response.setPlanname(planMap);
		
		return new ResponseEntity<> (response, HttpStatus.OK);
		
	}
	
	@PostMapping("/updateCase")
	public ResponseEntity<Long> savePlan(@RequestBody PlanSelection planSelection){
		
		Long caseNumber = dataCollectionService.planSelection(planSelection);
		return new ResponseEntity<> (caseNumber, HttpStatus.OK);
		
	}
	
	@PostMapping("/saveIncome")
	public ResponseEntity<Long>  saveIncome(@RequestBody IncomeDetail incomeDetail){
		
		Long caseNumber = dataCollectionService.saveIncomeDetail(incomeDetail);
		return new ResponseEntity<> (caseNumber, HttpStatus.CREATED);
	}
	
	@PostMapping("/saveEducation")
	public ResponseEntity<Long> saveEducation(@RequestBody EducationDetails educationDetail){
		Long caseNumber = dataCollectionService.saveEduDetail(educationDetail);
		
		return new ResponseEntity<Long> (caseNumber, HttpStatus.CREATED);
	}
	
	@PostMapping("/saveChild")
	public ResponseEntity<SummaryScreen> saveChildrens(ChildrenRequest request){
		Long caseNumber = dataCollectionService.saveChildrenDetail(request);
		SummaryScreen summaryDetails = dataCollectionService.getSummaryDetails(caseNumber);
		return new ResponseEntity<> (summaryDetails, HttpStatus.CREATED);
	}

}









