package com.bcp.challenge.moneyexchange.model;

import com.bcp.challenge.moneyexchange.domain.JpaCurrency;

public class Currency extends GenericModel<JpaCurrency> {

    private String description;

    private String abbreviation;
    
    @Override
    public JpaCurrency toEntity() {
    	JpaCurrency jpaCurrency = new JpaCurrency();
    	jpaCurrency.setId(id);
    	jpaCurrency.setDescription(description);
    	jpaCurrency.setAbbreviation(abbreviation);
    	jpaCurrency.setActive(isActive);
    	jpaCurrency.setCreated(created);
    	jpaCurrency.setCreatedBy(createdBy);
    	jpaCurrency.setUpdated(updated);
    	jpaCurrency.setUpdatedBy(updatedBy);
        return jpaCurrency;
    }

    @Override
    public Currency fromEntity(JpaCurrency entity) {

        this.id = entity.getId();
        this.description = entity.getDescription();
        this.abbreviation = entity.getAbbreviation();
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
    
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
}
