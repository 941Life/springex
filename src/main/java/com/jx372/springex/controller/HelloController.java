package com.jx372.springex.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
			
	@RequestMapping( "/hello" )
	public String hello(@RequestParam("n") String name){
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping( "/hello2" )
	public ModelAndView hello2(
		//	@AuthUser UserVo authUser,
		@RequestParam String name ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject( "hello2", "Hello2 " + name );
		mav.setViewName( "/WEB-INF/views/index.jsp" );
		
		return mav;
	}
	
	@RequestMapping( "/hello3" )
	public String hello3(
		Model model,
		@RequestParam("n") String name ) {

		model.addAttribute("name" , name);
		return "/WEB-INF/views/index.jsp";
	}
	
	/* 기술이 침투 했기 때문에 비추천 */
	@RequestMapping("/hello4")
	public void hello4( HttpServletRequest request, Writer out){
		String name = request.getParameter( "name" );
		try {
			out.write("<H1>Hello " + name + "</H1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
