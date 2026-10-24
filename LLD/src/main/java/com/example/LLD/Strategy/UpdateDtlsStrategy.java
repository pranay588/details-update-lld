package com.example.LLD.Strategy;

import java.util.HashMap;

public interface UpdateDtlsStrategy {

	HashMap<String,String> update(String leadId,HashMap<String,Object> dtls);	
	
}
