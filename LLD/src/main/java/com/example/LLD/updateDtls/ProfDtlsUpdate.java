package com.example.LLD.updateDtls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;
import com.example.LLD.models.UserProfDtls;
import com.example.LLD.models.UserProfDtls.UserProfDtlsBuilder;
import com.example.LLD.repo.UserProfDtlsRepo;

@Component
public class ProfDtlsUpdate implements UpdateDtlsStrategy{
	private UserProfDtlsRepo userProfDtlsRepo;
	private final List<String> validation = new ArrayList(List.of(UpdateDtlsConstants.OCCUP,UpdateDtlsConstants.SALARY));
	public ProfDtlsUpdate(UserProfDtlsRepo userProfDtlsRepo){
		this.userProfDtlsRepo=userProfDtlsRepo;
	}
	@Override
	public HashMap<String,String> update(String leadId,HashMap<String,Object> dtls){
		System.out.println(dtls.toString());
		HashMap<String,String> res = new HashMap<>();
		res.put("REPONSE", "FAILUER");
		long paramters = validation.stream().filter(param -> dtls.containsKey(param)).count();
		if(paramters < validation.size())
			return res;
		Optional<UserProfDtls> profDtls = userProfDtlsRepo.findById(leadId);
		if(profDtls.isPresent()) {
			Utility util = new Utility();
			UserProfDtlsBuilder builder = new UserProfDtlsBuilder(); 
			UserProfDtls userProfDtls = builder.setId(leadId).
					setOccupation(util.nullHanling(dtls.get(UpdateDtlsConstants.OCCUP))).
					setSalary(util.nullHanling(dtls.get(UpdateDtlsConstants.SALARY))).
					build();
			userProfDtlsRepo.save(userProfDtls);
			res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.SUCCESS);
		}
		return res;
	}
	
}


