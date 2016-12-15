package com.niit.giftsonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class ProductModel
{
	@Id
	@Column(name="id")
	private String product_id;
	
	@NotEmpty
	@Column(name="name")
	private String product_name;
	
	@NotEmpty
	@Column(name="description")
	private String product_description;
	
	@Column(name="quantity")
	private int product_quantity;
	
	@Column(name="price")
	private int product_price;
	
	@NotEmpty
	private String category_id;
	
	@NotEmpty
	private String supplier_id;
	
	@NotEmpty
	private String product_status;
	
	@Transient
	private MultipartFile product_image;
	
	@Column(name="color")
	private String productdetail_color;
	
	@Column(name="weight")
	private String productdetail_weight;
	
	@Column(name="size")
	private String productdetail_size;
	
	public ProductModel() {
		//super();
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getProduct_status() {
		return product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public MultipartFile getProduct_image() {
		return product_image;
	}

	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}

	public String getProductdetail_color() {
		return productdetail_color;
	}

	public void setProductdetail_color(String productdetail_color) {
		this.productdetail_color = productdetail_color;
	}

	public String getProductdetail_weight() {
		return productdetail_weight;
	}

	public void setProductdetail_weight(String productdetail_weight) {
		this.productdetail_weight = productdetail_weight;
	}

	public String getProductdetail_size() {
		return productdetail_size;
	}

	public void setProductdetail_size(String productdetail_size) {
		this.productdetail_size = productdetail_size;
	}
	//private double cake_weight;
	//private int men_shirt_size;
	//private int men_t_shirt_size;
	//private int men_trouser_size;
	//private int women_shirt_size;
	//private int women_t_shirt_size;
	//private int women_dress_size;
	//private int shoe_size;
}