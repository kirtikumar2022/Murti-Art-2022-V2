package com.murtiart.banner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BannerDto {
	
	private Integer bannerid;
	private String bannerUrl;
	private Boolean remove;
	private String image;
}
