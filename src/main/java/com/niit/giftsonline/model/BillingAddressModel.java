package com.niit.giftsonline.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class BillingAddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//private String billingaddress_id;

	private String billingaddress;
	private String billingaddress_state;
	private String billingaddress_city;
	private String billingaddress_pincode;
	
	/*public String getBillingaddress_id() {
		return billingaddress_id;
	}
	public void setBillingaddress_id(String billingaddress_id) {
		this.billingaddress_id = billingaddress_id;
	}*/
	public String getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}
	public String getBillingaddress_state() {
		return billingaddress_state;
	}
	public void setBillingaddress_state(String billingaddress_state) {
		this.billingaddress_state = billingaddress_state;
	}
	public String getBillingaddress_city() {
		return billingaddress_city;
	}
	public void setBillingaddress_city(String billingaddress_city) {
		this.billingaddress_city = billingaddress_city;
	}
	public String getBillingaddress_pincode() {
		return billingaddress_pincode;
	}
	public void setBillingaddress_pincode(String billingaddress_pincode) {
		this.billingaddress_pincode = billingaddress_pincode;
	}
}
