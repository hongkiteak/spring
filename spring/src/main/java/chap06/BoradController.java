package chap06;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoradController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/index.do")
	public String index(Model model, HttpServletRequest req, BoardVo vo) {
		List<BoardVo> list = boardService.selectList(vo);
		model.addAttribute("list", list);
		return "board/index";
	}
	@RequestMapping("/board/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/board/insert.do")
	public String insert(BoardVo vo, HttpServletRequest req) {
		int r =boardService.insert(vo);
		System.out.println("r:"+r);
		
		if(r>0) {
		req.setAttribute("msg", "정상적으로 등록되었습니다");
		req.setAttribute("url", "index.do");
		} else {
			req.setAttribute("msg", "등록 오류");
			req.setAttribute("url", "write.do");
		}
		
		
		return "include/result";
	}
	
	@GetMapping("/board/detail.do")
	public String detail(Model model, @RequestParam int boardno) {
		model.addAttribute("data", boardService.selectOne(boardno));
		return "board/detail";
	}
	@GetMapping("/board/detail2.do")
	public String detail2(Model model, @RequestParam int boardno) {
		model.addAttribute("data", boardService.selectOne2(boardno));
		return "board/detail";
	}
	@GetMapping("/board/edit.do")
	public String edit(Model model, @RequestParam int boardno) {
	model.addAttribute("data", boardService.selectOne(boardno));
	return "board/edit";
}
	@PostMapping("/board/update.do")
	public String update(Model  model,  BoardVo vo) {
		int r = boardService.update(vo);
		if(r>0) {
			model.addAttribute("msg", "정상적으로 수정되었습니다");
			model.addAttribute("url","detail.do?boardno="+vo.getBoardno());
		} else {
			model.addAttribute("msg","수정 오류");
			model.addAttribute("url","edit.do?boardno="+vo.getBoardno());
		}
		return "include/result";
	}
	@GetMapping("/board/delete.do")
	public String delete(Model  model,  BoardVo vo) {
		int r = boardService.delete(vo);
		if(r>0) {
			model.addAttribute("msg", "정상적으로 삭제되었습니다");
			model.addAttribute("url","index.do");
		} else {
			model.addAttribute("msg","삭제 오류");
			model.addAttribute("url","detail.do?boardno="+vo.getBoardno());
		}
		return "include/result";
	}
}
