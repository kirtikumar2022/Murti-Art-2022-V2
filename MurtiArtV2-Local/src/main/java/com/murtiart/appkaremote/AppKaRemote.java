package com.murtiart.appkaremote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// -- It is use for control full application i.e force update application from play store
// -- freez for stop or start application for temporary
// -- Only one record in this table

@Entity
@Table(name = "remotecontrol")
@NoArgsConstructor
@Getter
@Setter
public class AppKaRemote {

	@Id
	private Integer remoteid;
	
	//Hello Customer, we are working on current application so please wait for some time"
	@Column(name="message", nullable = false) 
	private String message; 
	
	@Column(name="froce_update", nullable = false)
	private Boolean froceUpdate; 
	
	@Column(name="freez", nullable = false)
	private Boolean freez; 
	
	@Column(name="url_maker", nullable = false)
	private String urlMaker; 

	@Column(name="placeholder")
	private String noDataPlaceHolder; 
	
	@Column(name="currency")
	private String currency; 
	
	@Column(name="support")
	private Long support; 
	
	// Razzor pay credential manage here
	
	
}
