package com.DWR.DWR_Record.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.dto.EmployeeLogDto;
//import com.DWR.DWR_Record.entity.EmployeeRecordLogEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class EmployeeRecordDataDao {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<EmployeeLogDto> getUserLogById(int input){
		String empId = String.valueOf(input);
		List<EmployeeLogDto> userLogList = new ArrayList<>();
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("logById").setParameter("userID", input);
		List<String> result = query.getResultList();
		long i = 1;
		for (String row : result) {
			EmployeeLogDto log = new EmployeeLogDto();
			log.setId((Long) i++);
			log.setDate((String) row);
			log.setEmployeeId((String) empId);
			log.setRecived("YES");
			userLogList.add(log);
		 }
		return userLogList;
	}
}
