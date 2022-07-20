package com.murtiart.variant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.murtiart.attribute.Attribute;
import com.murtiart.images.Image;
import com.murtiart.product.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "variants")
@NoArgsConstructor
@Getter
@Setter
public class Variant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer variantid;
	
	@Column(name="mrp", nullable = false)
	private Long mrp;
	
	@Column(name="order_limit", nullable = false)
	private Integer orderLimit;
	
	@Column(name="out_of_stock", nullable = false)
	private Boolean outOfStock; 
	
	@Column(name="quantity", nullable = false)
	private Integer quantity;
	
	@Column(name="soldquanitity", nullable = false)
	private Integer soldquanitity;
	
	@Column(name="sp", nullable = false)
	private Long sp;
	
	@Column(name="rating", nullable = false)
	private Integer rating;
	
	@Column(name="ask_price", nullable = false)
	private Boolean askPrice;
	
	@Column(name="remove", nullable = false)
	private Boolean remove;
	
	// Many Single variant has only one product.
	@ManyToOne
	private Product product;
	
	// One variant has multiple attribute so need to create the list of attribute
	@OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
	private List<Attribute> attributes = new ArrayList<>();
	
	// One variant has multiple attribute so need to create the list of attribute
	@OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
	private List<Image> images = new ArrayList<>();
	 
}
