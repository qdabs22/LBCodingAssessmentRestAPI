/*
 * Note Class 
 */
package com.aacompany.restservice;

public class Note {
    
	private String body;
	private int id;
	
	public String GetBody(){
		return body;
	}
	
	public void SetBody(String body) {
		this.body = body;
	}
	
	public int GetId() {
		return id;
	}
	
	public void SetId(int id) {
		this.id = id;
	}        
}