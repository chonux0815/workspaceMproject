/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2018-07-26 00:26:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MovieInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Sunflower:300\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write(".head {\r\n");
      out.write("    display:table-cell;\r\n");
      out.write("    vertical-align:middle;\r\n");
      out.write("    text-align:center;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tfont-size: x-large;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tbackground-color: #8B93B2;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\twidth: 320px;\r\n");
      out.write("\theight:32px;\r\n");
      out.write("\tborder-radius: 10em;\r\n");
      out.write("\tfont-family: 'Sunflower', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".review {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\twidth: 370px;\r\n");
      out.write("\theight: 278px;\r\n");
      out.write("\tpadding-top: 220px;\r\n");
      out.write("\tpadding-left: 6px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".info {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div > a{\r\n");
      out.write("padding: 12px;\r\n");
      out.write("}\r\n");
      out.write(".imagess{\r\n");
      out.write("width: 80px;\r\n");
      out.write("height: 80px;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"review\">\r\n");
      out.write("\t\t<div class=\"head\">추천 리뷰 영상</div>\r\n");
      out.write("\t\t<div class=\"info\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t\t<a href=\"https://www.youtube.com/user/rladndgussla\" target=\"_blank\"><img class=\"imagess\"\r\n");
      out.write("\t\t\t\tsrc=\"images/gomong.jpg\"></a> \r\n");
      out.write("\t\t\t<a\thref=\"https://www.youtube.com/channel/UCJfthTE-ACoZJPVgwyw_hsw\"\r\n");
      out.write("\t\t\t\ttarget=\"_blank\"><img class=\"imagess\" src=\"images/filbba.jpg\"></a>\r\n");
      out.write("\t\t    <a\thref=\"https://www.youtube.com/user/red12734\" target=\"_blank\"><img class=\"imagess\"\r\n");
      out.write("\t\t\t\tsrc=\"images/red.jpg\"></a><br><br>\r\n");
      out.write("\t\t    <a\thref=\"https://www.youtube.com/channel/UCrBpV_pG2kyMMEHCMTNzjAQ\"\r\n");
      out.write("\t\t\t\ttarget=\"_blank\"><img class=\"imagess\" src=\"images/review.jpg\"></a>\r\n");
      out.write("\t\t    <a\thref=https://www.youtube.com/channel/UCpCiIDf9UrfRqte55FHWlYQ\r\n");
      out.write("\t\t\t\ttarget=\"_blank\"><img class=\"imagess\" src=\"images/bbi.jpg\"></a>\r\n");
      out.write("\t\t    <a\thref=https://www.youtube.com/channel/UCxlv4aOnrRTXMRSL8bVJqEw\r\n");
      out.write("\t\t\t\ttarget=\"_blank\"><img class=\"imagess\" src=\"images/dream.jpg\"></a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
