package board.dao;

import java.util.*;
import board.dto.*;

public interface BoardDAO {

	public List<BoardDBBean> listBoard();
	public BoardDBBean getBoard(int num, String mode);
	public int insertBoard(BoardDBBean dto);
	public int deleteBoard(int num, String passwd);
	public int updateBoard(BoardDBBean dto);
	
}
