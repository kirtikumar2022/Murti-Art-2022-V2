package com.murtiart.banner;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.murtiart.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "banner")
@NoArgsConstructor
@Getter
@Setter
public class Banner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bannerid;
	
	@Column(name="banner_url", nullable = false)
	private String bannerUrl;
	
	@Column(name="remove", nullable = false)
	private Boolean remove;
	
	@Column(columnDefinition="LONGTEXT",name="image", nullable = false)
	private String image;
	
	// Many Single banner has only one user.
	@ManyToOne
	private User user;

}
