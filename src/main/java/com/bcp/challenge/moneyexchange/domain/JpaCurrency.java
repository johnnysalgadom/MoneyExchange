package com.bcp.challenge.moneyexchange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class JpaCurrency extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "abbreviation")
    private String abbreviation;

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
