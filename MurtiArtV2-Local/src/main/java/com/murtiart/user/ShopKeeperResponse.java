package com.murtiart.user;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ShopKeeperResponse {
	
	private List<UserDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElement;
	private Integer totalPages;
	private Boolean lastPage;

}
