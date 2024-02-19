package com.DWR.DWR_Record.serviceIMPL;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.repository.EmployeeRepository;
import com.DWR.DWR_Record.response.AuthenticationResponse;
import com.DWR.DWR_Record.service.AuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public AuthenticationResponse login(String loginId, String password) {
		 EmployeeEntity employee = employeeRepository.findByLoginId(loginId);
		 
		 if (employee != null) {
	            // Check if the provided password matches the stored hashed password
	            if (passwordEncoder.matches(password, employee.getPassword())) {
//	            	if ("admin".equals(employee.getRole())) {
	                // Generate and return a token (you may use JWT or any other authentication mechanism)
	                String token = generateJwtToken(employee.getId(), employee.getLoginId());
	                String role = employee.getRole();
	                String name = employee.getFirstName() + " " + employee.getLastName();
	                Long id = employee.getId();
	                return new AuthenticationResponse("Login Success", token, true, role, id, name);
//	            	}
	            }
	        }
		return new AuthenticationResponse("Login Failed", null, false, null, null, null);
	}
	
	private String generateJwtToken(Long userId, String username) {
        // Set the expiration time for the token (e.g., 1 day)
		long expirationTimeInMillis = 24 * 3600000; // 1 day
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);

        // Build the JWT token using a secret key
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Build the JWT token
        String token = Jwts.builder()
                .setSubject(userId.toString()) // Set the subject (user ID)
                .setIssuedAt(new Date()) // Set the issuance time
                .setExpiration(expirationDate) // Set the expiration time
                .setIssuer("DWR_Record") // Set the issuer
                .claim("Abhi", username) // Add custom claims (optional)
                .signWith(secretKey) // Sign the token with a secret key
                .compact();

        return token;
    }

	
	
	
}
