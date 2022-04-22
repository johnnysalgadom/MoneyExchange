package com.bcp.challenge.moneyexchange.model;

import java.util.Date;
import com.bcp.challenge.moneyexchange.domain.JpaExchange;

public class Exchange extends GenericModel<JpaExchange> {

    private User user;
    
    private Currency currency;

    private Date exchangeDate;
    
    private float saleValue;
    
    private float purchaseValue;

    private float saleAmount;
    
    private float purchaseAmount;

    private float saleTotal;

    private float purchaseTotal;

	@Override
    public JpaExchange toEntity() {
    	JpaExchange jpaExchange = new JpaExchange();
    	jpaExchange.setId(id);
    	jpaExchange.setExchangeDate(exchangeDate);
    	jpaExchange.setSaleValue(saleValue);
    	jpaExchange.setPurchaseValue(purchaseValue);
    	jpaExchange.setSaleAmount(saleAmount);
    	jpaExchange.setPurchaseAmount(purchaseAmount);
    	jpaExchange.setSaleTotal(saleTotal);
    	jpaExchange.setPurchaseTotal(purchaseTotal);
    	jpaExchange.setActive(isActive);
    	jpaExchange.setCreated(created);
    	jpaExchange.setCreatedBy(createdBy);
    	jpaExchange.setUpdated(updated);
    	jpaExchange.setUpdatedBy(updatedBy);

        if (user != null) {
            jpaExchange.setUser(user.toEntity());
        }

        if (currency != null) {
            jpaExchange.setCurrency(currency.toEntity());
        }

        return jpaExchange;
    }

    @Override
    public Exchange fromEntity(JpaExchange entity) {

        this.id = entity.getId();
        this.exchangeDate = entity.getExchangeDate();
        this.saleValue = entity.getSaleValue();
        this.purchaseValue = entity.getPurchaseValue();
        this.saleAmount = entity.getSaleAmount();
        this.purchaseAmount = entity.getPurchaseAmount();
        this.saleTotal = entity.getSaleTotal();
        this.purchaseTotal = entity.getPurchaseTotal();
        this.isActive = entity.isActive();
        this.created = entity.getCreated();
        this.createdBy = entity.getCreatedBy();
        this.updated = entity.getUpdated();
        this.updatedBy = entity.getUpdatedBy();

        if (entity.getUser() != null) {
            setUser(new User().fromEntity(entity.getUser()));
        }
        
        if (entity.getCurrency() != null) {
            setCurrency(new Currency().fromEntity(entity.getCurrency()));
        }
        
        return this;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency= currency;
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
