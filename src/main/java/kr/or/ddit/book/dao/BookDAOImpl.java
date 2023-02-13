package kr.or.ddit.book.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

/*
 * Repository 어노테이션은 데이터에 접근하는 클래스임을 명시합니다.
 * 해당 어노테이션이 있는 클래스는 스프링이 데이터를 관리하는 클래스라고 인지하여 자바빈(JavaBean)으로 등록해서 관리한다.
 * 
 * SqlSessionTemplate 객체를 멤버 변수로 선언하는 이유는 mapper.xml 을 실행시키기 위해서이다.
 * 
 * 해당 객체 위에 어노테이션 Inject 또는 어노테이션 Autowired를 붙여서 sqlSessionTemplate 객체를 사용할 수 있도록 한다.
 * 이러한 형태를 '의존성 주입'= 이라고 한다.(필드 인젝션(Field Injection))
 */

@Repository
public class BookDAOImpl {
	
	// 데이터베이스와 통신을 담당하는 객체
	// 클래스로 존재하거나 어딘가에 인스턴스로 존재해야한다.
	
	//public int insert(Map<String, Object> map) {
		
	//}

}
