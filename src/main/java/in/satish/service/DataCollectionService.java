package in.satish.service;

import java.util.List;
import java.util.Map;

import in.satish.binding.EducationDetails;
import in.satish.binding.IncomeDetail;
import in.satish.binding.Children;
import in.satish.binding.ChildrenRequest;
import in.satish.binding.PlanSelection;
import in.satish.binding.SummaryScreen;

public interface DataCollectionService {
	
	// for Create Case screen, this method send AppId as input and generate caseId 
	// and return caseNUmber
	public Long loadCaseNumber(Integer appId); 
	
	// this method called for displaying Plan Name
	public Map<Integer, String> getPlanCategory();  
	
	// For Plan Selection Screen we take a binding class as Two input Parameter 
	// and return caseNumber so am taking return type as Long
	public Long planSelection(PlanSelection planSr);
	
	// Income Details Screen, this method save the income detail and return caseNUmber
	//so am taking Long as Return type and using binding class for the screen input
	public Long  saveIncomeDetail(IncomeDetail incomeDetail);
	
	// Education Detail Screen, this method save the education detail and generate 
	//educationId so am taking Long as return type for caseNumber return type
	// Am using EducationDetails as binding class for screen input
	public Long saveEduDetail(EducationDetails eduDetails);
	
	// For Kids Details Screen, this method saved Kids Details & generate childrenId
	// taking return type as Long for case Number
	public Long saveChildrenDetail(ChildrenRequest childs);
	
	// this method for summary Details am using binding class as SummaryScreen
	public SummaryScreen getSummaryDetails(Long caseNumber);
	
}
