/*
 * JSP generated by Resin-3.1.12 (built Mon, 29 Aug 2011 03:22:08 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _weather__WeatherResponse__jsp extends com.caucho.jsp.JavaPage
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
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.defaultSetOrRemove("today", _caucho_expr_0.evalObject(_jsp_env));
      out.write(_jsp_string1, 0, _jsp_string1.length);
      _caucho_expr_1.print(out, _jsp_env, false);
      out.write(_jsp_string2, 0, _jsp_string2.length);
      _caucho_expr_2.print(out, _jsp_env, false);
      out.write(_jsp_string3, 0, _jsp_string3.length);
      _caucho_expr_3.print(out, _jsp_env, false);
      out.write(_jsp_string4, 0, _jsp_string4.length);
      _caucho_expr_4.print(out, _jsp_env, false);
      out.write(_jsp_string5, 0, _jsp_string5.length);
      _caucho_expr_5.print(out, _jsp_env, false);
      out.write(_jsp_string6, 0, _jsp_string6.length);
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
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.retData.today}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${today.type}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${today.aqi}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${today.curTemp}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${today.lowtemp}");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${today.hightemp}");
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("weather.WeatherResponse.jsp"), -3803171502969170691L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;

  private final static char []_jsp_string4;
  private final static char []_jsp_string0;
  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  private final static char []_jsp_string5;
  private final static char []_jsp_string6;
  static {
    _jsp_string4 = " \u6e29\u5ea6\u8303\u56f4:  ".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<style>\r\n.message{\r\n	font-size:30px;\r\n}\r\n\r\n</style>\r\n".toCharArray();
    _jsp_string3 = "  \u5f53\u524d\u6e29\u5ea6\uff1a ".toCharArray();
    _jsp_string2 = " \u7a7a\u6c14\u8d28\u91cf: ".toCharArray();
    _jsp_string1 = "\r\n<div class=\"message\">\r\n     ".toCharArray();
    _jsp_string5 = " ~ ".toCharArray();
    _jsp_string6 = "\r\n</div>\r\n".toCharArray();
  }
}
