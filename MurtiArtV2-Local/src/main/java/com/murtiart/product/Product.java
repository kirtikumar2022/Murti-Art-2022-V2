package com.murtiart.product;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.murtiart.address.Addresss;
import com.murtiart.category.Category;
import com.murtiart.faviourte.Favourite;
import com.murtiart.user.User;
import com.murtiart.variant.Variant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer productid;
	
	@Column(name="product_desc", nullable = false)
	private String productDesc;
	
	@Column(name="product_name", nullable = false)
	private String productName; 
	
	@Column(name="remove", nullable = false)
	private Boolean remove;
	
	// Many Single product has only one category.
	@ManyToOne
	@JoinColumn(name = "categoryid", nullable = false)
	private Category category;
	
	// Many Individual product has only one Shopkeeper.
	@ManyToOne
	@JoinColumn(name = "userid" ,nullable = false)
	private User user;
	
 	// Many Single product has only one shop address.
	@ManyToOne
	@JoinColumn(name = "addressid", nullable = false)
	private Addresss address;
	
	// One product has multiple variant so need to create the list of variant
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Variant> variants = new ArrayList<>();

	
}
