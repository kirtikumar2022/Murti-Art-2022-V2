package com.murtiart.howtouse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HowToUseDto {

	private Integer id;
	private String type;
	private String link;
	private String title;
	private String description;
	private String thumbnail;
	private Boolean remove;
	private Boolean show;
	
}
