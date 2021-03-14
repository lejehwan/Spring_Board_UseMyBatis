//package board.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
//
//import board.dao.BoardDAO;
//import board.dto.BoardDBBean;
//
//public class BoardContentController implements Controller{
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
//		//int num =  Integer.parseInt(req.getParameter("num")); 이거 대신에 아래와 같이 사용 가능
//		int num = ServletRequestUtils.getIntParameter(req, "num");
//		
//		BoardDBBean dto = boardDAO.getBoard(num,"content");
//		
//		ModelAndView mav = new ModelAndView("/board/content","getBoard",dto);
//		return mav;
//	}
//	
//
//}
