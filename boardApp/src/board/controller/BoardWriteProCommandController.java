//package board.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.validation.BindException;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractCommandController;
//
//import board.dao.BoardDAO;
//import board.dto.BoardDBBean;
//
//public class BoardWriteProCommandController extends AbstractCommandController{
//	
//	private BoardDAO boardDAO;
//	
//	public void setBoardDAO(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
//
//	@Override
//	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object arg2, BindException arg3)
//			throws Exception {
//		BoardDBBean dto = (BoardDBBean)arg2;
//		dto.setIp(req.getRemoteAddr());// ip �ּ� ��������
//		String msg = null, url = null;
//		
//		int res = boardDAO.insertBoard(dto);
//		if (res > 0) {
//			msg = "�Խñ� ��� ����";
//			url = "board_list.do";
//		}else {
//			msg = "�Խñ� ��� ����";
//			url = "board_list.do";			
//		}
//		
//		ModelAndView mav = new ModelAndView("forward:message.jsp");
//		// redirect : request ���� �ʱ�ȭ�ؼ� �̵��� �Ѵ�.
//		// forward : request ���� ������ �̵��� �Ѵ�.
//		mav.addObject("msg",msg);
//		mav.addObject("url",url);
//		return mav;
//	}
//	
//
//}
