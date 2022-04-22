package com.bcp.challenge.moneyexchange.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exchange")
public class JpaExchange extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private JpaUser user;
    
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

    @Column(name = "sale_amount")
    private float saleAmount;
    
    @Column(name = "purchase_amount")
    private float purchaseAmount;

    @Column(name = "sale_total")
    private float saleTotal;

    @Column(name = "purchase_total")
    private float purchaseTotal;
    
    public JpaUser getUser() {
    	return user;
    }
    
    public void setUser(JpaUser user) {
    	this.user = user;
    }
    
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
    
    public float getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(float saleAmount) {
        this.saleAmount = saleAmount;
    }

    public float getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(float purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    
    public float getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(float saleTotal) {
        this.saleTotal = saleTotal;
    }

    public float getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(float purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

}
