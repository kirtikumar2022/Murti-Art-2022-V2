package com.murtiart.faviourte;


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
@Table(name = "favourites")
@NoArgsConstructor
@Getter
@Setter
public class Favourite {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer favouriteid;
	
	@Column(name="added", nullable = false)
	private Boolean added;
	
	@Column(name="userid", nullable = false)
	private Integer userid;
	
	@Column(name="productid", nullable = false)
	private Integer productid;
	
}


















