package com.niit.giftsonline.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
@Component
public class ShippingAddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//private String shippingaddress_id;

	private String shippingaddress;
	private String shippingaddress_state;
	private String shippingaddress_city;
	private String shippingaddress_pincode;
	
	/*public String getShippingaddress_id() {
		return shippingaddress_id;
	}
	public void setShippingaddress_id(String shippingaddress_id) {
		this.shippingaddress_id = shippingaddress_id;
	}*/
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public String getShippingaddress_state() {
		return shippingaddress_state;
	}
	public void setShippingaddress_state(String shippingaddress_state) {
		this.shippingaddress_state = shippingaddress_state;
	}
	public String getShippingaddress_city() {
		return shippingaddress_city;
	}
	public void setShippingaddress_city(String shippingaddress_city) {
		this.shippingaddress_city = shippingaddress_city;
	}
	public String getShippingaddress_pincode() {
		return shippingaddress_pincode;
	}
	public void setShippingaddress_pincode(String shippingaddress_pincode) {
		this.shippingaddress_pincode = shippingaddress_pincode;
	}
}
