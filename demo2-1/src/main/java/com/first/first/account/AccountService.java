//package com.first.first.account;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.jaas.AuthorityGranter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountService implements UserDetailsService {
//
//	@Autowired
//	private AccountRepository accountRepository;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	public Account createAccount(String username, String password) {
//		
//		Account acc = new Account();
//		acc.setUsername(username);
//		acc.setPassword(passwordEncoder.encode(password));
//		
//		return accountRepository.save(acc);
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		Optional<Account> byUsername = accountRepository.findByUsername(username);
//		Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException("ID가 없음"));
//				
//		return new User(account.getUsername(), account.getPassword(),  authorities());
//	}
//
//	private Collection<? extends GrantedAuthority> authorities() {
//		// TODO Auto-generated method stub
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//	}
//	
//	
//	
//	
//	
//}
