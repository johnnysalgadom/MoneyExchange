package com.bcp.challenge.moneyexchange.model;

import com.bcp.challenge.moneyexchange.domain.JpaUser;

public class User extends GenericModel<JpaUser>{

	private Role role;

	private String email;
	
	private String username;
	
	private String password;

	@Override
    public JpaUser toEntity() {
    	JpaUser jpaUser = new JpaUser();
    	jpaUser.setId(id);
    	jpaUser.setUsername(username);
    	jpaUser.setPassword(password);
    	jpaUser.setEmail(email);
    	jpaUser.setActive(isActive);
    	jpaUser.setCreated(created);
    	jpaUser.setCreatedBy(createdBy);
    	jpaUser.setUpdated(updated);
    	jpaUser.setUpdatedBy(updatedBy);
        
    	if (role != null) {
            jpaUser.setRole(role.toEntity());
        }

        return jpaUser;
    }

    @Override
    public User fromEntity(JpaUser entity) {

        this.id = entity.getId();
        this.username = entity.getUsername(); 
        this.password = entity.getPassword(); 
        this.email = entity.getEmail(); 
        this.isActive = entity.isActive();
        this.created = entity.getCreated();
        this.createdBy = entity.getCreatedBy();
        this.updated = entity.getUpdated();
        this.updatedBy = entity.getUpdatedBy();

        if (entity.getRole() != null) {
            setRole(new Role().fromEntity(entity.getRole()));
        }
        
        return this;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
