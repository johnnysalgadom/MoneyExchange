package com.bcp.challenge.moneyexchange.model;

import java.util.Date;

public abstract class GenericModel<ENTITY> {

    protected Long id;
    protected boolean isActive;
    protected Date created;
    protected String createdBy;
    protected Date updated;
    protected String updatedBy;

    public abstract ENTITY toEntity();

    public abstract <MODEL extends GenericModel> MODEL fromEntity(ENTITY entity);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
