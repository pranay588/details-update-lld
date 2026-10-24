package com.example.LLD.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;
import com.example.LLD.updateDtls.PermAddUpdate;
import com.example.LLD.updateDtls.ProfDtlsUpdate;
import com.example.LLD.updateDtls.PrsnlDtlsUpdate;
import com.example.LLD.updateDtls.TempAddUpdate;
import com.example.LLD.updateDtls.UpdateDtlsAsync;
@Service
public class UpdateDtlsSvc {
	private PermAddUpdate permAddUpdate;
	private ProfDtlsUpdate profDtlsUpdate;
	private PrsnlDtlsUpdate prsnlDtlsUpdate;
	private TempAddUpdate tempAddUpdate;
	private UpdateDtlsAsync updateDtlsAsync;
	public UpdateDtlsSvc(PermAddUpdate permAddUpdate,ProfDtlsUpdate profDtlsUpdate,PrsnlDtlsUpdate prsnlDtlsUpdate,TempAddUpdate tempAddUpdate,UpdateDtlsAsync updateDtlsAsync) {
		this.permAddUpdate=permAddUpdate;
		this.profDtlsUpdate=profDtlsUpdate;
		this.prsnlDtlsUpdate=prsnlDtlsUpdate;
		this.tempAddUpdate=tempAddUpdate;
		this.updateDtlsAsync=updateDtlsAsync;
	}
	public ResponseEntity<String> userDetails(String leadId,HashMap<String,Object> userReq){
			List<String> flags;
			List<UpdateDtlsStrategy> updatingList = new ArrayList<>();
			if(userReq.get(UpdateDtlsConstants.FLAGS) instanceof List) {
				flags = (List<String>) userReq.get(UpdateDtlsConstants.FLAGS);
				if(flags.contains(UpdateDtlsConstants.ADD) && flags.contains(UpdateDtlsConstants.PER_PROF)) {
					updatingList.add(permAddUpdate);
					updatingList.add(tempAddUpdate);
					updatingList.add(profDtlsUpdate);
					updatingList.add(prsnlDtlsUpdate);
				}
				else if(flags.contains(UpdateDtlsConstants.ADD)) {
					updatingList.add(permAddUpdate);
					updatingList.add(tempAddUpdate);
				}
				else if(flags.contains(UpdateDtlsConstants.PER_PROF)) {
					updatingList.add(profDtlsUpdate);
					updatingList.add(prsnlDtlsUpdate);
				}
				HashMap<String,Object> filteredMap = (HashMap<String,Object>)userReq.get(UpdateDtlsConstants.DTLS); 
				return updateDtlsAsync.asyncUpdate(leadId,updatingList,filteredMap);
			}
		return new ResponseEntity<>(UpdateDtlsConstants.USER_DOES_NOT_EXIST,HttpStatus.NOT_FOUND);
	}
}