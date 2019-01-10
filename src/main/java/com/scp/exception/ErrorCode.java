package com.scp.exception;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class ErrorCode {

	String errorcode;
	String msg;
	public ErrorCode(String errorcode, String msg) {
		super();
		this.errorcode = errorcode;
		this.msg = msg;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public String getMsg() {
		return msg;
	}
	
	
}
