/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-30 12:18:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enrollMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Malant</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("	table th { background-color: lightgreen; }\n");
      out.write("	table#outer { border: 2px solid navy; }\n");
      out.write("	.profile {\n");
      out.write("		visibility: hidden;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"/malant/resources/common/js/jquery-3.7.0.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("	dupIdFlag = true;\n");
      out.write("	dupEmailFlag = true;\n");
      out.write("\n");
      out.write("	// function dupIdCheck() {\n");
      out.write("	// 	$.ajax({\n");
      out.write("	// 		url: '/malant/checkdupid',\n");
      out.write("	// 		type: 'post',\n");
      out.write("	// 		data: { userid: $('#userid').val() },\n");
      out.write("	// 		success: function(data) {\n");
      out.write("	// 			if(data == \"ok\") {\n");
      out.write("	// 				dupIdFlag = false;\n");
      out.write("	// 				alert('사용 가능한 아이디입니다.');\n");
      out.write("	// 			} else {\n");
      out.write("	// 				dupIdFlag = true;\n");
      out.write("	// 				alert('이미 사용중인 아이디입니다.');\n");
      out.write("	// 				$('#userid').select();\n");
      out.write("	// 			}\n");
      out.write("	// 		},\n");
      out.write("	// 		error: function(jqXHR, textStatus, errorThrown){\n");
      out.write("	// 			console.log(\"error : \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\n");
      out.write("	// 		}\n");
      out.write("	// 	});\n");
      out.write("		\n");
      out.write("	// 	return false;\n");
      out.write("	// }\n");
      out.write("	\n");
      out.write("	function confirmEmail() {\n");
      out.write("		$.ajax({\n");
      out.write("			url: '/malant/econfirm',\n");
      out.write("			type: 'post',\n");
      out.write("			data: { email: $('#email').val() },\n");
      out.write("			success: function(data) {\n");
      out.write("				if(data == \"ok\") {\n");
      out.write("					alert('이메일로 인증 코드가 전송되었습니다. 이메일을 확인해주세요.');\n");
      out.write("				} else {\n");
      out.write("					alert('이미 사용중인 이메일입니다.');\n");
      out.write("				}\n");
      out.write("			},\n");
      out.write("			error: function(jqXHR, textStatus, errorThrown){\n");
      out.write("				console.log(\"error : \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("		\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function validateId() {\n");
      out.write("		$.ajax({\n");
      out.write("			url: '/malant/checkdupid',\n");
      out.write("			type: 'post',\n");
      out.write("			data: { userid: $('#userid').val() },\n");
      out.write("			success: function(data) {\n");
      out.write("				if(data != \"ok\") {\n");
      out.write("					dupIdFlag = true;\n");
      out.write("				}\n");
      out.write("			},\n");
      out.write("			error: function(jqXHR, textStatus, errorThrown){\n");
      out.write("				console.log(\"error : \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("\n");
      out.write("		return false;\n");
      out.write("	}\n");
      out.write("\n");
      out.write("	function dupIdCheck() {\n");
      out.write("		var id = $('#userid');\n");
      out.write("		var cid = /^(?=.*[a-zA-Z0-9])[A-Za-z0-9]{8,12}$/;\n");
      out.write("\n");
      out.write("		if (!cid.test(id.val())) {\n");
      out.write("			alert(\"아이디는 영어 대소문자와 숫자를 포함해서 8~12글자로 작성해주세요.\");\n");
      out.write("			id.select();\n");
      out.write("			return false;\n");
      out.write("		} else {\n");
      out.write("			$.ajax({\n");
      out.write("				url: '/malant/checkdupid',\n");
      out.write("				type: 'post',\n");
      out.write("				data: { userid: id.val() },\n");
      out.write("				success: function(data) {\n");
      out.write("					if(data == \"ok\") {\n");
      out.write("						dupIdFlag = false;\n");
      out.write("						alert('사용 가능한 아이디입니다.');\n");
      out.write("					} else {\n");
      out.write("						dupIdFlag = true;\n");
      out.write("						alert('이미 사용중인 아이디입니다.');\n");
      out.write("						id.select();\n");
      out.write("					}\n");
      out.write("				},\n");
      out.write("				error: function(jqXHR, textStatus, errorThrown){\n");
      out.write("					console.log(\"error : \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\n");
      out.write("				}\n");
      out.write("			});\n");
      out.write("			\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("\n");
      out.write("\n");
      out.write("	function validate() {Id\n");
      out.write("		var id = $('#userid');\n");
      out.write("		var pwd = $('#userpwd');\n");
      out.write("		var pwd2 = $('#userpwd2');\n");
      out.write("		var nick = $('#nickname');\n");
      out.write("		var email = $('#email');\n");
      out.write("		\n");
      out.write("		//유효성검사를 위한 조건식 지정\n");
      out.write("		var cid = /^(?=.*[a-zA-Z0-9])[A-Za-z0-9]{8,12}$/;\n");
      out.write("		var cpwd = /^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$])[a-zA-Z\\d@!#$]{6,12}[a-zA-Z\\d@!#$]$/;\n");
      out.write("		var cnick = /^[A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{0,8}$/;\n");
      out.write("		var cemail = /^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,}$/;\n");
      out.write("		\n");
      out.write("		validateId();\n");
      out.write("\n");
      out.write("		if(dupIdFlag) {\n");
      out.write("			alert(\"아이디 중복 검사를 진행해주세요.\");\n");
      out.write("			id.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if(dupEmailFlag) {\n");
      out.write("			alert(\"이메일 인증을 진행해주세요.\");\n");
      out.write("			email.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if (!cid.test(id.val())) {\n");
      out.write("			alert(\"아이디는 영어 대소문자와 숫자를 포함해서 8~12글자로 작성해주세요.\");\n");
      out.write("			id.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if (!cpwd.test(pwd.val())) {\n");
      out.write("			alert(\"패스워드는 영어 대,소문자와 숫자를 포함하고,!@#$기호중 하나를 포함시켜 6~12글자로 사용해주세요.\");\n");
      out.write("			pwd.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if(pwd.val() != pwd2.val()) {\n");
      out.write("			alert(\"비밀번호와 비밀번호 확인이 일치하지 않습니다.\");\n");
      out.write("			pwd2.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if (!cnick.test(nick.val())) {\n");
      out.write("			alert(\"닉네임은 8자 이하로 작성해주세요.\");\n");
      out.write("			nick.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		if (!cemail.test(email.val())) {\n");
      out.write("			alert(\"이메일은 test@enroll.com 형태로 작성해주세요.\");\n");
      out.write("			email.select();\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		return true;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function uploadProfile() {\n");
      out.write("		$('.profile').click();\n");
      out.write("	}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<h1>개인회원 가입 페이지</h1>\n");
      out.write("	<br>\n");
      out.write("	<form action=\"/malant/menroll\" method=\"post\" onsubmit=\"return validate();\">\n");
      out.write("		<input type=\"file\" name=\"profile\" class=\"profile\" id=\"profile\" accept=\"image/*\">\n");
      out.write("		<input type=\"hidden\" name=\"signtype\" value=\"common\">\n");
      out.write("		<table id=\"enroll-table\" align=\"center\" width=\"600\" cellspacing=\"5\" cellpadding=\"0\">\n");
      out.write("			<tr><th colspan=\"3\">회원가입 (* 필수항목)</th></tr>\n");
      out.write("			<tr>\n");
      out.write("				<th width=\"150\">아이디*</th>\n");
      out.write("				<td>\n");
      out.write("					<input type=\"text\" name=\"userid\" id=\"userid\" placeholder=\"아이디\" required> \n");
      out.write("					<input type=\"button\" value=\"중복체크\" onclick=\"return dupIdCheck();\"> <br>\n");
      out.write("				</td>\n");
      out.write("				<!-- 업로드한 프로필 사진이 보여질 영역 -->\n");
      out.write("				<td rowspan=\"4\" width=\"150\" height=\"200\" bgcolor=\"lightgreen\" class=\"profile-area\">프로필 사진 영역</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>비밀번호*</th>\n");
      out.write("				<td><input type=\"password\" name=\"userpwd\" id=\"userpwd\" placeholder=\"비밀번호\" required></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>비밀번호확인*</th>\n");
      out.write("				<td><input type=\"password\" id=\"userpwd2\" placeholder=\"비밀번호 확인\" required></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>닉네임*</th>\n");
      out.write("				<td><input type=\"text\" name=\"nickname\" id=\"nickname\" placeholder=\"닉네임\" required></td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>이메일*</th>\n");
      out.write("				<td>\n");
      out.write("					<input type=\"email\" id=\"email\" name=\"email\" placeholder=\"이메일\" required> \n");
      out.write("					<input type=\"button\" value=\"인증 요청\" onclick=\"return checkEmail();\">\n");
      out.write("				</td>\n");
      out.write("				<!-- 프로필 사진 첨부 버튼 -->\n");
      out.write("				<td><input type=\"button\" value=\"사진 추가\" onclick=\"return uploadProfile();\"></td>\n");
      out.write("			</tr>\n");
      out.write("			<!-- 이메일 인증 구현\n");
      out.write("			<tr>\n");
      out.write("				<th>이메일 인증*</th>\n");
      out.write("				<td>\n");
      out.write("					<input type=\"number\" class=\"econfirm\" name=\"inputtoken\" placeholder=\"인증번호\" disabled> \n");
      out.write("					<input type=\"button\" class=\"econfirm\" value=\"인증\" disabled>\n");
      out.write("				</td>\n");
      out.write("			</tr>\n");
      out.write("			 -->\n");
      out.write("			<tr>\n");
      out.write("				<th>이메일 수신 여부</th>\n");
      out.write("				<td colspan=\"2\">\n");
      out.write("					<input type=\"checkbox\" id=\"check-alarm\" name=\"alarm\"> 식물 관리 알림<br>\n");
      out.write("					<input type=\"checkbox\" id=\"check-notice\" name=\"notice\"> 이벤트 및 마케팅 정보\n");
      out.write("				</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th colspan=\"3\">\n");
      out.write("					<input type=\"submit\" value=\"가입하기\"> &nbsp;\n");
      out.write("					<input type=\"button\" value=\"이전페이지로\" onclick=\"javascript: history.go(-1);\"> &nbsp;\n");
      out.write("					<input type=\"button\" value=\"메인페이지로\" onclick=\"javascript: location.href='/malant/index.jsp';\">\n");
      out.write("				</th>\n");
      out.write("			</tr>\n");
      out.write("		</table>\n");
      out.write("	</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
