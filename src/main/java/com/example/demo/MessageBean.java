package com.example.demo;

public class MessageBean {
	
	private String msg;

	public MessageBean(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MessageBean [msg=" + msg + "]";
	}
	
	

}
