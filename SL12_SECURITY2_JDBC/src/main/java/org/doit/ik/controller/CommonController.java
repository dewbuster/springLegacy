package org.doit.ik.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

// 공지사항
@Controller
@Log4j
@RequestMapping("/common/*")
public class CommonController {

	//		Post -> 메인페이지 응답
	@GetMapping("/accessError.htm")
	public String accessDenied(Model model, Authentication auth) throws Exception{ 
		log.info("> /common/accessError.htm... GET");
		model.addAttribute("msg", "Access Denied");

		// /WEB-INF/views/common/accessError.jsp
		return "/common/accessError";
	}

} // class
