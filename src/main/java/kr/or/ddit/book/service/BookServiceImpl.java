package kr.or.ddit.book.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.book.dao.BookDAOImpl;

@Service
public class BookServiceImpl implements IBookService {
	
	/*
	 * Service 클래스는 비즈니스 클래스가 위치하는 곳이다.
	 * 스프링MVC 구조에서 서비스 클래스는 컨트롤러와 DAO를 연결하는 역할을 한다
	 * Service 어노테이션은 스프링에 서비스 클래스임을 알려준다.
	 * 
	 * 데이터베이스 접근을 위해 BookDao 인스턴스를 주입받는다.
	 * 클래스의 이름이 Impl로 끝나는 것은 Implements의 약자로 관습에 따른다.
	 * Impl이 붙고 안붙고에 따라 클래스인지 인터페이스인지 구별하기쉽다.
	 * 
	 */
	
	
	@Inject
	private BookDAOImpl bookDao;
	
	
	// 데이터베이스와 통신을 담당하는 객체
	// 클래스로 존재하거나 어딘가에 인스턴스로 존재해야한다.
	
	public String insertBook(Map<String, Object> map) {
		
		int affectRowCount = bookDao.insertBook(map);
		
		if (affectRowCount == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}


	@Override
	public Map<String, Object> selectBook(Map<String, Object> map) {
		
		// 서비스 내 detail을 출력하기 위한 selectBook 함수는 dao 를 호출한 결과를
		// 바로 리턴하는 일만 한다.
		return bookDao.selectBook(map);
	}


	@Override
	public boolean updateBook(Map<String, Object> map) {
		
		// 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차가 필요없으므로
		// 행이 정상적으로 영향 받았는지만 검사하면 된다. 
		int affectRowCount = bookDao.update(map);
		return affectRowCount == 1;
	}


	@Override
	public boolean removeBook(Map<String, Object> map) {
	
		// 삭제의 경우 수정과 동일하게 한개의 행이 제대로 영향 받았는지만 검사하면 된다.
		int affectRowCount = bookDao.delete(map);
		return affectRowCount == 1;
	}


	@Override
	public List<Map<String, Object>> selectBookList() {
		return bookDao.selectList();
	}

}
