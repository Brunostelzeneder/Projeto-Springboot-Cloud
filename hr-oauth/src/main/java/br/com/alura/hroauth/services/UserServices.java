package br.com.alura.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.hroauth.entities.User;
import br.com.alura.hroauth.feignClients.UserFeignClients;

@Service
public class UserServices implements UserDetailsService {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserServices.class);
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) {
		User user = userFeignClients.findByEmail(email).getBody();
			if (user == null) {
				logger.error("Email not found: " + email);
				throw new IllegalArgumentException("Email not found");
			}
			logger.info("Email found: " + email);
			return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClients.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found: " + username);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: " + username);
		return user;
}


}
