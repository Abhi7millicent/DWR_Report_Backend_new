package com.DWR.DWR_Record.serviceIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.entity.EmailLogDetailsEntity;
import com.DWR.DWR_Record.repository.EmailLogDetailsRepository;
import com.DWR.DWR_Record.service.EmailLogDetailsService;


@Service
public class EmailLogDetailsServiceImpl implements EmailLogDetailsService{

	
	@Autowired
	private EmailLogDetailsRepository emailLogDetailsRepository;
	
	@Override
	public void addLog(String to, byte[] attachment, String subject, String name) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		EmailLogDetailsEntity emailLogDetailsEntity = new EmailLogDetailsEntity();
		emailLogDetailsEntity.setEmail(to);
//		emailLogDetailsEntity.setAttachment(attachment);
		emailLogDetailsEntity.setDateTime(formattedDateTime);
		emailLogDetailsEntity.setLogType(subject);
		emailLogDetailsEntity.setName(name);
		emailLogDetailsRepository.save(emailLogDetailsEntity);
	}

	

}
