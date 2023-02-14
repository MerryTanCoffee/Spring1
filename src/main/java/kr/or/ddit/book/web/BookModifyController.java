package kr.or.ddit.book.web;

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
public class BookModifyController {

	/*
	 * 서비스를 호출하기 위해 IBookService 의존성을 주입한다.
	 */
	
	@Inject
	private IBookService bookService;
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String,Object> detailMap = bookService.selectBook(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", detailMap);
		mav.setViewName("book/update");
		return mav;
		
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ModelAndView updateBook(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		boolean isUpdateSuccess = bookService.updateBook(map);
		
		if(isUpdateSuccess) { // 정상
			// 업데이트가 정상적으로 데이터 갱신되었을 때 확인을 위해 상세페이지로 이동한다.
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);			
		} else { // 실패
			// 갱신이 되지 않았을 경우 , GET 메소드로 redirect하는 방법도 있지만
			// 상세보기 화면을 바로 보여줄 수 있습니다.

			mav = update(map);
		}
		return mav;
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		// 삭제가 성공했는지 확인
		boolean isDeleteSuccess = bookService.removeBook(map);
		if(isDeleteSuccess) {	// 삭제 완료
			// 삭제가 성공했으면 상세페이지가 없으므로 목록으로  redirect한다.
			mav.setViewName("redirect:/book/list.do");
		} else {
			// 삭제가 실패했으면 다시 상세 페이지로 이동하여 삭제를 재시도 할 수 있도록 한다.
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/datail.do?bookId="+bookId);
		}
		return mav;
	}

}
