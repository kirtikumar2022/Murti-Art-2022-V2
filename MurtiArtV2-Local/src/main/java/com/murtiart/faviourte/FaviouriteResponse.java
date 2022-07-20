package com.murtiart.faviourte;

import java.util.List;

import com.murtiart.product.ProductDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class FaviouriteResponse {
	
	private List<ProductDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElement;
	private Integer totalPages;
	private Boolean lastPage;
}
