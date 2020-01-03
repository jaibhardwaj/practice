package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.models.Student;

@Controller
public class HelloController
{

	@ResponseBody
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> hello()
	{
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setStudentName("jai");
		Student s2 = new Student();
		s1.setStudentId(2);
		s1.setStudentName("Kri");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		return list;
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld()
	{

		ModelAndView model = new ModelAndView("HelloPage");
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setStudentName("jai");
		model.addObject("student",s1);
		model.addObject("msg","hello world");

		return model;
	}
	
}
