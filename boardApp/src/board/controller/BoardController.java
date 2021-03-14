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
	
//	@Autowired // �ڵ����� �������ְڴ�.(�� springboard-servlet������ id = BoardDAO�� �̸��� ���ƾ� ��)
//	private BoardDAO boardDAO;

	@RequestMapping("/board_list.do")
	public String listBoard(HttpServletRequest req) {
		//List<BoardDBBean> result = boardDAO.listBoard();
		List<BoardDBBean> result = BoardMapper.listBoard();
		req.setAttribute("list", result);
		return "/board/list";	
	}
	
	@RequestMapping(value = "/board_write.do", method = RequestMethod.GET)// writeForm.do�� writePro.do �Ѵ� write.do��� �̸� ��� �޼ҵ� ��Ŀ� ���� �˾Ƽ� ã�ư�
	public String writeFormBoard() {
		return "/board/writeForm";
	}

	@RequestMapping(value = "/board_write.do", method = RequestMethod.POST)
	public ModelAndView writeProBoard(HttpServletRequest req, BoardDBBean dto) {// dto ��ü�� �˾Ƽ� ��(������ ��ũ�� getter,setter �˾Ƽ� ó������)
		
		dto.setIp(req.getRemoteAddr());
		
		String msg = null, url = null;		
		//int res = boardDAO.insertBoard(dto);
		int res = BoardMapper.insertBoard(dto);
		if (res > 0) {
			msg = "�Խñ� ��� ����";
			url = "board_list.do";
		}else {
			msg = "�Խñ� ��� ����";
			url = "board_list.do";			
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg",msg);
		mav.addObject("url",url);
		return mav;
	}
	
	@RequestMapping("/board_content.do")
	public ModelAndView contentBoard(@RequestParam int num) {// request�� parameter�� ���� num�ΰ��� �˾Ƽ� ������
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
			msg = "�ۻ��� ����!! �۸���������� �̵��մϴ�.";
			url = "board_list.do";
		}else if (res<0) {
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!";
			url = "board_delete.do?num=" + num;
		}else {
			msg = "�ۻ��� ����!! �ۻ󼼺����������� �̵��մϴ�.";
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
			msg = "�ۼ��� ����!! �۸���������� �̵��մϴ�.";
			url = "board_list.do";
		}else if (res<0) {
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���!!";
			url = "board_update.do?num=" + dto.getNum();
		}else {
			msg = "�ۼ��� ����!! �ۻ󼼺����������� �̵��մϴ�.";
			url = "board_content.do?num=" + dto.getNum();
		}
		ModelAndView mav = new ModelAndView("forward:message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
}








