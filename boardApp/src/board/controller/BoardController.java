package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;
import board.dto.BoardDBBean;
import mybatis.BoardMapper;

@Controller // @ -> annotation
public class BoardController {
	
//	@Autowired // 자동으로 연결해주겠다.(단 springboard-servlet에서의 id = BoardDAO의 이름은 같아야 함)
//	private BoardDAO boardDAO;

	@RequestMapping("/board_list.do")
	public String listBoard(HttpServletRequest req) {
		//List<BoardDBBean> result = boardDAO.listBoard();
		List<BoardDBBean> result = BoardMapper.listBoard();
		req.setAttribute("list", result);
		return "/board/list";	
	}
	
	@RequestMapping(value = "/board_write.do", method = RequestMethod.GET)// writeForm.do와 writePro.do 둘다 write.do라고 이름 지어도 메소드 방식에 따라 알아서 찾아감
	public String writeFormBoard() {
		return "/board/writeForm";
	}

	@RequestMapping(value = "/board_write.do", method = RequestMethod.POST)
	public ModelAndView writeProBoard(HttpServletRequest req, BoardDBBean dto) {// dto 객체에 알아서 들어감(프레임 워크가 getter,setter 알아서 처리해줌)
		
		dto.setIp(req.getRemoteAddr());
		
		String msg = null, url = null;		
		//int res = boardDAO.insertBoard(dto);
		int res = BoardMapper.insertBoard(dto);
		if (res > 0) {
			msg = "게시글 등록 성공";
			url = "board_list.do";
		}else {
			msg = "게시글 등록 실패";
			url = "board_list.do";			
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg",msg);
		mav.addObject("url",url);
		return mav;
	}
	
	@RequestMapping("/board_content.do")
	public ModelAndView contentBoard(@RequestParam int num) {// request의 parameter의 값이 num인것을 알아서 가져옴
		//BoardDBBean dto = boardDAO.getBoard(num, "content");
		BoardDBBean dto = BoardMapper.getBoard(num, "content");
		return new ModelAndView("/board/content","getBoard",dto);
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public String deleteFormBoard() {
		return "/board/deleteForm";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProBoard(@RequestParam int num, @RequestParam String passwd) {
		//int res = boardDAO.deleteBoard(num, passwd);
		int res = BoardMapper.deleteBoard(num, passwd);
		String msg, url;
		if (res>0) {
			msg = "글삭제 성공!! 글목록페이지로 이동합니다.";
			url = "board_list.do";
		}else if (res<0) {
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요!!";
			url = "board_delete.do?num=" + num;
		}else {
			msg = "글삭제 실패!! 글상세보기페이지로 이동합니다.";
			url = "board_content.do?num=" + num;
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView updateFormBoard(@RequestParam int num) {
		//BoardDBBean dto = boardDAO.getBoard(num, "update");
		BoardDBBean dto = BoardMapper.getBoard(num, "update");
		return new ModelAndView("/board/updateForm", "getBoard", dto);
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public ModelAndView updateProBoard(@ModelAttribute BoardDBBean dto, BindingResult result) {
		if (result.hasErrors()) {
			dto.setNum(0);
		}
		System.out.println(dto.getSubject());
		//int res = boardDAO.updateBoard(dto);
		int res = BoardMapper.updateBoard(dto);
		String msg, url;
		if (res>0) {
			msg = "글수정 성공!! 글목록페이지로 이동합니다.";
			url = "board_list.do";
		}else if (res<0) {
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요!!";
			url = "board_update.do?num=" + dto.getNum();
		}else {
			msg = "글수정 실패!! 글상세보기페이지로 이동합니다.";
			url = "board_content.do?num=" + dto.getNum();
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
}








