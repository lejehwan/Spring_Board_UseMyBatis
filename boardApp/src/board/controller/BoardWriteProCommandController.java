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
//		dto.setIp(req.getRemoteAddr());// ip 주소 가져오기
//		String msg = null, url = null;
//		
//		int res = boardDAO.insertBoard(dto);
//		if (res > 0) {
//			msg = "게시글 등록 성공";
//			url = "board_list.do";
//		}else {
//			msg = "게시글 등록 실패";
//			url = "board_list.do";			
//		}
//		
//		ModelAndView mav = new ModelAndView("forward:message.jsp");
//		// redirect : request 값을 초기화해서 이동을 한다.
//		// forward : request 값을 가지고 이동을 한다.
//		mav.addObject("msg",msg);
//		mav.addObject("url",url);
//		return mav;
//	}
//	
//
//}
