package in.satish.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.satish.binding.EducationDetails;
import in.satish.binding.IncomeDetail;
import in.satish.binding.Children;
import in.satish.binding.ChildrenRequest;
import in.satish.binding.PlanSelection;
import in.satish.binding.SummaryScreen;
import in.satish.entity.CitizenApp;
import in.satish.entity.DcCases;
import in.satish.entity.DcChildren;
import in.satish.entity.DcEducation;
import in.satish.entity.DcIncome;
import in.satish.entity.PlanMaster;
import in.satish.repo.CitizenAppRepo;
import in.satish.repo.DcCasesRepo;
import in.satish.repo.DcChildrenRepo;
import in.satish.repo.DcEducationRepo;
import in.satish.repo.DcIncomeRepo;
import in.satish.repo.PlanMasterRepo;

@Service
public class DataCollectionServiceImpl implements DataCollectionService{
	
	@Autowired
	private DcCasesRepo caseRepo;
	
	@Autowired
	private DcChildrenRepo dcChildrenRepo;
	
	@Autowired
	private DcEducationRepo dcEducationRepo;
	
	@Autowired
	private DcIncomeRepo dcIncomeRepo;
	
	@Autowired
	private  CitizenAppRepo citizenAppRepo;
	
	@Autowired
	private PlanMasterRepo planMasterRepo;
	
	Random random = new Random();
	
	@Override
	public Long loadCaseNumber(Integer appId) {
		Optional<CitizenApp> findById = citizenAppRepo.findById(appId);
		if(findById.isPresent()) {
			DcCases dcCases = new DcCases();
			dcCases.setAppId(appId);
			caseRepo.save(dcCases);
			return dcCases.getCaseNumber();
		}
		return 0l;
		
	}

	@Override
	public Map<Integer, String> getPlanCategory() {
		List<PlanMaster> findAll = planMasterRepo.findAll();
		Map<Integer, String> planMap = new HashMap<>();
		for(PlanMaster entity:findAll) {
			planMap.put(entity.getPlanId(), entity.getPlanName());
		}
		
		return planMap;
	}

	@Override
	public Long planSelection(PlanSelection planSr) {
		Optional<DcCases> findById = caseRepo.findById(planSr.getCaseNumber());
		if(findById.isPresent()) {
			DcCases dcCases = findById.get();
			dcCases.setPlanId(planSr.getPlanId());
			caseRepo.save(dcCases);
			return planSr.getCaseNumber();
		}
		return null;
		
	}

	@Override
	public Long saveIncomeDetail(IncomeDetail incomeDetail) {
		DcIncome dcIncome = new DcIncome();
		dcIncome.setCaseNumber(incomeDetail.getCaseNumber());
		dcIncome.setEmpIncome(incomeDetail.getSalaryIncome() + incomeDetail.getRentIncome());
		dcIncome.setPropertyIncome(incomeDetail.getPropertyIncome());
		dcIncomeRepo.save(dcIncome);
		return dcIncome.getCaseNumber();
	}

	@Override
	public Long saveEduDetail(EducationDetails eduDetails) {
		DcEducation dcEducation = new DcEducation();
		BeanUtils.copyProperties(eduDetails, dcEducation);
		dcEducationRepo.save(dcEducation);
		return dcEducation.getCaseNumber();
	}

	@Override
	public Long saveChildrenDetail(ChildrenRequest request) {
		
		List<Children> childs = request.getChilds();
		for(Children c: childs) {
			DcChildren dcChildren = new in.satish.entity.DcChildren();
			dcChildren.setCaseNumber(request.getCaseNumber());
			dcChildren.setChildrenAge(c.getChildAge());
			BeanUtils.copyProperties(c, dcChildren);
			
			dcChildrenRepo.save(dcChildren);
		}
		return request.getCaseNumber();
	}

	@Override
	public SummaryScreen getSummaryDetails(Long caseNumber) {
		
		String planName = "";
	
		//getting the data from the table
		DcIncome incomeEntity = dcIncomeRepo.findByCaseNumber(caseNumber);
		DcEducation educationEntity = dcEducationRepo.findByCaseNumber(caseNumber);
		List<DcChildren> childrenEntity = dcChildrenRepo.findByCaseNumber(caseNumber);
		
      
		Optional<DcCases> dcCases = caseRepo.findById(caseNumber);
		if(dcCases.isPresent()) {
			Integer planId = dcCases.get().getPlanId();
			Optional<PlanMaster> planEntity = planMasterRepo.findById(planId);
			if(planEntity.isPresent()) {
				planName = planEntity.get().getPlanName();
			}
		}
		
		// setting the data into summaryScreen object
		SummaryScreen summaryScreen = new SummaryScreen();
		summaryScreen.setPlanName(planName);
		
		IncomeDetail incomeDetail = new IncomeDetail();
		BeanUtils.copyProperties(incomeEntity, incomeDetail);
		summaryScreen.setIncome(incomeDetail);
		
		EducationDetails eduDetails = new EducationDetails();
		BeanUtils.copyProperties(educationEntity,eduDetails);
		summaryScreen.setEdu(eduDetails);
		
		List<Children> childs = new ArrayList<>();
		for(DcChildren entity:childrenEntity) {
			Children ch = new Children();
			BeanUtils.copyProperties(entity, ch);
			childs.add(ch);
		}
		summaryScreen.setKids(childs);
		
		return summaryScreen;
	}
	


}
