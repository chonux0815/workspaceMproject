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
import java.net.URLEncoder;
import mrp.web.vo.Movie;
import java.util.ArrayList;

public final class weeksMovieSuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.net.URLEncoder");
    _jspx_imports_classes.add("mrp.web.vo.Movie");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Sunflower:300\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write(".head {\r\n");
      out.write("\tdisplay: table-cell;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tfont-size: x-large;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tbackground-color: #8B93B2;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\twidth: 320px;\r\n");
      out.write("\theight: 32px;\r\n");
      out.write("\tborder-radius: 10em;\r\n");
      out.write("\tfont-family: 'Sunflower', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".weeksMovie {\r\n");
      out.write("\tpadding-top: 220px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".movieName {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("\tfont-family: 'Sunflower', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".weeksMovie {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#test {\r\n");
      out.write("\tmargin-top: 3.5%;\r\n");
      out.write("\tmargin-left: 3.5%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction idCheck(i) {\r\n");
      out.write("\t\t//alert(\"\");\r\n");
      out.write("\t\twindow.open(\"proboxoffice.main?i=\"+i, \"\",\r\n");
      out.write("\t\t\t\t\"width=787,height=434\\\r\n");
      out.write("\t\t\t\t,location=no,status=no,scrollbars=yes\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

	ArrayList<Movie> movieList = (ArrayList<Movie>) session.getAttribute("items");
	String showRange = (String) request.getAttribute("showRange");

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"weeksMovie\">\r\n");
      out.write("\t\t");

			if (movieList != null && movieList.size() > 0) {
		
      out.write("\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"4\"><div class=\"head\">금주 영화순위</div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<table id=\"test\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 0; i < 3; i++) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\" onclick=\"idCheck(");
      out.print(i);
      out.write(");\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"images/");
      out.print(movieList.get(i).getMovieNum());
      out.write(".jpg\"></a> <br>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"movieName\">");
      out.print(i + 1);
      out.write("위 :\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(movieList.get(i).getMovieNum());
      out.write("</p></td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 3; i < 6; i++) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\" onclick=\"idCheck(");
      out.print(i);
      out.write(");\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"images/");
      out.print(movieList.get(i).getMovieNum());
      out.write(".jpg\"></a> <br>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"movieName\">");
      out.print(i + 1);
      out.write("위 :\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(movieList.get(i).getMovieNum());
      out.write("</p></td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 6; i < 9; i++) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><a href=\"#\" onclick=\"idCheck(");
      out.print(i);
      out.write(");\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"images/");
      out.print(movieList.get(i).getMovieNum());
      out.write(".jpg\"></a> <br>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"movieName\">");
      out.print(i + 1);
      out.write("위 :\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(movieList.get(i).getMovieNum());
      out.write("</p></td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
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
