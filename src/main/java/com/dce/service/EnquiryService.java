package com.dce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dce.dao.EnquiryDao;
import com.dce.entity.Admission;
import com.dce.entity.Enquiry;

@Component
public class EnquiryService {

	@Autowired
	EnquiryDao studentEnquiryDao;

	public String insert(Enquiry studentenquiry) {

		return this.studentEnquiryDao.insert(studentenquiry);
	}

	public void update(Enquiry studentenquiry) {

		this.studentEnquiryDao.update(studentenquiry);
	}

	public List<Admission> getStudentdetails(Admission admission) {

		return this.studentEnquiryDao.fetch(admission);

	}

}
