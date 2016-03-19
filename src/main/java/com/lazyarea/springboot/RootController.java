package com.lazyarea.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		mav.setViewName("index");
		mav.addObject("msg", "お名前を書いて送信してください。");
		return mav;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam(value="check1", required=false)boolean check1,
			@RequestParam(value="radio1", required=false)String radio1,
			@RequestParam(value="select1", required=false)String select1,
			@RequestParam(value="select2", required=false)String[] select2,
			ModelAndView mav){
		String res = "";
		try {
			res = "check:" + check1 + 
					" radio:" + radio1 + 
					" select1:" + select1 +
					"\nselect2:";
		}catch(NullPointerException e){}
		try{
			res += select2[0];
			for(int i=1; i< select2.length;i++){
				res += ", " + select2[i];
			}
		}catch(NullPointerException e){
				res += "null";
		}
		mav.addObject("msg", res);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav){
		mav.addObject("msg","total: " + num);
		mav.setViewName("index");
		return mav;
	}

}
