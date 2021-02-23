package com.dce.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DceExceptionController {
	@Autowired
	ServletContext servletContext;

	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView handleException() {
		ModelAndView result = new ModelAndView("error/error");
		result.addObject("baeUrl", this.servletContext.getContextPath());
		result.addObject("noHeader", true);

		return result;
	}
}
