<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 게시글 등록 폼 -->
<meta charset="UTF-8">
<title>boardInsert</title>
</head>
<body>
	<div class="myboard-insert">
		<div class="container">
			<%@ include file="../../views/common/sidebar.jsp"%>
		</div>
		<form id="multiForm" action="/malant/binsert" method="post" enctype="multipart/form-data">
			<table width="500" border="1" cellspacing="0">
				<tbody>
					<tr>
						<th width="120">제 목</th>
						<td><input type="title" name="title" size="30" required></td>
					</tr>
					<tr>
						<th width="120">작성자</th>
						<td><input type="writer" name="writer" size="30" required></td>
					</tr>
					<tr>
						<th width="120">내 용</th>
						<td><textarea name="content" rows="5" cols="50"></textarea></td>
					</tr>
					<tr>
						<th width="120">첨부파일</th>
						<td><input type="file" name="multifile" id="multifile"
							multiple onchange="addHidden(); return false;"><br>
							<div id="filenamesView"></div></td>

						<script type="text/javascript">
							function addHidden() {
								const form = document
										.getElementById("multiForm");
								const multiFile = document
										.getElementById("multifile");
								const namesView = document
										.getElementById("filenamesView");

								for (var i = 0; i < multiFile.files.length; i++) {
									console.log(multiFile.files[i].name);
									var fname = multiFile.files[i].name;
									namesView.innerHTML += "<span>" + fname
											+ "</span><br>";

									var inputTag = document
											.createElement("input");
									inputTag.setAttribute("type", "hidden");
									inputTag.setAttribute("name", "filenames");
									inputTag.setAttribute("value", fname);

									form.appendChild(inputTag);
								}

								console.log(form.elements.length);
							}
						</script>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" value="글 등록하기">
						</th>
					</tr>
				</tbody>
			</table>
		</form>

	</div>

</body>
</html>