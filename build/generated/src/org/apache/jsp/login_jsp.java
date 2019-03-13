package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("    <link href=\"colors.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <!-- Compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"black\">\n");
      out.write("        \n");
      out.write("  <div class=\"row \">\n");
      out.write("      <div class=\"col s12 m3\"></div>\n");
      out.write("    <div class=\"col s12 m6\">\n");
      out.write("      <div class=\"card grey darken-4  center\">\n");
      out.write("        <div class=\"card-content \">\n");
      out.write("            <span class=\"card-title center white-text\">\n");
      out.write("                <img src=\"images/my_journey_logo.jpg\" alt=\"\" style=\"width: 20%\"/></span>\n");
      out.write("          <span class=\"card-title center white-text\">Login</span>\n");
      out.write("          <form method=\"post\" action=\"login.do\">\n");
      out.write("           \n");
      out.write("           <div class=\"input-field \">\n");
      out.write("          <input id=\"email\" name=\"email\" type=\"text\" class=\"validate white-text\">\n");
      out.write("          <label for=\"email\">email</label>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"input-field\">\n");
      out.write("          <input id=\"password\" name=\"password\" type=\"password\" class=\"validate white-text\">\n");
      out.write("          <label for=\"password\">Password</label>\n");
      out.write("        </div>\n");
      out.write("              <input id=\"submit\" type=\"submit\" value=\"Login\" class=\"waves-effect waves-light btn\" >\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("          \n");
      out.write("\n");
      out.write("        <div class=\"card-action\">\n");
      out.write("          <p class=\"white-text\">Don't have an account?<p>\n");
      out.write("          <a href=\"./registration.jsp\" class=\"waves-effect waves-light btn\">Sign up</a>\n");
      out.write("        </div>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
