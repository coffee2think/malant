/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-29 03:27:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enrollSeller_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	.input-container {\n");
      out.write("		width: 500px;\n");
      out.write("		height: 630px;\n");
      out.write("		border: 1px solid red;\n");
      out.write("		margin: 0 auto;\n");
      out.write("		display: flex;\n");
      out.write("		justify-content: center;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.inputform {\n");
      out.write("		width: 450px;\n");
      out.write("		height: 30px;\n");
      out.write("		margin: 5px auto;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.inputform-phone {\n");
      out.write("		width: 375px;\n");
      out.write("		height: 30px;\n");
      out.write("		margin: 5px auto;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.checkbox-container {\n");
      out.write("		width: 400px;\n");
      out.write("		height: 70px;\n");
      out.write("		margin: 0 auto;\n");
      out.write("		border: 1px solid red;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.submit-btn_show {\n");
      out.write("		width: 450px;\n");
      out.write("		height: 40px;\n");
      out.write("		margin: auto;\n");
      out.write("		border: 1px solid red;\n");
      out.write("		margin-top: 10px;\n");
      out.write("		margin-bottom: 10px;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.submit-btn_hide {\n");
      out.write("		width: 450px;\n");
      out.write("		height: 40px;\n");
      out.write("		margin: auto;\n");
      out.write("		display: none;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.form-title {\n");
      out.write("		border: 1px solid red;\n");
      out.write("		width: 450px;\n");
      out.write("		height: 40px;\n");
      out.write("		text-align: center;\n");
      out.write("		margin: auto;\n");
      out.write("		margin-top: 15px;\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	.cert-request-btn {\n");
      out.write("		display: inline;\n");
      out.write("		border: 1px solid red;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"/malant/resources/common/js/jquery-3.7.0.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("	function clickSubmitBtn() {\n");
      out.write("		$('.submit-btn_hide').click();\n");
      out.write("	}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	\n");
      out.write("	<div class=\"input-container\">\n");
      out.write("		\n");
      out.write("		<form action=\"/malant/senroll\" method=\"post\">\n");
      out.write("			<input type=\"hidden\" name=\"signtype\" value=\"seller\">\n");
      out.write("			<div class=\"form-title\">판매회원 가입</div><br>\n");
      out.write("			<div class=\"input-name\">\n");
      out.write("				<input type=\"text\" class=\"inputform\" name=\"businessno\" size=\"20\" placeholder=\"사업자번호\"><br>\n");
      out.write("				<div class=\"input-guide-name\"></div>\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<!-- 사업자번호 확인 API 추가 요망 -->\n");
      out.write("			<div><input type=\"button\" value=\"사업자번호 인증 요청\"></div>\n");
      out.write("			<div class=\"input-name\">\n");
      out.write("				<input type=\"text\" class=\"inputform\" name=\"storename\" size=\"20\" placeholder=\"상호명\"><br>\n");
      out.write("				<div class=\"input-guide-name\"></div>\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<!-- 주소검색 API 추가 요망 -->\n");
      out.write("			<div class=\"input-name\">\n");
      out.write("				<input type=\"text\" class=\"inputform\" name=\"address\" size=\"20\" placeholder=\"사업자 주소\"><br>\n");
      out.write("				<div class=\"input-guide-address\"></div>\n");
      out.write("			</div>\n");
      out.write("			\n");
      out.write("			<div class=\"input-id\">\n");
      out.write("				<input type=\"text\" class=\"inputform\" name=\"userid\" size=\"20\" placeholder=\"아이디\"><br>\n");
      out.write("				<div class=\"input-guide-id\"></div>\n");
      out.write("			</div>\n");
      out.write("			<div><input type=\"button\" value=\"아이디 중복 검사\"></div>\n");
      out.write("			<div class=\"input-pwd\">\n");
      out.write("				<input type=\"password\" class=\"inputform\" name=\"userpwd\" placeholder=\"비밀번호(영문+숫자+특수문자)\"><br>\n");
      out.write("				<div class=\"input-guide-pwd\"></div>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"input-pwd2\">\n");
      out.write("				<input type=\"password\" class=\"inputform\" name=\"userpwd2\" placeholder=\"비밀번호 확인\"><br>\n");
      out.write("				<div class=\"input-guide-pwd2\"></div>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"input-email\">\n");
      out.write("				<input type=\"email\" class=\"inputform\" name=\"email\" placeholder=\"이메일\"><br>\n");
      out.write("				<div class=\"input-guide-email\"></div>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"input-contact\">\n");
      out.write("				<input type=\"tel\" class=\"inputform\" name=\"contact\" placeholder=\"휴대폰 번호\"><br>\n");
      out.write("				<div class=\"input-guide-contact\"></div>\n");
      out.write("			</div>\n");
      out.write("			<hr>\n");
      out.write("			<div style=\"position: relative; left: 25px;\"><input type=\"checkbox\">약관 모두 동의 체크박스</div>\n");
      out.write("			<div class=\"checkbox-container\">\n");
      out.write("				<!-- 필수 이용약관에 모두 동의해야 가입 진행되도록 유효성 검사 -->\n");
      out.write("				<div><input type=\"checkbox\" name=\"terms_sell\">판매 이용약관</div>\n");
      out.write("				<div><input type=\"checkbox\" name=\"terms_financial_transaction\">전자금융거래이용약관</div>\n");
      out.write("				<div><input type=\"checkbox\" name=\"agree_personal_info\">판매자 개인정보 수집 및 이용 동의</div>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"submit-btn_show\" onclick=\"clickSubmitBtn();\">동의하고 가입하기</div>\n");
      out.write("			<input type=\"submit\" class=\"submit-btn_hide\" value=\"동의하고 가입하기\">\n");
      out.write("		</form>\n");
      out.write("	</div>\n");
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