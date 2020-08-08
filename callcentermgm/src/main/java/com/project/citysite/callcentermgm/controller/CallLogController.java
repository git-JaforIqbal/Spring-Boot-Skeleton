package com.project.citysite.callcentermgm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.project.citysite.callcentermgm.entity.Beneficiary;
import com.project.citysite.callcentermgm.entity.MainBean;
import javax.validation.Valid;

@RestController
public class CallLogController {

	public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public MainBean getWelcomeMessage() {
		MainBean bean = new MainBean("Welcome to Spring Boot");
		return bean;
	}
	
	@RequestMapping(value = "getCallHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> getCallHistory(){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code",202);
        body.put("status", HttpStatus.ACCEPTED);
        body.put("data", "Successfylly updated");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
	}
	
//	public Map<String, String> getCallHistory() {
//		HashMap<String, String> map = new HashMap<>();
//	    map.put("key", "value");
//	    map.put("foo", "bar");
//	    map.put("aa", "bb");
//	    return map;
//	}
	
	
    @PostMapping(path = "/beneficiary")
    public ResponseEntity<Object> addBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code",202);
        body.put("status", HttpStatus.ACCEPTED);
        body.put("data", "Successfylly updated");
        return new ResponseEntity<>(body, HttpStatus.ACCEPTED);
    }
	
}
