package com.bcp.challenge.moneyexchange.security;

import com.bcp.challenge.moneyexchange.domain.JpaRole;
import com.bcp.challenge.moneyexchange.domain.JpaUser;
import com.bcp.challenge.moneyexchange.exception.EntityNotFoundException;
import com.bcp.challenge.moneyexchange.repositories.JpaUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private JpaUserRepository userRepository;

    public CustomUserDetailsService(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	JpaUser user = userRepository.findByUsername(username);
    	if (user == null) {
    		throw new EntityNotFoundException("No existe user por username " + username);
    	}
    	Set<JpaRole> roles = new HashSet<>();
    	roles.add(user.getRole());
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
		        user.getPassword(), mapRolesToAuthorities(roles));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<JpaRole> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getDescription())).collect(Collectors.toList());
    }
}