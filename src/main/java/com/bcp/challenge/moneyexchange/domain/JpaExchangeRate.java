package com.bcp.challenge.moneyexchange.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_rate")
public class JpaExchangeRate extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "currency_id",
            referencedColumnName = "id"
    )
    private JpaCurrency currency;
	
    @Column(name = "exchange_date")
    private Date exchangeDate;

    @Column(name = "sale_value")
    private float saleValue;
    
    @Column(name = "purchase_value")
    private float purchaseValue;

    public JpaCurrency getCurrency() {
    	return currency;
    }
    
    public void setCurrency(JpaCurrency currency) {
    	this.currency = currency;
    }
    
    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(float saleValue) {
        this.saleValue = saleValue;
    }
    
    public float getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(float purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
	
	
}
