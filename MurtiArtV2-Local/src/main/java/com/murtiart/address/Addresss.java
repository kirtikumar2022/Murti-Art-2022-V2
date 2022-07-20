package com.murtiart.address;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.murtiart.user.User;
import com.murtiart.product.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Addresss {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer addressid;
	
	@Column(name="contact_person", nullable = false)
	private String contactPerson;

	@Column(name="mobile", nullable = false)
	private Long mobile;
	
	@Column(name="pincode")
	private Integer pincode;
	
	@Column(name="address_type", nullable = false)
	private String addressType;
	
	@Column(name="address", nullable = false)
	private String address;
	
	@Column(columnDefinition="LONGTEXT",name="shop_image", nullable = false)
	private String shopImage;
	
	@Column(name="shop_name", nullable = false)
	private String shopName;
	
	@Column(name="remove", nullable = false)
	private Boolean remove;
	
	@Column(name="make_as_default", nullable = false)
	private Boolean makeAsDefault;
	
	@ManyToOne
	private User users;
	
	// One category has multiple products so need to create the list of product
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<>();
	
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "product_address", 
//	joinColumns  = @JoinColumn(name = "address",referencedColumnName = "addressid"), 
//	inverseJoinColumns = @JoinColumn(name = "product", referencedColumnName = "productid" ))
//	private Set<Product> products = new HashSet<>();
	
}
