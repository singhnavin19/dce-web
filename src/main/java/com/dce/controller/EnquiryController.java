package com.dce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dce.dao.EnquiryDao;
import com.dce.dao.EnquiryReportDao;
import com.dce.entity.Enquiry;
import com.dce.service.EnquiryService;
import com.dce.service.UserService;
import com.dce.util.DceConstant;

@Controller
@RequestMapping(value = "/enquiry")
@Scope(value = "session")
public class EnquiryController extends BaseController {

	@Autowired
	EnquiryService studentEnquiryService;
	@Autowired
	EnquiryReportDao enquiryReportDao;
	@Autowired
	UserService userService;
	@Autowired
	EnquiryDao enquiryDao;

	public boolean TRUE = true;

	@ModelAttribute
	public ModelAndView enableEnquiryTabForAllRequest(ModelAndView result) {
		result.addObject(DceConstant.ENQUIRY_TAB, this.TRUE);
		return result;
	}

	@RequestMapping(value = "/show")
	public ModelAndView show(String UID) {
		ModelAndView result = this.getModelAndView("enquiry/listEnquiry");
		result.addObject("listEnquiry", this.enquiryReportDao.fetch());
		int i = 0;
		System.out.println(10 / i);
		return result;
	}

	@RequestMapping("enquiryForm")
	public ModelAndView enquiryForm() {

		return this.getModelAndView("enquiry/enquiryForm");
	}

	@RequestMapping(value = "/saveEnquiry")
	public ModelAndView saveEnquiry(@ModelAttribute Enquiry enquiry) {
		ModelAndView result = this.getModelAndView("enquiry/enquiryForm");

		if (enquiry != null && enquiry.getTempId().isEmpty()) {
			String tempID = this.studentEnquiryService.insert(enquiry);
		}
		this.studentEnquiryService.update(enquiry);
		result.addObject(DceConstant.ENQUIRY_TAB, this.TRUE);
//		result.addObject("message",
//				"Enquiry details saved successfully,Kindly note the Temporary ID for future refrence:- <mark style='color:green'>"
//						+ tempID + "</mark>");

		return result;
	}

	@RequestMapping(value = "/showChaseForm")
	public ModelAndView showChaseForm(String id) {

		return null;
	}

	@RequestMapping(value = "/editEnquiry")
	public ModelAndView editEnquiry(String tempId) {
		ModelAndView result = this.getModelAndView("enquiry/enquiryForm");

		result.addObject("studentenquiry", this.enquiryDao.getEnquiryByTempID(tempId));

		return result;
	}

}
