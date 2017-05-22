package com.srivastava.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	@Override
	public String execute(){
		return SUCCESS;
	}
}
