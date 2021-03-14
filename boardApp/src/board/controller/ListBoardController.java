//package board.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
//
//import board.dao.BoardDAO;
//import board.dto.BoardDBBean;
//
//public class ListBoardController implements Controller {
//	
//	//DI 의존성 주입
//	private BoardDAO boardDAO;
//
//	public void setBoardDAO(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
//		
//		List<BoardDBBean> result = boardDAO.listBoard();
//		
//		ModelAndView mav = new ModelAndView();// request에 저장하는 대신 spring 에서는 ModelAndView에 저장
//		mav.addObject("list",result);
//		mav.setViewName("/board/list");
//		return mav;
//		
//	}
//
//}
