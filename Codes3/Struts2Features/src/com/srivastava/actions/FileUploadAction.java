package com.srivastava.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String execute() throws Exception{
		String serverPath = "/Users/amit/Documents/FileOutput/MyFile.jpg";
		FileInputStream fs = new FileInputStream(fileUpload);
		FileOutputStream fo = new FileOutputStream(serverPath);
		int readSingleByte = fs.read();
		while(readSingleByte!=-1){
			fo.write(readSingleByte);
			readSingleByte = fs.read();
			
		}
		fs.close();
		fo.close();
		System.out.println("Done..."); 
		
		return SUCCESS;

	}
	public String display() {
		return NONE;
	}
	
}
