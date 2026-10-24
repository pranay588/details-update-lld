package com.example.LLD.DTO;

import java.util.HashMap;

public class UserRequest {
    private String leadId;
    private HashMap<String, Object> userDtlsReq;

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public HashMap<String, Object> getUserDtlsReq() {
        return userDtlsReq;
    }

    public void setUserDtlsReq(HashMap<String, Object> userDtlsReq) {
        this.userDtlsReq = userDtlsReq;
    }
}