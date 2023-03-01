package com.springboot.rest.web.response;

import lombok.*;

import java.time.Instant;

/**
 * <h2>ErrorResponse</h2>
 *
 * @author aek
 * <p>
 * Description:
 */
@Data

@ToString
@Builder
public class ErrorResponse {

    /**
     * error code
     */
    private String code;
    /**
     * short error message
     */
    private String message;

    /**
     * error cause timestamp
     */
    private Instant timestamp;
    

	public ErrorResponse() {
		super();
	}


	public ErrorResponse(String code, String message, Instant timestamp) {
		super();
		this.code = code;
		this.message = message;
		this.timestamp = timestamp;
	}
    
    
}

