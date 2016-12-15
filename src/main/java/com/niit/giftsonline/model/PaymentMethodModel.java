package com.niit.giftsonline.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class PaymentMethodModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String paymentmethod;

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
}
