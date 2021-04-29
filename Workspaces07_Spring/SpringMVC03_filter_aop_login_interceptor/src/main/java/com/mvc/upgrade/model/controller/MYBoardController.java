package com.mvc.upgrade.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {
	
	private Logger logger = LoggerFactory.getLogger(MYBoardController.class);
	
	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("[Controller] : list.do");
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		logger.info("[Controller] : detail.do");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboarddetail";
	}
	
	@RequestMapping("/writeform.do")
	public String insertForm() {
		logger.info("[Controller] : writeform.do");
		
		return "myboardinsert";
	}
	
	@RequestMapping(value="/writeres.do", method=RequestMethod.POST)
	public String insertRes(MYBoardDto dto) {
		logger.info("[Controller] : writeres.do");
		
		if(biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		return "redirect:writeform.do";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("[Controller] : updateform.do");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		logger.info("[Controller] : updateres.do");
		
		if(biz.update(dto) > 0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}
		return "redirect:updateform.do?myno="+dto.getMyno();
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("[Controller] : delete.do");
		
		if(biz.delete(myno) > 0){
			return "redirect:list.do";
		}
		return "redirect:detail.do?myno="+myno;
	}

}
