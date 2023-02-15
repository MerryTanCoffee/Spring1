package kr.or.ddit.book.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/*
 * Repository 어노테이션은 데이터에 접근하는 클래스임을 명시합니다.
 * 해당 어노테이션이 있는 클래스는 스프링이 데이터를 관리하는 클래스라고 인지하여 자바 빈(Java Bean)으로 등록해서 관리한다.
 * 
 * SqlSessionTemplate 객체를 멤버 변수로 선언하는 이유는 mapper xml을 실행시키기 위해서다.
 * 해당 객체 위에 어노테이션 Inject 또는 어노테이션 Autowired를 붙여서 sqlSessionTemplate 객체를 사용할 수 있도록한다.
 * 이러한 형태를 '의존성 주입'이라고 한다(필드 인젝션(Field Injection))
 */


@Repository
public class BookDAOImpl {
   
   //   데이터베이스와 통신을 담당하는 객체
   //   클래스로 존재하거나 어딘가에 인스턴스로 존재해야한다.
   @Inject
   SqlSessionTemplate sqlSessionTemplate;
   
   
   public int insertBook(Map<String, Object> map) {
	   
	   /*
	    * useGeneratedKeys와 keyProperty 설정에 따라서
	    * 쿼리가 실행되고 나면 파라미터로 전달된 map 객체에 book 테이블의 PK인 book_id 항목이 생긴다.
	    * 
	    * 기존 map ::::
	    * {
	    * "title" : "제목",
	    * "category" : "카테고리입니다",
	    * "price" : 1000
	    * }
	    * sqlSessionTemplate.insert()의 반환값은 쿼리의 영향을 받은 행수 (row count)이다
	    * insert 쿼리의 경우 성공하면 1개의 행(row)이 생기므로 1을 리턴하고 실패하면 0을 리턴한다.
	    */
      return sqlSessionTemplate.insert("Book.insert",map);
   }
   public Map<String, Object> selectBook(Map<String,Object> map) {
	   
	   /*
	    * sqlSessionTemplate 의 selectOne 메소드는 데이터를 한개만 가져올 때 사용한다.
	    * 만약 쿼리 결과 행 수가 0개이면 selectOne 메소드는 null을 반환하게 되고
	    * 쿼리 결과가 여러개이면 TooManyResultException 예외를 던진다.
	    * 우리가 작성한 쿼리는 조건이 PK이고 PK는 무조건 행이 유일함을 보장하기 때문에 결과는 0 또는 1이다.
	    * 
	    */
	   return sqlSessionTemplate.selectOne("Book.selectBook",map);
   }
   
   public int update(Map<String, Object> map) {
	   
	   /*
	    * sqlSessionTemplate 객체의 update 메소드는 insert 메소드와 사용법이 동일합니다.
	    * 첫번째 파라미터는 쿼리ID, 두번째 파라미터는 쿼리 파라미터이며 반환값은 영향 받은 행 수 입니다. 
	    */
	   return sqlSessionTemplate.update("Book.update",map);
   }
   
   public int delete(Map<String,Object> map) {
	
	   /*
	    * sqlSessionTemplate 객체의 delete 메소드는  update 메소드와 사용법이 동일합니다.
	    * 첫번째 파라미터는 쿼리ID, 두번째 파라미터는 쿼리 파라미터이며 반환값은 영향 받은 행 수 입니다. 
	    */
	   
	   return sqlSessionTemplate.delete("Book.delete", map);
   }
   
   public List<Map <String,Object>> selectList(Map<String, Object> map){
	   return sqlSessionTemplate.selectList("Book.selectBookList",map);
   }
}