package com.bcp.challenge.moneyexchange.payload;

import lombok.Data;

@Data
public class TokenResponseDto {

	private String username;
    
	private String token;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

}
