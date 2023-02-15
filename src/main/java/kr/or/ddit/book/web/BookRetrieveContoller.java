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
	public ModelAndView list(@RequestParam Map<String,Object> map) {
		List<Map<String,Object>> bookList = bookService.selectBookList(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookList",bookList);
		
		// 검색 기능 추가
		// 목록 페이지에서는 keyword가 HTTP 파라미터가 있을 수도 있고 없을 수도 있다.
		// list.jsp에서 keyword 키에 키워드를 담아서 보냈을 때, 받는 파라미터  map에는
		// keyword라는 키로 값이 담겨 있을테니, map.containsKey 함수를 통해
		// keyword라는 키의 포함 여부를 확인하여 검색을 했는지 판단한다.
		if(map.containsKey("keyword")) {
			// 파라미터가 있다면 뷰에 keyword를 전달한다.
			mav.addObject("keyword", map.get("keyword"));
		}
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
