package kolokvijum2.app.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum2.app.model.AuthRequest;
import kolokvijum2.app.model.AuthResponse;
import kolokvijum2.app.security.JwtUtil;
import kolokvijum2.app.service.GostService;



@Controller
public class AuthenticationCtrl {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	GostService serviceAuth;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getLozinka()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Pogresni podaci", e);
		}
		
		final UserDetails userDetails = serviceAuth.loadUserByUsername(authRequest.getEmail());
		final String jwt = util.generateToken(userDetails);
	
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
}
