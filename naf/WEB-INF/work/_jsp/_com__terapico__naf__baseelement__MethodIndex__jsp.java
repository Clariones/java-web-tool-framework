/*
 * JSP generated by Resin-3.1.12 (built Mon, 29 Aug 2011 03:22:08 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _com__terapico__naf__baseelement__MethodIndex__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_loop_0 == null)
        _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
      java.lang.Object _jsp_items_1 = _caucho_expr_0.evalObject(_jsp_env);
      java.util.Iterator _jsp_iter_1 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_1);
      _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
      Object _jsp_oldVar_1 = pageContext.getAttribute("method");
      while (_jsp_iter_1.hasNext()) {
        Object _jsp_i_1 = _jsp_iter_1.next();
        pageContext.setAttribute("method", _jsp_i_1);
        _jsp_loop_0.setCurrent(_jsp_i_1, _jsp_iter_1.hasNext());
        out.write(_jsp_string1, 0, _jsp_string1.length);
        _caucho_expr_1.print(out, _jsp_env, false);
        out.write(_jsp_string2, 0, _jsp_string2.length);
        _caucho_expr_2.print(out, _jsp_env, false);
        out.write(_jsp_string3, 0, _jsp_string3.length);
      }
      pageContext.pageSetOrRemove("method", _jsp_oldVar_1);
      out.write(_jsp_string4, 0, _jsp_string4.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 7170261747151080670L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.items}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${method.name}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${method.friendName}");
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("com.terapico.naf.baseelement.MethodIndex.jsp"), 9164153687248045933L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;

  private final static char []_jsp_string4;
  private final static char []_jsp_string1;
  private final static char []_jsp_string2;
  private final static char []_jsp_string3;
  private final static char []_jsp_string0;
  static {
    _jsp_string4 = "\r\n	</div>\r\n	<div class=\"content\" id=\"content\">Home Info</div>\r\n</body>\r\n</html>\r\n".toCharArray();
    _jsp_string1 = "  <a href=\"#".toCharArray();
    _jsp_string2 = "\" class=\"action\">".toCharArray();
    _jsp_string3 = "</a><br/>".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n<title>Spring Bean Manage Console</title>\r\n<script src=\"../scripts/jquery-1.9.1.js\" type=\"text/javascript\"></script>\r\n<script src=\"../scripts/common.js\" type=\"text/javascript\"></script>\r\n<style>\r\n.toolbar {\r\n	width: 100%; height: 40px; 	float:left; 	\r\n	font-size: 20px; text-align: left; 	padding-left: 10px;\r\n	padding-top: 10px; background: #111111; 	\r\n	overflow:auto; 	border: 1px solid black;\r\n	color: white; letter-spacing:2px\r\n}\r\n.menu {\r\n	width: 20%; 	 	\r\n	float:left; 	\r\n	font-size: 20px; text-align: left; 	padding-left: 30px;\r\n	padding-top: 30px; 	background: #eeeeee; 	overflow:auto;\r\n	margin: 0; height: 100%\r\n}\r\n.content {\r\n	width: 70%; 	height: 630px; 	text-align: center; 	\r\n	#border: 1px solid grey; \r\n	#padding-top: 800px;\r\n	float:right; 	background: #ffffff;\r\n	padding-top: 30px; \r\n}\r\n\r\nhtml,body{\r\n	margin: 0; padding: 0; height: 100%; overflow:hidden;\r\n}\r\n\r\n</style>\r\n\r\n<script>\r\n\r\n\r\n	$(function() {\r\n		var cache = {};\r\n\r\n		$(\".action\").click(function() {\r\n			\r\n					//alert( );\r\n					//$(\"#content\").text($(this).attr(\"href\"));\r\n					//$(\"#content\").text(event.target+\"/\"+$(this).attr(\"href\"));\r\n					var reqURI =  $(this).attr(\"href\").substring(1) + \"/\";\r\n					//$(\"#content\").text(reqURI);\r\n					fillResult(reqURI,\"#content\");\r\n		});\r\n\r\n	});\r\n\r\n	$(document).ready(function() {\r\n		//alert($(location).attr('href'));\r\n		var currentURL=$(location).attr('href');\r\n		var index=currentURL.indexOf(\"#\");\r\n		if(index<0){\r\n			return;\r\n		}		\r\n		var methodName=currentURL.substring(index+1);\r\n		reqURI =  encodeURIComponent(methodName) + \"/\";		\r\n		fillResult(reqURI,\"#content\");\r\n		\r\n	});\r\n</script>\r\n</head>\r\n\r\n<body>\r\n	<div class=\"toolbar\" >Spring Beans</div>\r\n	<div class=\"menu\" >\r\n\r\n          ".toCharArray();
  }
}
