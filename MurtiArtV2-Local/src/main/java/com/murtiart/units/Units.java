package com.murtiart.units;


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
@Table(name = "units")
@NoArgsConstructor
@Getter
@Setter
public class Units {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer unitid;

	@Column(name="value", nullable = false, unique = true)
	private String value; 
 
	@Column(name="remove", nullable = false)
	private Boolean remove; 
	
}
