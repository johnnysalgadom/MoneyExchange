package com.bcp.challenge.moneyexchange.model;

import java.util.Date;
import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;

public class ExchangeRate extends GenericModel<JpaExchangeRate> {

    private Currency currency;

    private Date exchangeDate;
    
    private float saleValue;
    
    private float purchaseValue;

	@Override
    public JpaExchangeRate toEntity() {
    	JpaExchangeRate jpaExchangeRate = new JpaExchangeRate();
    	jpaExchangeRate.setId(id);
    	jpaExchangeRate.setExchangeDate(exchangeDate);
    	jpaExchangeRate.setSaleValue(saleValue);
    	jpaExchangeRate.setPurchaseValue(purchaseValue);
    	jpaExchangeRate.setActive(isActive);
    	jpaExchangeRate.setCreated(created);
    	jpaExchangeRate.setCreatedBy(createdBy);
    	jpaExchangeRate.setUpdated(updated);
    	jpaExchangeRate.setUpdatedBy(updatedBy);

        if (currency != null) {
            jpaExchangeRate.setCurrency(currency.toEntity());
        }

        return jpaExchangeRate;
    }

    @Override
    public ExchangeRate fromEntity(JpaExchangeRate entity) {

        this.id = entity.getId();
        this.exchangeDate = entity.getExchangeDate();
        this.saleValue = entity.getSaleValue();
        this.purchaseValue = entity.getPurchaseValue();
        this.isActive = entity.isActive();
        this.created = entity.getCreated();
        this.createdBy = entity.getCreatedBy();
        this.updated = entity.getUpdated();
        this.updatedBy = entity.getUpdatedBy();

        if (entity.getCurrency() != null) {
            setCurrency(new Currency().fromEntity(entity.getCurrency()));
        }

        return this;
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

}
