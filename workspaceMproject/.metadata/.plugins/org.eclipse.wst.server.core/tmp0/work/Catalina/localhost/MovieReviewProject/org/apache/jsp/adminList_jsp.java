/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2018-07-26 06:11:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import mrp.web.vo.User;

public final class adminList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("mrp.web.vo.User");
    _jspx_imports_classes.add("java.util.ArrayList");
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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>회원 목록</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   function modifyPage(name) {\r\n");
      out.write("      window.open(\"modifyUserForm.ad?u_name=\" + name, \"\",\r\n");
      out.write("            \"width=430,height=500,location=no,status=no,scrollbars=yes\");\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("#mainContent{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin-left : 15%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("    line-height: 1.5;\r\n");
      out.write("    border-left: 1px solid #ccc;\r\n");
      out.write("    margin: 20px 10px;\r\n");
      out.write("    width : 70%;\r\n");
      out.write("    height : 100%;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-size : small;\r\n");
      out.write("    vertical-align: center;\r\n");
      out.write("}\r\n");
      out.write("#title1{\r\n");
      out.write("\tfont-size: large;\r\n");
      out.write("\tbackground-color : #dcdcd1;\r\n");
      out.write("\tborder-bottom-color: #c00;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("table th {\r\n");
      out.write("    width: 150px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    vertical-align: top;\r\n");
      out.write("    border-right: 1px solid #ccc;\r\n");
      out.write("    border-bottom: 1px solid #ccc;\r\n");
      out.write("    background: #ececec;\r\n");
      out.write("}\r\n");
      out.write("table td {\r\n");
      out.write("\t\r\n");
      out.write("    width: 350px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    vertical-align: top;\r\n");
      out.write("    border: 1px solid #ccc;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write(".class11{\r\n");
      out.write("\twidth : 10%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("   ");

      ArrayList<User> user = (ArrayList<User>) request.getAttribute("userList");

      if (user != null && user.size() > 0) {
   
      out.write("\r\n");
      out.write("   <!-- get post  -->\r\n");
      out.write("   <table>\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td id= \"title1\"colspan=\"10\"><h1>회원 목록</h1></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("\r\n");
      out.write("         <th scope=\"cols\">아이디</th>\r\n");
      out.write("         <th class=\"class11\" scope=\"cols\">닉네임</th>\r\n");
      out.write("         <th scope=\"cols\">이메일</th>\r\n");
      out.write("         <th scope=\"cols\">성별</th>\r\n");
      out.write("         <th scope=\"cols\">생년월일</th>\r\n");
      out.write("         <th scope=\"cols\">비밀번호</th>\r\n");
      out.write("         <th class=\"class11\" scope=\"cols\">회원등급</th>\r\n");
      out.write("         <th scope=\"cols\">포인트</th>\r\n");
      out.write("         <th></th>\r\n");
      out.write("         <th></th>\r\n");
      out.write("      </tr>\r\n");
      out.write("      ");

         for (int i = 0; i < user.size(); i++) {
      
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_id());
      out.write("</td>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_name());
      out.write("</td>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_email());
      out.write("</td>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_gender());
      out.write("</td>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_day());
      out.write("</td>\r\n");
      out.write("         <td scope=\"row\">");
      out.print(user.get(i).getU_passwd());
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("         <td>\r\n");
      out.write("            ");

               if (user.get(i).getU_division() == 1) {
            
      out.write('회');
      out.write('원');

               } else {
            
      out.write('관');
      out.write('리');
      out.write('자');

               }
            
      out.write("\r\n");
      out.write("         </td>\r\n");
      out.write("\r\n");
      out.write("         <td>");
      out.print(user.get(i).getU_point());
      out.write("</td>\r\n");
      out.write("         <td><input type=\"button\"\r\n");
      out.write("            onclick=\"location.href = 'deleteUser.ad?u_id=");
      out.print(user.get(i).getU_id());
      out.write("'; return false\"\r\n");
      out.write("            value=\"삭제\"></td>\r\n");
      out.write("         <td>\r\n");
      out.write("            ");

               if (user.get(i).getU_division() == 1) {
            
      out.write("<input type=\"button\"\r\n");
      out.write("            onClick=\"modifyPage('");
      out.print(user.get(i).getU_name());
      out.write("')\" value='수정하기'>\r\n");
      out.write("            ");

               } else {
            
      out.write(" <b> - </b> ");

    }
 
      out.write("\r\n");
      out.write("         </td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </tr>\r\n");
      out.write("      ");

         }
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("   </table>\r\n");
      out.write("\r\n");
      out.write("   ");

      }
   
      out.write("\r\n");
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