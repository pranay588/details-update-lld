package com.example.LLD.updateDtls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;
import com.example.LLD.models.UserPrsnlDtls;
import com.example.LLD.models.UserPrsnlDtls.UserPrsnlDtlsBuilder;
import com.example.LLD.repo.UserPrsnlDtlsRepo;

@Component
public class PrsnlDtlsUpdate implements UpdateDtlsStrategy{
	private UserPrsnlDtlsRepo userPrsnlDtlsRepo;
	private final List<String> validation = new ArrayList(List.of(UpdateDtlsConstants.NAME,UpdateDtlsConstants.AGE));
	public PrsnlDtlsUpdate(UserPrsnlDtlsRepo userPrsnlDtlsRepo){
		this.userPrsnlDtlsRepo = userPrsnlDtlsRepo;
	}
	@Override
	public HashMap<String,String> update(String leadId,HashMap<String,Object> dtls){
		HashMap<String,String> res = new HashMap<>();
		res.put("REPONSE", "FAILUER");
		long paramters = validation.stream().filter(param -> dtls.containsKey(param)).count();
		if(paramters < validation.size())
			return res;
		Optional<UserPrsnlDtls> prsnlDtls = userPrsnlDtlsRepo.findById(leadId);
		if(prsnlDtls.isPresent()) {
			Utility util = new Utility();
			UserPrsnlDtlsBuilder builder = new UserPrsnlDtlsBuilder(); 
			UserPrsnlDtls userPrsnlDtls = builder.setId(leadId).
					setName(util.nullHanling(dtls.get(UpdateDtlsConstants.NAME))).
					setAge(util.nullHanling(dtls.get(UpdateDtlsConstants.AGE))).
					build();
			userPrsnlDtlsRepo.save(userPrsnlDtls);
			res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.SUCCESS);
		}
		return res;
	}

}
