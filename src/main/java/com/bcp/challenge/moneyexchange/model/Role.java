package com.bcp.challenge.moneyexchange.model;

import com.bcp.challenge.moneyexchange.domain.JpaRole;

public class Role extends GenericModel<JpaRole>{

    private String description;
    
    @Override
    public JpaRole toEntity() {
    	JpaRole jpaRole = new JpaRole();
    	jpaRole.setId(id);
    	jpaRole.setDescription(description);
    	jpaRole.setActive(isActive);
    	jpaRole.setCreated(created);
    	jpaRole.setCreatedBy(createdBy);
    	jpaRole.setUpdated(updated);
    	jpaRole.setUpdatedBy(updatedBy);
        return jpaRole;
    }

    @Override
    public Role fromEntity(JpaRole entity) {

        this.id = entity.getId();
        this.description = entity.getDescription();
        this.isActive = entity.isActive();
        this.created = entity.getCreated();
        this.createdBy = entity.getCreatedBy();
        this.updated = entity.getUpdated();
        this.updatedBy = entity.getUpdatedBy();

        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}
