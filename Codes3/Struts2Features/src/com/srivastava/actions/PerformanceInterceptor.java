package com.srivastava.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PerformanceInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Custom Interceptor Destroy...");
		
	}

	@Override
	public void init() {
		System.out.println("Custom Interceptor Initalized..");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time is "+startTime);
		String result = invocation.invoke();
		long endTime = System.currentTimeMillis();
		System.out.println("End Time is "+endTime);
		long totalTime = endTime - startTime;
		System.out.println("Total Time Taken "+totalTime+"ms");
		// TODO Auto-generated method stub
		return result;
	}

}
