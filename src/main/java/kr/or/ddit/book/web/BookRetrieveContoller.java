package kr.or.ddit.book.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookRetrieveContoller {
	
	@Inject
	private IBookService bookService;
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		List<Map<String,Object>> bookList = bookService.selectBookList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookList",bookList);
		mav.setViewName("book/list");
		return mav;
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET) 
	public ModelAndView detail(@RequestParam Map<String,Object> map) {
		Map<String,Object> detailMap = bookService.selectBook(map);
		
		ModelAndView mav = new ModelAndView();
		// ModelAndView 객체 mav에 뷰로 전달할 데이터를 담는다.
		// book이라는 키의 이름으로 쿼리의 결과를 담았다.
		mav.addObject("book",detailMap);
		
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId",bookId);
		mav.setViewName("book/detail");
		return mav;
	}
}
