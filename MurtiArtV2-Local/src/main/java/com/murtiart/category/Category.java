package com.murtiart.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.murtiart.product.Product;
import com.murtiart.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;
	
	@Column(name="cat_desc", nullable = false)
	private String catDesc;
	
	@Column(name="cat_name", nullable = false)
	private String catName;
	
	@Column(name="choosable")
	private Boolean choosable;
	
	@Column(name="remove")
	private Boolean remove;
	
	@Column(name="murti")
	private Boolean murti;
	
	@Column(columnDefinition="LONGTEXT",name="image", nullable = false)
	private String image;
	
	// One category has multiple products so need to create the list of product
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();
	
	// Many Single category has only one user.
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
}
