package org.zerock.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
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
//	@GetMapping("/list") 
	// 메소드가 void 타입의 경우 return 경로가 view(jsp)가 됨
	// 이 메소드는 (/board/list) -> /board/list.jsp
//	public void list(Model model) {
//		log.info("***** list, 누군가 접속 or 새로고침 *****");
//		List<BoardVO> list = service.getlist();
//		model.addAttribute("list", list);		
//	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("criteria") Criteria cri, Model model) {
		List<BoardVO> list = service.getlist(cri);
		
		int total = service.getTotal(cri);
		
		PageDTO dto = new PageDTO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", dto);
		
	}
	
//	@RequestMapping(value="/register", method = RequestMethod.POST)
	
	@GetMapping("/register")
	public void register(@ModelAttribute("criteria") Criteria cri) {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
//		BoardVO board = new BoardVO();
//		board.setTitle(request.getParameter("title"));
//		board.setContent(request.getParameter("content"));
//		board.setWriter(request.getParameter("writer"));		
		
		service.register(board);
		
		
		rttr.addFlashAttribute("result", board.getBno());
		log.info("***** register, 누군가 게시물 작성 : " + board.getBno());
//		return "/board/list";
		return "redirect:/board/list";
	}
	
	//
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, 
			@ModelAttribute("criteria") Criteria cri, Model model) {
		// 
		/** 예전 코드 (스프링 없이) 
		String boardNum = request.getParameter("num");
		int num = Integer.parseInt(boardNum);
		
		BoardVO vo = service.get((long) num);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(".jsp").forward();
		*/
		
		log.info("게시물 클릭(read) :" + bno);
		log.info(cri);
		
		BoardVO vo = service.get(bno);
		
		// 쿼리문으로 붙어서 감
		model.addAttribute("board", vo);
//		model.addAttribute("cri", cri);
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
			Criteria cri, RedirectAttributes rttr) {
		
		if (service.remove(bno)) {
			rttr.addFlashAttribute("resultRemove", bno);
			log.info("***** register, 누군가 게시물 삭제 : " + bno);
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());	
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("resultModify", board.getBno());		
			log.info("***** register, 누군가 게시물 수정 : " + board.getBno());
		}		
		
		log.info(cri);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
//	
//	@GetMapping("modify")
//	public void modify(Long bno, Model model) {
//		BoardVO vo = service.get(bno);
//		
//		model.addAttribute("board", vo);
//	}
//	
}


// servlet/jsp
// ControllerUsingURI(Servlet) ....properties 안의 설정으로
// /list.do=ListHandler "=" 경로의 앞으로 오면 "=" 의 클래스로 이동했음