package com.murtiart.about;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aboutus")
@NoArgsConstructor
@Getter
@Setter
public class AboutUs {

	@Id
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(columnDefinition="LONGTEXT", name="description", nullable = false)
	private String description;
	
	@Column(name="phone")
	private Long phone;
	
	@Column(name="gender")
	private String gender;

	@Column(name="remove")
	private Boolean remove;
	 
	@Column(columnDefinition="LONGTEXT", name="image", nullable = false)
	private String image;
	
}
