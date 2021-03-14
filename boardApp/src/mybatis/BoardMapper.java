package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dto.BoardDBBean;

public class BoardMapper {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);// resource�� ��üȭ ��Ŵ
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static List<BoardDBBean> listBoard(){
		SqlSession sqlSession = sqlSessionFactory.openSession();// db�� �ٷ�� ���� ��ü ����
		try {
			List<BoardDBBean> list = sqlSession.selectList("listBoard");// boardMapper.xml�� listBoard��� �̸����� ��
			return list;
		} finally {
			sqlSession.close();// db ����
		}
	}
	
	public static int insertBoard(BoardDBBean dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try {
			int res = sqlSession.insert("insertBoard",dto);
			sqlSession.commit();// commit�� ����� ��
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public static BoardDBBean getBoard(int num, String mode) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try {
			if (mode.equals("content")) {
				int res = sqlSession.update("plusCount",num);
				sqlSession.commit();
			}
			BoardDBBean dto = sqlSession.selectOne("getBoard",num);
			return dto;
		} finally {
			sqlSession.close();
		}
	}
	
	public static int deleteBoard(int num, String passwd) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			String dbPass = sqlSession.selectOne("isPassword",num);
			if (dbPass.equals(passwd)) {
				int res = sqlSession.delete("deleteBoard",num);
				sqlSession.commit();
				return res;
			} else {
				return -1;
			}
		} finally {
			sqlSession.close();
		}
	}
	
	public static int updateBoard(BoardDBBean dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			String dbPass = sqlSession.selectOne("isPassword",dto.getNum());
			if (dbPass.equals(dto.getPasswd())) {
				int res = sqlSession.update("updateBoard",dto);
				sqlSession.commit();
				return res;
			} else {
				return -1;
			}
		} finally {
			sqlSession.close();
		}
	}
	
}
