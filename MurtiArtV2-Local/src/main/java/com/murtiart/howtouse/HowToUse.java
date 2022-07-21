package com.murtiart.howtouse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "howtouse")
@NoArgsConstructor
@Getter
@Setter
public class HowToUse {

	@Id
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	@Column(columnDefinition="LONGTEXT", name="_link", nullable = false)
	private String link;
	
	@Column(columnDefinition="LONGTEXT", name="title", nullable = false)
	private String title;
	
	@Column(columnDefinition="LONGTEXT", name="description", nullable = false)
	private String description;
	
	@Column(columnDefinition="LONGTEXT", name="_thumbnail", nullable = false)
	private String thumbnail;

	@Column(name="_show")
	private Boolean show;
	
	@Column(name="remove")
	private Boolean remove;
	 
}
