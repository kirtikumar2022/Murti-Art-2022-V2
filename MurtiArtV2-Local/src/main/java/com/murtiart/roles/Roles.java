package com.murtiart.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="roles")
@NoArgsConstructor
@Getter
@Setter
public class Roles { 
	
	@Id
	private Integer roleid;
	
	@Column(name="name")
	private String name;
	
}
