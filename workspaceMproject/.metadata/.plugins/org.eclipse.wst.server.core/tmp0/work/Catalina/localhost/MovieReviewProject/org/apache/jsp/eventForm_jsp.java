/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2018-07-26 06:20:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mrp.web.vo.Board;
import java.util.ArrayList;

public final class eventForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1532583371695L));
    _jspx_dependants.put("jar:file:/C:/DEVELOP/workspaceMproject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MovieReviewProject/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("mrp.web.vo.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("#eventBoardArea {\r\n");
      out.write("\twidth: 620px;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventList {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tmargin-top: 2%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tborder: 1px solid #BCBCBC;\r\n");
      out.write("\twidth: 600px;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin-left: -15%;\r\n");
      out.write("\tmargin-bottom: 2%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventImage {\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tpadding: 20px 35px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventRegist {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("\tborder: 1px solid #655ce4;\r\n");
      out.write("\tbackground-color: #655ce4;\r\n");
      out.write("\tfont-size: small;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tpadding: 0.4%;\r\n");
      out.write("\theight: 5%;\r\n");
      out.write("\twidth: 11%;\r\n");
      out.write("\tmargin-top: 5%;\r\n");
      out.write("\tmargin-left: 2%;\r\n");
      out.write("\tborder-radius: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventRegist:hover {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice_board {\r\n");
      out.write("\tborder-collapse: separate;\r\n");
      out.write("\tborder-spacing: 1px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tline-height: 1.5;\r\n");
      out.write("\tborder-top: 1px solid #ccc;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmargin-left: 1%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".th1 {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: small;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tborder-bottom: 1px solid #ccc;\r\n");
      out.write("\tbackground: #efefef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".td1 {\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tborder-bottom: 1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sideTest {\r\n");
      out.write("\twidth: 20%;\r\n");
      out.write("\tmargin-left: 66%;\r\n");
      out.write("\tmargin-top: 2%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("b {\r\n");
      out.write("\tmargin-top: 15%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventResist1:link {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #9097C5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventResist1:visited {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #9097C5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".eventResist1:active {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #9097C5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice1 {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\twidth: 220px;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice1:link {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #646464;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice1:visited {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #646464;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice1:active {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #646464;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".notice1:hover {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #3F3A89;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a1 {\r\n");
      out.write("\tbackground-color: #DFDFDF;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ellipsis {\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\twidth: 220px;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("\twidth: 220px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".regist1 {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tmargin-top: 15%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".date {\r\n");
      out.write("\tcolor: #9B9B9E;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		ArrayList<Board> eventBoardList = (ArrayList<Board>) request.getAttribute("eventBoardList");
		ArrayList<Board> boardNoticeList = (ArrayList<Board>) request.getAttribute("boardNoticeList");
	
      out.write("\r\n");
      out.write("\t<h1 class=\"eventList\">이벤트 목록</h1>\r\n");
      out.write("\t<nav class=\"sideTest\">\r\n");
      out.write("\t\t<div class=\"eventRegist\">\r\n");
      out.write("\t\t\t<a href=\"eventWriteForm.bo?b_division=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b_division}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\tclass=\"eventRegist1\"><b class=\"regist1\">이벤트 글 등록</b></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<section id=\"eventBoardArea\">\r\n");
      out.write("\t\t<table class=\"notice_board\">\r\n");
      out.write("\t\t\t");

				if (boardNoticeList != null) {
					for (int i = 0; i < boardNoticeList.size(); i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th class=\"th1\">공지사항</th>\r\n");
      out.write("\t\t\t\t<td class=\"td1\"><b><a\r\n");
      out.write("\t\t\t\t\t\thref=\"boardContent.bo?b_code=");
      out.print(boardNoticeList.get(i).getB_code());
      out.write("&b_division=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b_division}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"notice1\"><b>");
      out.print(boardNoticeList.get(i).getB_name());
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td class=\"td1\">");
      out.print(boardNoticeList.get(i).getB_author());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"td1\">");
      out.print(boardNoticeList.get(i).getReadcount());
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");

			if (eventBoardList != null && eventBoardList.size() > 0) {
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < eventBoardList.size(); i++) {
							System.out.println(eventBoardList.get(i).getB_code());
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td><a\r\n");
      out.write("\t\t\t\t\thref=\"boardContent.bo?b_code=");
      out.print(eventBoardList.get(i).getB_code());
      out.write("&b_division=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b_division}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"images/");
      out.print(eventBoardList.get(i).getB_image());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"eventImage\">\r\n");
      out.write("\t\t\t\t</a><br>\r\n");
      out.write("\t\t\t\t\t<p class=\"ellipsis\">");
      out.print(eventBoardList.get(i).getB_name());
      out.write("\r\n");
      out.write("\t\t\t\t\t</p> <br>\r\n");
      out.write("\t\t\t\t\t<p class=\"date\">\r\n");
      out.write("\t\t\t\t\t\t기간 :\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(eventBoardList.get(i).getB_time());
      out.write("</p></td>\r\n");
      out.write("\t\t\t\t");

					if ((i + 1) % 3 == 0) {
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					}
						}
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</section>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /eventForm.jsp(175,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${u_division == 0}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<div class=\"eventRegist\">\r\n");
          out.write("\t\t\t\t<a href=\"writeForm.bo?b_division=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b_division + 3}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("\t\t\t\t\tclass=\"eventRegist1\"><b class=\"regist1\">공지사항 글쓰기</b></a>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}