package com.dgrm.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgrm.dto.TestVO;
import com.dgrm.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private TestService service;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	
	//home
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model,HttpServletRequest req) throws Exception {
		 
		
			List<TestVO> allContentList=null;
		
			
			allContentList = service.selectAllContents();
			model.addAttribute("allContentList", allContentList);
		
		
		return "home";
	}
	
	//전체항목 select
	@RequestMapping(value = "/select")
	public String selectContents(Locale locale, Model model,HttpServletRequest req) throws Exception {
		
		//logger.info("home");
		String contents=req.getParameter("contents");
		List<TestVO> allContentList=null;
		if(contents=="" || contents==null) {
			allContentList = service.selectAllContents();
		}
		{
			allContentList=service.selectOneContents(contents);
			//allContentList = service.selectAllContents();
		}
		
		
		model.addAttribute("allContentList", allContentList);
		System.out.println("조회됨");
		
		return "home";
	}
	
	//insert
	@RequestMapping(value = "/insert")
	public String insertContents(Locale locale, Model model,HttpServletRequest req) throws Exception {
		
		
		String str=req.getParameter("contents");
		if(str=="" || str==null) {
		
		}
		else {
			int res=service.insertContents(req.getParameter("contents"));
			if(res>0) this.home(locale, model, req);
		}
		
				
		return "home";
	}
	
	//update
	@RequestMapping(value = "/update")
	public String updateContents(Locale locale, Model model,HttpServletRequest req) throws Exception {
		
		TestVO vo= new TestVO();
		vo.setContents(req.getParameter("update_contents"));
		vo.setSeq(req.getParameter("seq"));
	
		if(vo.getSeq()=="" || vo.getSeq()==null) {
			System.out.println("값없음");
		}
		else {
			int res=service.updateContents(vo);
			if(res>0) this.home(locale, model, req);
		}
		
		
		return "home";
	}
	//delete
	@RequestMapping(value = "/delete")
	public String deleteContents(Locale locale, Model model,HttpServletRequest req) throws Exception {
		
		//TestVO vo= new TestVO();
		String del_str=req.getParameter("del_arr");
		String[] del_arr=del_str.split(",");
		//List del_arr= new ArrayList<String>();
		ArrayList<String>list = new ArrayList<String>();
		for (String str : del_arr) {
			list.add(str);
		}
		//ArrayList<String> del_arr = (ArrayList<String>) Arrays.asList(del_str.split(","));
		//for(del_str.split(",").size; )del_str.split(",");
		//vo.setSeq(req.getParameter("seq"));
		
		if(list.size()==0 ||list==null) {
			System.out.println("값없음");
		}
		else {
			
			int res=service.deleteContents(list);
			if(res>0) this.home(locale, model, req);
		}
		
		
		return "home";
	}
	
}
