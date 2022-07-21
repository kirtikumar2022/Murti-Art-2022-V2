package com.murtiart.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GenericApiRespons<T>  {
	
	   private GenericMore more ;
	   
	   private T data;

		public GenericApiRespons(GenericMore more, T data) {
			this.more = more;
			this.data = data;
		}

}
