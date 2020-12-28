package ch15.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BoardBean {
	private int num;
	private String name;        
	private String subject;      
	private String content;     
	private int pos;            
	private int depth;        
	private int ref;        
	private String regdate;     
	private String pass;          
	private String  ip;
	private int count;        
	private String filename; 
	private int filesize;
}
