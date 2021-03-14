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
//public class BoardUpdateProCommandController extends AbstractCommandController{
//	
//private BoardDAO boardDAO;
//	
//	public void setBoardDAO(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
//
//	@Override
//	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object arg2, BindException arg3)
//			throws Exception {
//		
//		BoardDBBean dto = (BoardDBBean)arg2;
//				
//		int res = boardDAO.updateBoard(dto);
//		
//		String msg = null, url = null;
//		if (res > 0) {
//			msg = "�Խñ� ���� ����";
//			url = "board_list.do";
//		}else if(res<0){
//			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
//			url = "board_updateForm.do?num =" +dto.getNum();			
//		} else {
//			msg = "�Խñ� ���� ����";
//			url = "board_content.do?num =" +dto.getNum();		
//		}
//		
//		ModelAndView mav = new ModelAndView("forward:message.jsp");
//		mav.addObject("msg",msg);
//		mav.addObject("url",url);
//		return mav;
//	}
//	
//	
//
//}
