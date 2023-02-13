<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
<title>책 생성하기</title>
</head>
<body>

<!-- 
	form.jsp 뷰튼 화면을 담당합니다.
	웹 애플리케이션에서 화면은 웹 브라우저가 랜더링하므로 브라우저가 읽어서 해석할 수 있는 HTML로 최종 변환할 수 있도록 작성합니다.
	form.jsp 뷰는 제목, 카테고리, 가격을 입력 받을 수 있는 형식을 가진 HTML입니다.
	
	저장 버튼을 클릭하면 form~/form 태그 안의 내용이 서버로 전송됩니다.
	서버로 전달되는 항목들은(input과 같은 데이터 관장 요소) form 태그 안에 존재해야 하고, name 속성을 가져야합니다.
	서버는  name 속성을 키로 value 속성을 값으로 판단합니다.
	
	post 방식은 http 파라미터가 주소창에 노출되지 않고 주소창의 변화없이 데이터만 서버로 전달할 수 있습니다. 
 -->
	<div class="jumbotron">
		<div class="container">
			<h2 class="display-4">책 생성하기</h2>
		</div>
	</div>
	<div class="container">
		<form action="" method="post">
			<div class="row">
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="title" class="col-form-label">제목</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="title" id="title"/>
						</div>	
					</div>
				</div>
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="category" class="col-form-label">카테고리</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="category" id="category"/>
						</div>	
					</div>
				</div>
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="price" class="col-form-label">가격</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="price" id="price"/>
						</div>	
					</div>
				</div>
				<button type="submit" class="btn btn-warning">등록</button>
				<a href="" class="btn btn-primary">목록</a>
			</div>
		</form>
	</div>
</body>
</html>