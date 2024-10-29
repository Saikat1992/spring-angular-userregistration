package com.javatechie.security;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javatechie.dto.UserInfo;
import com.javatechie.util.MyConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	//private String secret = generateSecretKey();
	private String secret = MyConstant.SECRET_KEY;
    private int jwtExpirationMs = 1000 * 60 * 60; 
    
    public String generateToken(UserInfo userInfo) {
    	
    	Map<String, Object> claimMap= new HashMap<String, Object>();
    	claimMap.put("userId", userInfo.getId());
    	claimMap.put("name", userInfo.getName());
    	
    	@SuppressWarnings("deprecation")
		String token= Jwts.builder()
    			.setClaims(claimMap)
    			.setSubject(userInfo.getName())
    			.setIssuedAt(new Date())
    			.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMs))
    			.signWith(SignatureAlgorithm.HS256, secret)
    			.compact();
    	return token;
    }
    
    
	
	  public String getUserNameFromToken(String token) {
	  
		  String name= Jwts.parser().setSigningKey(MyConstant.SECRET_KEY) 
			       .parseClaimsJws(token)
			       .getBody()
			       .getSubject();
		  return name;
			  
	}
	 
    
    public static String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; 
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key); 
    }

}
