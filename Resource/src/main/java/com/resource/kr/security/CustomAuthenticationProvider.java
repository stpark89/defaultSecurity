package com.resource.kr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.resource.kr.security.vo.SecurityMember;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private SecurityUserService securityUserService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println(">>>>>>>>>>>>>");
		System.out.println("이름 : " +authentication.getName());
		System.out.println("pw : "+authentication.getCredentials().toString());
		SecurityMember member =  (SecurityMember) securityUserService.loadUserByUsername(authentication.getName());
		
		System.out.println("로그인 테스트중---");
		System.out.println(member.toString());
		System.out.println("로그인 테스트중---");
		
		return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), member.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
