package com.murtiart.appkaremote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AppKaRemoteDto {
	
	private Integer remoteid;
	private String message; 
	private Boolean froceUpdate; 
	private Boolean freez; 
	private String urlMaker; 
	private String noDataPlaceHolder; 
	private String currency; 
	private Long support;
}
