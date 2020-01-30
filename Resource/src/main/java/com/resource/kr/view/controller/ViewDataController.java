package com.resource.kr.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.kr.security.CustomAuthenticationProvider;

import lombok.extern.java.Log;

@Log
@RestController
public class ViewDataController {
	

	@Autowired
	private CustomAuthenticationProvider authenticationManager;
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/ajaxLogin")
	public String ajaxLogin(String id, String pass) { 
	   UsernamePasswordAuthenticationToken authReq
	      = new UsernamePasswordAuthenticationToken(id, pass);
	    Authentication auth = authenticationManager.authenticate(authReq);
	    
	    log.info("로그인-------------------------------------");
	    System.out.println(auth.isAuthenticated());
	    log.info(auth.getName());
	    
	    
	    return "";
	}
}
