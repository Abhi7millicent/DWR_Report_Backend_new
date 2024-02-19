package com.DWR.DWR_Record.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.AttandanceManagementEntity;

public interface AttandanceManagementRepository extends JpaRepository<AttandanceManagementEntity, Long> {

	@Query(value = "SELECT * FROM attandance_management_am WHERE employeeid_am = :employeeId and date_am = :date and deleteflag_am = 'NO'", nativeQuery = true)
	Optional<AttandanceManagementEntity> findTodayAttandanceByEmployeeId(@Param("employeeId") String employeeId,@Param("date") String date);

	@Query(value = "SELECT * FROM attandance_management_am " +
            "WHERE YEAR(date_am) = :year " +
            "AND MONTH(date_am) = :month " +
            "AND employeeid_am = :employeeId", nativeQuery = true)
	List<AttandanceManagementEntity> getAttendanceForMonth( @Param("month") String month,
            @Param("year") String year,
            @Param("employeeId") String employeeId);

	
}
