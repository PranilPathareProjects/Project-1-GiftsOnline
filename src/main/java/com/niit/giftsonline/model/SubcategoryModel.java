package com.niit.giftsonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Subcategory")
@Component
public class SubcategoryModel
{
	@Id
	@Column(name="id")
	private String subcategory_id;
	
	@NotEmpty
	@Column(name="name")
	private String subcategory_name;
	
	@NotEmpty
	@Column(name="description")
	private String subcategory_description;
	
	@NotEmpty
	@Column(name="category_id")
	private String category_id;
	
	@NotEmpty
	@Column(name="status")
	private String subcategory_status;
	
	/*@ManyToOne
	@JoinColumn(name="category_id", updatable=false, insertable=false, nullable=false)
	private CategoryModel category;*/
	
	public SubcategoryModel() {
		//super();
	}

	public String getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(String subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public String getSubcategory_description() {
		return subcategory_description;
	}

	public void setSubcategory_description(String subcategory_description) {
		this.subcategory_description = subcategory_description;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSubcategory_status() {
		return subcategory_status;
	}

	public void setSubcategory_status(String subcategory_status) {
		this.subcategory_status = subcategory_status;
	}
}