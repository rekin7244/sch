package com.kh.scheduler.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kh.scheduler.model.User;

public class UserPrincipal implements UserDetails {
	
	private String userId;
	private String password;
	
	public UserPrincipal(String userId, String password) {
		this.userId=userId;
		this.password=password;
	}
	
	public static UserPrincipal create(User user) {
		
		System.out.println("user.getpassword :: " + user);

        return new UserPrincipal(
                user.getUserId(),
                user.getPassword()
        );
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
