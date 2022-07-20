package com.murtiart.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.murtiart.address.Addresss;
import com.murtiart.banner.Banner;
import com.murtiart.category.Category;
import com.murtiart.product.Product;
import com.murtiart.roles.Roles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name ="users")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer userid;
	
	@Column(name="email" , nullable = false)
	private String email;
	
	@Column(name="name" , nullable = false)
	private String name;
	
	@Column(name="fire_base_id" , nullable = false)
	private String fireBaseId;
	
	@Column(name="subscription")
	private Long subscription;	
	
	@Column(name="mobile")
	private Long mobile;
	
	@Column(columnDefinition="LONGTEXT", name="image" , nullable = false)
	private String image;
 
	@Column(name="gender")
	private String gender;
	
	@Column(name="device_token" , nullable = false)
	private String deviceToken;
	
	@Column(name="rating"  ,length = 10)
	private Integer rating;
	
	@Column(name="isactive")
	private Boolean isActive; 
	
	@Column(name="request")
	private Integer request; // This is for shopkeeper request if 0 means accepted 1 means not accepted by Admin
	
	// One User has multiple category so need to create the list of category
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Category> categories = new ArrayList<>();
	
 
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
	joinColumns  = @JoinColumn(name = "users",referencedColumnName = "userid"), 
	inverseJoinColumns = @JoinColumn(name = "roles", referencedColumnName = "roleid" ))
	private List<Roles> roles = new ArrayList<>();
	
	// One shopkeeper has multiple products so need to create the list of product
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	// Many Single address has only one user.
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Addresss> address = new ArrayList<>();
	
//  One shopkeeper has multiple address so need to create the list of address
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Banner> banner = new ArrayList<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authority = this.roles.stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authority;
	}


	@Override
	public String getPassword() {
		return this.email;
	}

	@Override
	public String getUsername() {
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}	
}
