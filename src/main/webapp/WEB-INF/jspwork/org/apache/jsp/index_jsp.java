/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
<<<<<<< HEAD
 * Generated at: 2023-08-28 00:31:19 UTC
=======
 * Generated at: 2023-08-28 00:36:00 UTC
>>>>>>> a6fb4bf6842c925013e85b1e3227c3ed0fb08bba
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import common.JDBCTemplate;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
<<<<<<< HEAD
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/./views/common/sidebar.html", Long.valueOf(1693182316873L));
    _jspx_dependants.put("/./views/search/searchMain.jsp", Long.valueOf(1693182316873L));
=======
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./views/common/sidebar.html", Long.valueOf(1693119036836L));
>>>>>>> a6fb4bf6842c925013e85b1e3227c3ed0fb08bba
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("common.JDBCTemplate");
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
      out.write("<!-- index.jsp -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>Malant</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/malant/resources/common/css/sidebar.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/malant/resources/common/css/scrolling.css\" />\r\n");
      out.write("    <script src=\"/malant/resources/common/js/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/malant/resources/common/js/scroll_behavior.js\"></script>\r\n");
      out.write("    <script src=\"/malant/resources/common/js/scroll_loading.js\"></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("    	div.container > div {\r\n");
      out.write("    		float: left;\r\n");
      out.write("    	}\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <!-- 사이드바 -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
<<<<<<< HEAD
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/malant/resources/common/css/sidebar.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/malant/resources/common/css/font.css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	// 로그인 유효성 검사\r\n");
      out.write("	/* function validate() {\r\n");
      out.write("		var loginid = $('#loginid').val();\r\n");
      out.write("		var loginpwd = $('#loginpwd').val();\r\n");
      out.write("		var checkRegex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣| ]/;\r\n");
      out.write("		\r\n");
      out.write("		// 유효성 검사\r\n");
      out.write("		if(checkRegex.test(loginid) || checkRegex.test(loginpwd) || !(loginid.length >= 6 && loginpwd <= 12)) {\r\n");
      out.write("			// 잘못 입력함을 알리는 메시지창 출력\r\n");
      out.write("			alert(\"아이디 또는 비밀번호를 확인해주세요.\");\r\n");
      out.write("			console.log('유효성 검사 오류');\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		return true;\r\n");
      out.write("	} */\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"sidebar\">\r\n");
      out.write("		<div class=\"sidebar-header\">\r\n");
      out.write("			<span class=\"sidebar-title\">\r\n");
      out.write("				<a href=\"/malant\"><img src=\"/malant/resources/common/images/main_tilte.gif\" alt=\"로고\" /></a>\r\n");
      out.write("			</span>\r\n");
      out.write("		</div>\r\n");
      out.write("		<section>\r\n");
      out.write("			<ul id=\"new_categories\">\r\n");
      out.write("				<li><a href=\"#\">식물 검색</a></li>\r\n");
      out.write("				<li><a href=\"#\">커뮤니티</a></li>\r\n");
      out.write("				<li><a href=\"#\">다이어리</a></li>\r\n");
      out.write("				<li><a href=\"#\">전국 식물원</a></li>\r\n");
      out.write("				<li><a href=\"#\">스토어</a></li>\r\n");
      out.write("				<li><a href=\"#\">공지/이벤트</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</section>\r\n");
      out.write("		<!-- 로그인 영역 -->\r\n");
      out.write("		<div class=\"login-section\" method=\"post\">\r\n");
      out.write("			<hr solid color=\"#ddd\" />\r\n");
      out.write("			<span id=\"logintext\"><h4>로그인</h4></span>\r\n");
      out.write("			<form action=\"/malant/login\" method=\"post\">\r\n");
      out.write("			<!-- <form action=\"/malant/login\" method=\"post\" onsubmit=\"return validate();\"> -->\r\n");
      out.write("				<input type=\"text\" name=\"loginid\" id=\"loginid\" placeholder=\"아이디\" required>\r\n");
      out.write("				<input type=\"password\" name=\"loginpwd\" id=\"loginpwd\" placeholder=\"비밀번호\" required><br>\r\n");
      out.write("				<input type=\"submit\" class=\"login-button\" value=\"로그인\">\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<!-- 회원가입/아이디/비밀번호 찾기 영역 -->\r\n");
      out.write("		<div class=\"account-section\">\r\n");
      out.write("			<a href=\"/malant/views/member/enrollPage.jsp\" class=\"account-link\">회원가입</a><span class=\"login-divide\">|</span>\r\n");
      out.write("			<!-- 아이디/비밀번호 찾기는 새창을 띄워 진행 -->\r\n");
      out.write("			<a href=\"\" class=\"account-link\" onclick=\"window.open('/malant/findAccount.jsp?find=id', '_blank', 'width=900, height=1000');\">아이디찾기</a><span class=\"login-divide\">|</span>\r\n");
      out.write("			<a href=\"\" class=\"account-link\" onclick=\"window.open('/malant/findAccount.jsp?find=pwd', '_blank', 'width=900, height=1000');\">비밀번호재설정</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
=======
      out.write("  <head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/malant/resources/common/css/sidebar.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/malant/resources/common/css/font.css\" />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"sidebar\">\r\n");
      out.write("      <div class=\"sidebar-header\">\r\n");
      out.write("        <span class=\"sidebar-title\"\r\n");
      out.write("          ><a href=\"#\">\r\n");
      out.write("            <img\r\n");
      out.write("              src=\"/malant/resources/common/images/main_tilte.gif\"\r\n");
      out.write("              alt=\"식물 검색\" /></a\r\n");
      out.write("        ></span>\r\n");
      out.write("      </div>\r\n");
      out.write("      <section>\r\n");
      out.write("        <ul id=\"new_categories\">\r\n");
      out.write("          <li><a href=\"\">식물 검색</a></li>\r\n");
      out.write("          <li><a href=\"/malant/views/board/boardMainList.jsp\">커뮤니티</a></li>\r\n");
      out.write("          <li><a href=\"\">다이어리</a></li>\r\n");
      out.write("          <li><a href=\"\">전국 식물원</a></li>\r\n");
      out.write("          <li><a href=\"\">스토어</a></li>\r\n");
      out.write("          <li><a href=\"/malant/views/notice/noticeMainList.jsp\">공지/이벤트</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </section>\r\n");
      out.write("      <!-- 로그인 영역 -->\r\n");
      out.write("      <div class=\"login-section\">\r\n");
      out.write("        <hr solid color=\"#ddd\" />\r\n");
      out.write("        <span id=\"logintext\"><h4>로그인</h4></span>\r\n");
      out.write("        <input type=\"text\" placeholder=\"아이디\" />\r\n");
      out.write("        <input type=\"password\" placeholder=\"비밀번호\" /><br />\r\n");
      out.write("        <button class=\"login-button\">로그인</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- 회원가입/아이디/비밀번호 찾기 영역 -->\r\n");
      out.write("      <div class=\"account-section\">\r\n");
      out.write("        <a href=\"#\" class=\"account-link\">회원가입</a><span class=\"login-divide\">|</span\r\n");
      out.write("        ><br />\r\n");
      out.write("        <a href=\"#\" class=\"account-link\">아이디찾기</a\r\n");
      out.write("        ><span class=\"login-divide\">|</span><br />\r\n");
      out.write("        <a href=\"#\" class=\"account-link\">비밀번호찾기</a><br />\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
>>>>>>> a6fb4bf6842c925013e85b1e3227c3ed0fb08bba
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <!-- 메인 검색 페이지 -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- 검색 버튼 -->\r\n");
      out.write("	<form action=\"\">\r\n");
      out.write("		<input type=\"search\" name=\"keyword\"  placeholder=\"검색어를 입력하세요.\">\r\n");
      out.write("		<input type=\"submit\" id=\"searchbtn\" value=\"검색\">\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 커뮤니티 인기글 목록 배너 -->\r\n");
      out.write("	<div style=\"width:800px; height:300px; border:1px solid red;\">\r\n");
      out.write("		커뮤니티 인기글이 보여질 영역입니다.\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	");

		Connection conn = new JDBCTemplate().getConnection();
		String result = "ok jdbc";
		if(conn == null) result="error db";
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print( result );
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
