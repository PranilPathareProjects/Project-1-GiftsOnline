package com.niit.giftsonline.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component
public class CategoryModel
{
	@Id
	@Column(name="id")
	private String category_id;
	
	@NotEmpty
	@Column(name="name")
	private String category_name;
	
	@NotEmpty
	@Column(name="description")
	private String category_description;
	
	@NotEmpty
	@Column(name="status")
	private String category_status;
	
	/*private Set<SubcategoryModel> subcategory;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	public Set<SubcategoryModel> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Set<SubcategoryModel> subcategory) {
		this.subcategory = subcategory;
	}*/
	
	public CategoryModel() {
		//super();
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public String getCategory_status() {
		return category_status;
	}

	public void setCategory_status(String category_status) {
		this.category_status = category_status;
	}
}