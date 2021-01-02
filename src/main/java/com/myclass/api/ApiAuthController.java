package com.myclass.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.LoginDto;
import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/auth")
public class ApiAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	private UserService userService;
	
	

	/**
	 * @param userService
	 */
	public ApiAuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("register")
	public ResponseEntity<Object> add(@RequestBody UserDto dto) {
		try {
			if (userService.getUserDtoByEmail(dto.getEmail()) == null) {
				userService.save(dto);
				return new ResponseEntity<Object>("Thêm thành công!", HttpStatus.CREATED);
			}
			return new ResponseEntity<Object>("Email đã tồn tại!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("")
	public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
		final String JWT_SECRET = "ChuoiBiMat";
		final long JWT_EXPIRATION = 864000000L;
		Authentication authentication = null;
		String email = loginDto.getEmail();
		String password = loginDto.getPassword();
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//        System.out.println(hashedPassword);
		try {
			System.out.println(email + " " + password);
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//			SecurityContextHolder.getContext().setAuthentication(authentication);
			Date now = new Date();
			Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
			// Nếu đăng nhập thành công thì trả về một token
			String token = Jwts.builder().setSubject(email).setIssuedAt(now).setExpiration(expiryDate)
					.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
			System.out.println(token);
			return new ResponseEntity<Object>(token, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
