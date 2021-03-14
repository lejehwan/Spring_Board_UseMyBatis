//package board.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.validation.BindException;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractCommandController;
//import org.springframework.web.servlet.mvc.Controller;
//
//import board.dao.BoardDAO;
//
//public class BoardDeleteProController implements Controller{
//	
//	private BoardDAO boardDAO;
//	
//	public void setBoardDAO(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		
//		int num = ServletRequestUtils.getIntParameter(req, "num");
//		String passwd = req.getParameter("passwd");
//		
//		int res = boardDAO.deleteBoard(num, passwd);
//		
//		String msg = null, url = null;
//		if (res > 0) {
//			msg = "�Խñ� ���� ����";
//			url = "board_list.do";
//		}else if(res<0){
//			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
//			url = "board_deleteForm.do?num =" +num;			
//		} else {
//			msg = "�Խñ� ���� ����";
//			url = "board_content.do?num =" +num;		
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
