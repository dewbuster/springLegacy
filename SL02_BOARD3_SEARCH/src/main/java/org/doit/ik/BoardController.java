package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService boardService;
	
	/* [1]
	@GetMapping("/list")
	public String list(Model model) {
		log.info("> BoardController.list()...");
		
		model.addAttribute("list", this.boardService.getList());
		
		return "/board/list";
	}
	*/
	/* [2]
	 * 페이징 처리가 안된 컨트롤러 메서드
	@GetMapping("/list")
	public void list(Model model) {
		log.info("> BoardController.list()...");
		model.addAttribute("list", this.boardService.getList());
	}
	*/

	/* [3]
	@GetMapping("/board/list")
	public ModelAndView list(ModelAndView mav) {
		log.info("> BoardController.list()...");
		mav.addObject("list", this.boardService.getList());
		mav.setViewName("/board/list");
		// return "/board/list"; 위에 맵핑과 동일할 경우 생략가능
		return mav;
	}
	*/
	// 페이징 처리가 된 컨트롤러 메서드
	@GetMapping("/list")
	public void list(Model model, Criteria criteria) {
		log.info("> BoardController.list()...");
		model.addAttribute("list", this.boardService.getListWithPaging(criteria));
		
		int total = this.boardService.getTotal(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("> BoardController.list()...");
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("> BoardController.list()...");
		this.boardService.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@PostMapping(value = {"/modify"})
	public String modify(BoardVO boardVO, Criteria criteria, RedirectAttributes rttr) {
		log.info("> BoardController.modify() POST...");
		if (this.boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "SUCCESS");
		} // if
		
		/*
		rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());
		rttr.addAttribute("type", criteria.getType());
		rttr.addAttribute("keyword", criteria.getKeyword());
		*/
		
		String params = criteria.getListLink();
		// System.out.println("XXX: " + params);
		
		return String.format("redirect:/board/get%s&bno=%d", params, boardVO.getBno());
		// return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
		// return String.format("redirect:/board/get?bno=%d&pageNum=%d&amount=%d", boardVO.getBno(), criteria.getPageNum(), criteria.getAmount());
	}
	
	// [3]
	// http://localhost/board/get?pageNum=5&amount=10&bno=119
	@GetMapping(value = {"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model
			, @ModelAttribute("criteria") Criteria criteria) {
		log.info("> BoardController.get()...");
		model.addAttribute("boardVO", this.boardService.get(bno));
	}

	/* [2]
	 * @GetMapping(value = {"/get", "/modify"}) public void get(@RequestParam("bno")
	 * Long bno, Model model, Criteria criteria) {
	 * 
	 * log.info("> BoardController.get()..."); model.addAttribute("boardVO",
	 * this.boardService.get(bno)); model.addAttribute("criteria", criteria);
	 * 
	 * }
	 */
	/* [1]
	@GetMapping(value = {"/get/{bno}"})
	public String get(@PathVariable("bno") Long bno, Model model) {
		log.info("> BoardController.get()...");
		model.addAttribute("boardVO", this.boardService.get(bno));
		return "/board/get";
	}
	*/
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno) {
		log.info("> BoardController.remove()...");
		this.boardService.remove(bno);
		return "redirect:/board/list";
	}
}
