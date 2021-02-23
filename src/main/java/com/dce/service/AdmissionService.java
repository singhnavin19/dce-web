package com.dce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dce.dao.AdmissionDao;
import com.dce.dao.AttendanceDao;
import com.dce.dao.CourseDao;
import com.dce.dao.FeeDetailDao;
import com.dce.entity.Admission;
import com.dce.entity.Course;
import com.dce.entity.FeeDetails;

@Service("admissionService")
public class AdmissionService {

	@Autowired
	CourseDao courseDao;
	@Autowired
	AdmissionDao admissionDao;
	@Autowired
	FeeDetailDao feeDetailDao;
	@Autowired
	AttendanceDao attendanceDao;

	public void addRowInCourseAndFeeTable(Admission admission) {

		this.addRowInCourseTable(admission);
		this.addRowInFeeDetailsTable(admission);

	}

	public void addRowInCourseTable(Admission admissionForm) {

		List<Course> listCourse = admissionForm.getCourseDetails();
		listCourse.add(new Course());
		admissionForm.setCourseDetails(listCourse);

	}

	public void addRowInFeeDetailsTable(Admission admissionForm) {
		List<FeeDetails> feeDetailsList = admissionForm.getFeeDetails();
		feeDetailsList.add(new FeeDetails());
		admissionForm.setFeeDetails(feeDetailsList);
	}

	public void save(Admission admission) {

		this.admissionDao.save(admission);
		this.feeDetailDao.save(admission);
		this.courseDao.save(admission);
		this.attendanceDao.save(admission.getUID());

	}
}
