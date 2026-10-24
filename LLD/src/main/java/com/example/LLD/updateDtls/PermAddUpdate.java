package com.example.LLD.updateDtls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;
import com.example.LLD.models.UserPermAdd;
import com.example.LLD.models.UserPermAdd.UserPermAddBuiler;
import com.example.LLD.repo.UserPermAddRepo;
@Component
public class PermAddUpdate implements UpdateDtlsStrategy{
	private UserPermAddRepo userPermAddRepo;
	private final List<String> validation = new ArrayList(List.of(UpdateDtlsConstants.ADD_ONE,UpdateDtlsConstants.ADD_TWO,UpdateDtlsConstants.ADD_THREE));
	public PermAddUpdate(UserPermAddRepo userPermAddRepo) {
		this.userPermAddRepo = userPermAddRepo;
	}
	@Override
	public HashMap<String,String> update(String leadId,HashMap<String,Object> dtls){
		HashMap<String,String> res = new HashMap<>();
		res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.FAILUER);
		long paramters = validation.stream().filter(param -> dtls.containsKey(param)).count();
		if(paramters < validation.size())
			return res;
		Optional<UserPermAdd> permDtls = userPermAddRepo.findById(leadId);
		if(permDtls.isPresent()) {
			Utility util = new Utility();
			UserPermAddBuiler builder = new UserPermAddBuiler(); 
			UserPermAdd userPermAdd = builder.setId(leadId).
			setAddLineOne(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_ONE))).
			setAddLineTwo(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_TWO))).
			setAddLineThree(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_THREE))).
			build();
			userPermAddRepo.save(userPermAdd);
			res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.SUCCESS);
		};
		return res;
	}
}
