package br.com.alura.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.hroauth.entities.User;
import br.com.alura.hroauth.feignClients.UserFeignClients;

@Service
public class UserServices {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserServices.class);
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) {
		User user = userFeignClients.findByEmail(email).getBody();
			if (user == null) {
				logger.error("Email not found: " + email);
				throw new IllegalArgumentException("Email not found");
			}
			logger.error("Email found: " + email);
			return user;
	}
}
