package br.com.otima.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.otima.entity.PerfilEntity;
import br.com.otima.entity.UsuarioEntity;
import br.com.otima.enumeration.PerfilEnum;
import br.com.otima.payload.request.LoginRequest;
import br.com.otima.payload.request.LogoutRequest;
import br.com.otima.payload.response.JwtResponse;
import br.com.otima.payload.response.MessageResponse;
import br.com.otima.repository.RoleRepository;
import br.com.otima.repository.UsuarioRepository;
import br.com.otima.security.jwt.JwtUtils;
import br.com.otima.security.services.UserDetailsImpl;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JwtUtils jwtUtils;
	
	private static String erroValue = "Error: Role is not found.";
	
	private static String sucessoValue = "User registered successfully!";
	
	private static String bearerValue = "Bearer";
	
	private static String userNameAlready =  "Username is already taken!";
	
	private static String emailAlready =  "Email is already in use!";

	public JwtResponse loginUser(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		
		
		return JwtResponse.builder().token(jwt).id(userDetails.getId()).type(bearerValue).status(HttpStatus.OK.value())
				.username(userDetails.getUsername()).email(userDetails.getEmail()).roles(roles).build();

	}

	public MessageResponse logoutUser(LogoutRequest logoutRequest) {

		if (Boolean.TRUE.equals(userRepository.existsByUsername(logoutRequest.getUsername()))) {
			return MessageResponse.builder().message(userNameAlready).build();
		}

		if (Boolean.TRUE.equals(userRepository.existsByEmail(logoutRequest.getEmail()))) {
			return MessageResponse.builder().message(emailAlready).build();
		}

	    // Create new user's account
	    UsuarioEntity user = UsuarioEntity.builder()
	    		.username(logoutRequest.getUsername())
	    		.email(logoutRequest.getEmail())
	    		.password(encoder.encode(logoutRequest.getPassword()))
	    		.build();
	    
	    Set<String> strRoles = logoutRequest.getRole();
	    Set<PerfilEntity> roles = new HashSet<>();
	    
	    if (strRoles == null) {
	        PerfilEntity userRole = roleRepository.findByName(PerfilEnum.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException(erroValue));
	        roles.add(userRole);
	      } else {
	        strRoles.forEach(role -> {
	          switch (role) {
	          case "admin":
	            PerfilEntity adminRole = roleRepository.findByName(PerfilEnum.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException(erroValue));
	            roles.add(adminRole);

	            break;
	          case "mod":
	            PerfilEntity modRole = roleRepository.findByName(PerfilEnum.ROLE_MODERATOR)
	                .orElseThrow(() -> new RuntimeException(erroValue));
	            roles.add(modRole);

	            break;
	          default:
	            PerfilEntity userRole = roleRepository.findByName(PerfilEnum.ROLE_USER)
	                .orElseThrow(() -> new RuntimeException(erroValue));
	            roles.add(userRole);
	          }
	        });
	      }
	    
	    user.setRoles(roles);
	    
	    
	    userRepository.save(user);
		
		return MessageResponse.builder().message(sucessoValue).build();
	}

}
