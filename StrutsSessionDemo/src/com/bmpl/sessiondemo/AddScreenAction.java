package com.bmpl.sessiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddScreenAction extends ActionSupport implements SessionAware {
	private Map<String,Object> sessionMap;
private List<String> country;
	
	public List<String> getCountry() {
		return country;
	}

	public void setCountry(List<String> country) {
		this.country = country;
	}
	public String showAddScreen(){
		Object object = sessionMap.get("uid");
		System.out.println("Object is :::: "+object);
		if(object==null){
			return ERROR;
		}
		List<String> c = new ArrayList<String>();
		c.add("USA");
		c.add("UK");
		c.add("India");
		this.setCountry(c);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
		
	}
}
