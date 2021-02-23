package com.dce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dce.dao.AdmissionDao;
import com.dce.dao.CourseDao;
import com.dce.dao.FeeDetailDao;
import com.dce.dao.InfoDao;
import com.dce.entity.Admission;

@Service
public class InfoService {

	@Autowired
	AdmissionDao admissionDao;
	@Autowired
	FeeDetailDao feeDetailDao;
	@Autowired
	CourseDao courseDao;
	@Autowired
	InfoDao infoDao;

	public Admission getDetailsById(String uid) {

		List<String> uids = new ArrayList<>();
		uids.add(uid);
		List<Admission> useDetails = this.infoDao.getDetailsById(uid);
		if (!useDetails.isEmpty()) {
			Admission AdmissionDetail = useDetails.get(0);
			AdmissionDetail.setFeeDetails(this.feeDetailDao.fetch(uid));
			AdmissionDetail.setCourseDetails(this.courseDao.fetch(uid));
			return AdmissionDetail;
		}
		return null;

	}

}
