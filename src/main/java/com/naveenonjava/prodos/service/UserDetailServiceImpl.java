//package com.naveenonjava.prodos.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.naveenonjava.prodos.domain.ProdosUser;
//import com.naveenonjava.prodos.repository.ProdosUserRepository;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService{
//	
//	@Autowired
//	private ProdosUserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		ProdosUser prodosUser = userRepository.findByUsername(username);
//		UserDetails user = 
//				new User(username, prodosUser.getPassword(), 
//						AuthorityUtils.createAuthorityList(prodosUser.getRole()));
//		return user;
//	}
//
//}
