package com.bcp.challenge.moneyexchange.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "status")
    private boolean isActive = true;

    @Column(name="created", columnDefinition="TIMESTAMP DEFAULT NOW")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Column(name="created_by")
    private String createdBy;

    @Column(name="updated", columnDefinition="TIMESTAMP DEFAULT NOW")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated = new Date();

    @Column(name="updated_by")
    private String updatedBy;

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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
