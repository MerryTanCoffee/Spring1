package kr.or.ddit.book.service;

import java.util.Map;

public class BookServiceImpl implements IBookService {

	@Override
	public String insertBook(Map<String, Object> map) {
		
		// affectRowCount 변수에는 영향 받은 행 수가 담긴다.
		// insert 구문은 입력이 성공하면 1 실패하면 0을 리턴한다.
		//int affectRowCount = bookDao.insertBook(map);
		
		if(affectRowCount == 1) {
			// 결과가 성공일 시, map 인스턴스에 book 테이블의  pk인 book_id가 담겨있다.
			return map.get("book_id").toString();
		}
		return null;
	}

}
