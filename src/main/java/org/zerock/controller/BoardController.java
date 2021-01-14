package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	
	private BoardService service;	

	// 211 page 표
	
//	@RequestMapping(value="/list", method = RequestMethod.GET)
	@GetMapping("/list") 
	// 메소드가 void 타입의 경우 return 경로가 view(jsp)가 됨
	// 이 메소드는 (/board/list) -> /board/list.jsp
	public void list(Model model) {
		log.info("******************* list *******************");
		List<BoardVO> list = service.getlist();
		model.addAttribute("list", list);
		
	}
	
//	@RequestMapping(value="/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
//		BoardVO board = new BoardVO();
//		board.setTitle(request.getParameter("title"));
//		board.setContent(request.getParameter("content"));
//		board.setWriter(request.getParameter("writer"));		
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get() {
		
	}
	
	@PostMapping("/remove")
	public int remove() {
		return 0;
	}
	
	@PostMapping("/modify")
	public String modify() {
		return null;
	}
}


// servlet/jsp
// ControllerUsingURI(Servlet) ....properties 안의 설정으로
// /list.do=ListHandler "=" 경로의 앞으로 오면 "=" 의 클래스로 이동했음