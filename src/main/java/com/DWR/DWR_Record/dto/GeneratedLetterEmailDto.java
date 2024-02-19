package com.DWR.DWR_Record.dto;

import java.util.Arrays;

public class GeneratedLetterEmailDto {
  
	private String to;
    private String subject;
    private String body;
    private String name;
    private byte[] attachment;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public GeneratedLetterEmailDto(String to, String subject, String body, String name, byte[] attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.name = name;
		this.attachment = attachment;
	}
	public GeneratedLetterEmailDto() {
		
	}
	@Override
	public String toString() {
		return "GenratedLetterEmailDto [to=" + to + ", subject=" + subject + ", body=" + body + ", name=" + name
				+ ", attachment=" + Arrays.toString(attachment) + "]";
	}
	
    
}
