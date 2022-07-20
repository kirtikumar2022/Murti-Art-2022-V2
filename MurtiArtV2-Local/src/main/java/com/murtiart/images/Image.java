package com.murtiart.images;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.murtiart.variant.Variant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "variant_image")
@NoArgsConstructor
@Getter
@Setter
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageid;
	
	@Column(name="_key", nullable = false)
	private String key; 
	
	@Column(columnDefinition="LONGTEXT", name="value", nullable = false)
	private String value; 
	
	@Column(name="remove", nullable = false)
	private Boolean remove; 
	
	// Many Single image has only one variant
	@ManyToOne
	private Variant variant;
	 
}
