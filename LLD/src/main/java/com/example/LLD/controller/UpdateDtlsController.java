package com.example.LLD.controller;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.LLD.DTO.UserRequest;
import com.example.LLD.service.UpdateDtlsSvc;

@RestController
@RequestMapping("/dtls")
public class UpdateDtlsController {
	private UpdateDtlsSvc updateDtlsSvc;
	public UpdateDtlsController(UpdateDtlsSvc updateDtlsSvc){
		this.updateDtlsSvc=updateDtlsSvc;
	}
	@PostMapping("/update")
	ResponseEntity<String> updateDtls(@RequestBody UserRequest userRequest){
		String leadId = userRequest.getLeadId();
		HashMap<String,Object> userDtls = userRequest.getUserDtlsReq();
		return updateDtlsSvc.userDetails(leadId, userDtls);
	}
}



//postman request POST 'http://localhost:8083/dtls/update' \
//--header 'Content-Type: application/json' \
//--body '{
//  "leadId":"7",
//  "userDtlsReq":{
//      "flags":["add"],
//      "dtls":{
//          "addOne":"address line one",
//          "addTwo":"address line two",
//          "addThree":"address line three"
//      }
//
//  }
//}'



