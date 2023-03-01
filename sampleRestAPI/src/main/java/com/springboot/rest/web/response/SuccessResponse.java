package com.springboot.rest.web.response;

import lombok.*;

/**
 * <h2>SuccessResponse</h2>
 *
 * @author aek
 * <p>
 * Description:
 */
@Data

@ToString
@Builder
public class SuccessResponse {
    private Object data;
    private String message;
	public SuccessResponse(Object data, String message) {
		super();
		this.data = data;
		this.message = message;
	}
	public SuccessResponse() {
		super();
	}
    
    
}