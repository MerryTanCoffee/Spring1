package kr.or.ddit.book.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.IBookService;

/*
 * @Controller 어노테이션이 있는 클래스는 스프링이 브라우저의 요청(request)을 받아들이는 컨트롤러라고 인지해서
 * 자바빈(Java Bean)으로 등록해서 관리한다.
 */

@Controller
@RequestMapping("/book")
public class BookInsertController {
	
	@Inject
	private IBookService bookService;
	
	/*
	 * @RequestMapping
	 * - 요청 URL을 어떤 메소드가 처리할 지 여부를 결정
	 * 
	 * method 속성은 http 요청 메소드를 의미합니다.
	 * 일반적인 웹 페이지 개발에서 GET 메소드는 데이터를 변경하지 않는 경우에,
	 * POST 메소드는 데이터가 변경될 경우에 사용됩니다.
	 * 
	 * ModelAndView 는 컨트롤러가 반환할 데이터를 담당하는 모델(Model)과 화면을 담당하는  뷰(View)의 경로를 합쳐놓은 객체
	 * ModelAndView의 생성자에 문자열 타입 파라미터가 입력되면 뷰의 경로라고 간주합니다.
	 */
	
	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public ModelAndView bookForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", "홍길동쓰");
		mav.setViewName("book/form");
		return new ModelAndView("book/form");
		// servlet-context.xml에서 /WEB-INF/views/를 앞에 붙여주고 뒤에 .jsp 붙여줌
	}
	
	/*
	 * 데이터의 변경이 일어나므로 http메소드는 POST 방식으로 처리한다.
	 * RequestParam 어노테이션은 HTTP 파라미터를 map 변수에 자동으로 바인딩합니다.
	 * Map 타입의 경우는 RequestParam 어노테이션을 붙여야만 HTTP 파라미터의 값을 map 안에 바인딩 해줍니다.
	 */
	
	@RequestMapping(value = "/form.do", method = RequestMethod.POST)
	public ModelAndView insertBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		// 서비스한테 브라우저에서 넘어온 책 정보들을 등록
		// Service한테 등록 기능을 요청한다.
		String bookId = bookService.insertBook(map);
	
		if(bookId == null) {
			mav.setViewName("redirect:/book/form.do");
		} else {
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);
		}
		return mav;
	}
	
}
