package com.niit.giftsonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component
public class SupplierModel
{
	@Id
	@Column(name="id")
	private String supplier_id;
	
	@NotEmpty
	@Column(name="name")
	private String supplier_name;
	
	@NotEmpty
	@Column(name="address")
	private String supplier_address;
	
	@NotEmpty
	@Column(name="state")
	private String supplier_state;
	
	@NotEmpty
	@Column(name="city")
	private String supplier_city;
	
	@NotEmpty
	@Column(name="pincode")
	private String supplier_pincode;
	
	@NotEmpty
	@Column(name="contact_number")
	private String supplier_contact;
	
	@NotEmpty
	@Column(name="payment_method")
	private String supplier_payment;
	
	public SupplierModel() {
		//super();
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public String getSupplier_state() {
		return supplier_state;
	}

	public void setSupplier_state(String supplier_state) {
		this.supplier_state = supplier_state;
	}

	public String getSupplier_city() {
		return supplier_city;
	}

	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}

	public String getSupplier_pincode() {
		return supplier_pincode;
	}

	public void setSupplier_pincode(String supplier_pincode) {
		this.supplier_pincode = supplier_pincode;
	}

	public String getSupplier_contact() {
		return supplier_contact;
	}

	public void setSupplier_contact(String supplier_contact) {
		this.supplier_contact = supplier_contact;
	}

	public String getSupplier_payment() {
		return supplier_payment;
	}

	public void setSupplier_payment(String supplier_payment) {
		this.supplier_payment = supplier_payment;
	}
}