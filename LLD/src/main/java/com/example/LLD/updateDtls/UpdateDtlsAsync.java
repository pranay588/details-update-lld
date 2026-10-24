package com.example.LLD.updateDtls;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.LLD.Strategy.UpdateDtlsStrategy;
import com.example.LLD.constants.UpdateDtlsConstants;

@Component
public class UpdateDtlsAsync {
	
	public ResponseEntity<String> asyncUpdate(String leadId,List<UpdateDtlsStrategy> updatingList,HashMap<String,Object> usrDtls){
		List<CompletableFuture<HashMap<String,String>>> futures = updatingList.stream().map(cls -> CompletableFuture.supplyAsync(()->cls.update(leadId,usrDtls))).toList();
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
		List<HashMap<String,String>> successRate = allFutures.thenApply(f -> futures.stream().map(CompletableFuture::join).toList()).join();
		long successRateValue = successRate.stream().filter(mp -> mp.get(UpdateDtlsConstants.RESPONSE).equals(UpdateDtlsConstants.SUCCESS)).count();
		return successRateValue < updatingList.size() ? 
				new ResponseEntity<>(UpdateDtlsConstants.NOT_UPDATED_SUCCESSFULLY,HttpStatus.NOT_FOUND) : 
					new ResponseEntity<>(UpdateDtlsConstants.SUCCESS,HttpStatus.OK);
	}
	
}
