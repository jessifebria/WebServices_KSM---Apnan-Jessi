/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mccoc.webservice.services;

import com.mccoc.webservice.entities.Matkul;
import com.mccoc.webservice.entities.ksm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JESSI
 */
@Service
public class KsmRestService {
    
    private final String uri = "http://localhost:8087/api";
    
    private static final RestTemplate resttemplate = new RestTemplate();
    
    public List<Matkul> getbynim(){
        ResponseEntity<List<Matkul>> respon = resttemplate.exchange(
                uri, 
                HttpMethod.GET, 
                HttpEntity.EMPTY, 
                new ParameterizedTypeReference<List<Matkul>>() {}
        );
    return respon.getBody();
    }
    
    public void savetoksm(ksm ksm){
        ksm hasil= resttemplate.postForObject(uri+"/{kode}/{nim}",ksm, ksm.class);
    }
    
    public void delete(String kode, String nim){
        Map<String, String> param = new HashMap<>();
        param.put("kode", kode);
        param.put("nim", nim);
        resttemplate.delete(uri+"/{kode}/{nim}",param);
    }
    
    


}
