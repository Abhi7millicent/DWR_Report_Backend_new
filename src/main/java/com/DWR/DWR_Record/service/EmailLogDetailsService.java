package com.DWR.DWR_Record.service;

public interface EmailLogDetailsService{

	void addLog(String to, byte[] attachment, String subject, String name);

}
