package com.oktaTraining;

import java.util.ArrayList;
import java.util.List;



import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class Controller {

	
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public @ResponseBody ObjectNode validationResponseHook(@RequestHeader HttpHeaders headers) {
		
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		
		List< String> list = headers.get("x-okta-verification-challenge");
		
	    for (String string : list) {
			
	    	
	    	
	    	node.put("verification", string);
		}
		
		return node;
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, path="/")
	public String ResponseHook(@RequestBody String body) {
		
		
	
		return body;
		
		
	}
	
	
	
	
}
