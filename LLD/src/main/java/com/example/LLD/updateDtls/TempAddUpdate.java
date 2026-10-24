package com.example.LLD.updateDtls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;
import com.example.LLD.models.UserTempAdd;
import com.example.LLD.models.UserTempAdd.UserTempAddBuilder;
import com.example.LLD.repo.UserTempAddRepo;
@Component
public class TempAddUpdate implements UpdateDtlsStrategy{
	private UserTempAddRepo userTempAddRepo;
	private final List<String> validation = new ArrayList(List.of(UpdateDtlsConstants.ADD_ONE,UpdateDtlsConstants.ADD_TWO,UpdateDtlsConstants.ADD_THREE));
	public TempAddUpdate( UserTempAddRepo userTempAddRepo){
		this.userTempAddRepo=userTempAddRepo;
	}
	@Override
	public HashMap<String,String> update(String leadId,HashMap<String,Object> dtls){
		HashMap<String,String> res = new HashMap<>();
		res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.FAILUER);
		long paramters = validation.stream().filter(param -> dtls.containsKey(param)).count();
		if(paramters < validation.size())
			return res;
		Optional<UserTempAdd> tempDtls = userTempAddRepo.findById(leadId);
		if(tempDtls.isPresent()) {
			Utility util = new Utility();
			UserTempAddBuilder builder = new UserTempAddBuilder(); 
			UserTempAdd userPermAdd = builder.setId(leadId).
					setAddLineOne(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_ONE))).
					setAddLineTwo(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_TWO))).
					setAddLineThree(util.nullHanling(dtls.get(UpdateDtlsConstants.ADD_THREE))).
					build();
			userTempAddRepo.save(userPermAdd);
			res.put(UpdateDtlsConstants.RESPONSE, UpdateDtlsConstants.SUCCESS);
		}
		return res;
	}

}

