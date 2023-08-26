/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-26 15:14:37 UTC
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Malant</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	table th { background-color: lightgreen; }\r\n");
      out.write("	table#outer { border: 2px solid navy; }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/malant/resources/common/js/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	// 유효성 검사\r\n");
      out.write("	function validate(){\r\n");
      out.write("		//암호와 암호확인이 일치하지 않는지 확인\r\n");
      out.write("		//var pwdValue = document.getElementById(\"userpwd\").value;\r\n");
      out.write("		//var pwdValue2 = document.getElementById(\"userpwd2\").value;\r\n");
      out.write("		//jQuery 선택자 사용으로 바꾼다면\r\n");
      out.write("		var pwdValue = $('#userpwd').val();\r\n");
      out.write("		var pwdValue2 = $('#userpwd2').val();\r\n");
      out.write("		\r\n");
      out.write("		if(pwdValue !== pwdValue2){\r\n");
      out.write("			alert(\"암호와 암호확인이 일치하지 않습니다. 다시 입력하세요.\");\r\n");
      out.write("			document.getElementById(\"userpwd2\").value = \"\";\r\n");
      out.write("			document.getElementById(\"userpwd\").select();\r\n");
      out.write("			return false;  //전송 취소함\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		//아이디의 값 형식이 요구한 대로 작성되었는지 검사\r\n");
      out.write("		//암호의 값 형식이 요구한 대로 작성되었는지 검사\r\n");
      out.write("		//정규표현식(Regular Expression) 사용함\r\n");
      out.write("		\r\n");
      out.write("		return true;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 아이디 중복 검사\r\n");
      out.write("	function dupIdCheck(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: \"/malant/checkdupid\",\r\n");
      out.write("			type: \"post\",\r\n");
      out.write("			data: { userid: $('#userid').val() },\r\n");
      out.write("			success: function(data) {\r\n");
      out.write("				if(data == \"ok\") {\r\n");
      out.write("					alert(\"사용 가능한 아이디입니다.\");\r\n");
      out.write("				} else {\r\n");
      out.write("					alert(\"이미 사용중인 아이디입니다.\");\r\n");
      out.write("					$('#userid').select();\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			error: function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("				console.log(\"error : \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>일반회원 가입페이지</h1>\r\n");
      out.write("	<br>\r\n");
      out.write("	<form action=\"/malant/menroll\" method=\"post\" onsubmit=\"return validate():\">\r\n");
      out.write("		<table id=\"outer\" align=\"center\" width=\"500\" cellspacing=\"5\" cellpadding=\"0\">\r\n");
      out.write("			<tr><th colspan=\"3\">회원 정보를 입력해 주세요. (* 표시는 필수입력 항목입니다.)</th></tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">아이디*</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<input type=\"text\" name=\"userid\" id=\"userid\" required> &nbsp;\r\n");
      out.write("					<input type=\"button\" value=\"중복체크\" onclick=\"return dupIdCheck();\">\r\n");
      out.write("				</td>\r\n");
      out.write("				<td rowspan=\"3\" width=\"100\">프로필 사진 영역</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr><th>*암호</th>\r\n");
      out.write("			<td><input type=\"password\" name=\"userpwd\" id=\"userpwd\" required></td></tr>\r\n");
      out.write("			<tr><th>*암호확인</th>\r\n");
      out.write("			<td><input type=\"password\" id=\"userpwd2\" required></td></tr>\r\n");
      out.write("			<tr><th>*이름</th>\r\n");
      out.write("			<td><input type=\"text\" name=\"username\" required></td></tr>\r\n");
      out.write("			<tr><th>*성별</th>\r\n");
      out.write("			<td>\r\n");
      out.write("				<input type=\"radio\" name=\"gender\" value=\"M\"> 남자 &nbsp;\r\n");
      out.write("				<input type=\"radio\" name=\"gender\" value=\"F\"> 여자\r\n");
      out.write("			</td></tr>\r\n");
      out.write("			<tr><th>*나이</th>\r\n");
      out.write("			<td><input type=\"number\" name=\"age\" min=\"19\" value=\"20\" required></td></tr>\r\n");
      out.write("			<tr><th>*전화번호</th>\r\n");
      out.write("			<td><input type=\"tel\" name=\"phone\" required></td></tr>\r\n");
      out.write("			<tr><th>*이메일</th>\r\n");
      out.write("			<td><input type=\"email\" name=\"email\" required></td></tr>\r\n");
      out.write("			<tr><th>취미(연습용)</th>\r\n");
      out.write("			<td>\r\n");
      out.write("				<table width=\"350\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"game\"> 게임</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"reading\"> 독서</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"climb\"> 등산</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"sport\"> 운동</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"music\"> 음악</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"movie\"> 영화</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"travel\"> 여행</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"gook\"> 요리</td>\r\n");
      out.write("					<td><input type=\"checkbox\" name=\"hobby\" value=\"etc\" checked> 기타</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("			</td></tr>\r\n");
      out.write("			<tr><th>기타 정보(연습용)</th>\r\n");
      out.write("			<td><textarea name=\"etc\" rows=\"3\" cols=\"50\"></textarea></td></tr>\r\n");
      out.write("			<tr><th colspan=\"2\">\r\n");
      out.write("				<input type=\"submit\" value=\"가입하기\"> &nbsp;\r\n");
      out.write("				<input type=\"reset\" value=\"작성취소\"> &nbsp;\r\n");
      out.write("				<a href=\"/first/index.jsp\">시작페이지로 이동</a>\r\n");
      out.write("			</th></tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
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
