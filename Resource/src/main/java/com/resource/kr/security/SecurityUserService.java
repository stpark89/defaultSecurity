package com.resource.kr.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.resource.kr.security.vo.SecurityMember;
import com.resource.kr.security.vo.UseCustomMember;

import lombok.extern.java.Log;

@Log
@Service
public class SecurityUserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("SecurityUserService.loadUserByUsername");
		
		UseCustomMember member = new UseCustomMember();
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		
		member.setUsername(username);
		member.setPassword("1004");
		member.setAuthorities(makeGrantedAuthority(roles));
		return new SecurityMember(member);
	}
	

	  private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
	        List<GrantedAuthority> list = new ArrayList<>();
	        roles.forEach(role -> list.add(new SimpleGrantedAuthority("ROLE_" + role)));
	        return list;
  }

}
