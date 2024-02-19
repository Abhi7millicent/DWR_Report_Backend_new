package com.DWR.DWR_Record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.dto.LeaveWithEmployeeDto;
import com.DWR.DWR_Record.entity.LeaveManagementEntity;

import jakarta.transaction.Transactional;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagementEntity, Long> {

	@Query(value = "SELECT * FROM leave_management_lm WHERE employeeid_lm = :employeeId and deleteflag_lm = 'NO'", nativeQuery = true)
	List<LeaveManagementEntity> getListOfLeaveByEmployeeId(@Param("employeeId") String employeeId);

	@Query(value = "SELECT balanced_leave_lm FROM leave_management_lm WHERE employeeid_lm = :employeeId AND deleteflag_lm = 'NO' ORDER BY id_lm DESC LIMIT 1", nativeQuery = true)
	String getBlancedLeaveById(@Param("employeeId") String employeeId);
	
	 @Query(value = "SELECT lm.id_lm AS id, lm.employeeid_lm AS employeeId, lm.leave_type_lm AS leaveType, lm.description_lm AS description, lm.start_date_lm AS startDate, lm.end_date_lm AS endDate, lm.no_ofdays_lm AS noOfDays, lm.status_lm AS status, lm.deleteflag_lm AS deleteflag, lm.balanced_leave_lm AS balancedLeave, em.first_name_em AS firstName, em.middle_name_em AS middleName, em.last_name_em AS lastName FROM leave_management_lm lm LEFT JOIN employee_master_em em ON lm.employeeid_lm = em.id_em", nativeQuery = true)
	    List<LeaveWithEmployeeDto> findAllLeavesWithEmployeeNames();

	 @Modifying
	    @Transactional
	    @Query("UPDATE LeaveManagementEntity lm SET lm.lastUpdatedMonthYear = :lastUpdatedMonthYear, lm.balancedLeave = :balancedLeave WHERE lm.id = :id")
	    void updateBalancedLeaveAndLastUpdatedMonthYear(@Param("lastUpdatedMonthYear") String lastUpdatedMonthYear, @Param("balancedLeave") String balancedLeave, @Param("id") Long id);
	
	   

	
}
