//package com.naveenonjava.prodos;
//
//import static org.springframework.http.ResponseEntity.ok;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.naveenonjava.prodos.domain.ProdosUser;
//import com.naveenonjava.prodos.dto.AccountCredentials;
//import com.naveenonjava.prodos.repository.ProdosUserRepository;
//import com.naveenonjava.prodos.security.JwtAuthenticationService;
//
//@RestController
//public class AuthenticationController {
//	
//	@Autowired
//	AuthenticationManager authenticationManager;
//	
//	@Autowired
//	ProdosUserRepository prodosUserRepository;
//	
//	@Autowired
//	JwtAuthenticationService jwtAuthenticationService;
//	
//	@PostMapping("/auth/login")
//	public ResponseEntity<Map<Object, Object>> 
//					signin(@RequestBody AccountCredentials credentials) {
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							credentials.getUsername(), credentials.getPassword()));
//			List<String> list = new ArrayList<>();
//			
//			ProdosUser user = this.prodosUserRepository.findByUsername(credentials.getUsername());
//			if( user == null ) {
//				throw new UsernameNotFoundException("Username " + credentials.getUsername() + "not found");
//			}
//			list.add(user.getRole());
//			/*list.add(this.prodosUserRepository.findByUsername(credentials.getUsername())
//					.orElseThrow(
//							() -> new UsernameNotFoundException("Username " + credentials.getUsername() + "not found"))
//					.getRole());*/
//			
//			String token = jwtAuthenticationService.createToken(credentials.getUsername(), list);
//			Map<Object, Object> model = new HashMap<>();
//			model.put("username", credentials.getUsername());
//			model.put("token", token);
//			return ok(model);
//		}catch (AuthenticationException e) {
//			throw new BadCredentialsException("Invalid username/password supplied");
//		}
//	}
//}
