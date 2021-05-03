package com.mvc.update.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;
import com.mvc.update.model.dto.JDBCDto;

@Controller
public class JDBCController {
	
	@Autowired
	private JDBCBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(JDBCController.class);
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("[Controller] : list.do");
		
		model.addAttribute("list", biz.selectList());
		
		return "jdbclist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int seq) {
		logger.info("[Controller] : detail.do");
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("[Controller] : insertform.do");
		
		return "jdbcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(Model model, JDBCDto dto) {
		logger.info("[Controller] : insertres.do");
		
		if(biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
	}

	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int seq) {
		logger.info("[Controller] : updateform.do");
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(JDBCDto dto) {
		logger.info("[Controller] : updateres.do");
		
		if(biz.update(dto) > 0) {
			return "redirect:detail.do?seq="+dto.getSeq();
		}
		return "redirect:updateform.do?seq="+dto.getSeq();
	}
	
	@RequestMapping("/delete.do")
	public String delete(int seq) {
		logger.info("[Controller] : delete.do");
		
		if(biz.delete(seq) > 0){
			return "redirect:list.do";
		}
		return "redirect:detail.do?seq="+seq;
	}
	
}
