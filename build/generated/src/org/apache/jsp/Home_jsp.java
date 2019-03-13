package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/navbar.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      out.write("        <title>My Journal App</title>\n");
      out.write("        <link href=\"footer.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!-- Compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("    <link href=\"colors.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <!-- Compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        var x=1;\n");
      out.write("        $('#writingmenu').click(function() {\n");
      out.write("            x=1;\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        $('#aboutmenu').click(function() {\n");
      out.write("            x=2;\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        $('#profilemenu').click(function() {\n");
      out.write("            x=3;\n");
      out.write("            });\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("          <nav>\n");
      out.write("            <div class=\"nav-wrapper bg-green\">\n");
      out.write("              <a href=\"\" class=\"brand-logo\">\n");
      out.write("              <img src=\"images/my_journey_logo.jpg\" alt=\"\" style='height: 80%; width: 11.5%;'/></a>\n");
      out.write("              <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n");
      out.write("                <li><a href=\"./writing.jsp\" id=\"writingmenu\">Writings</a></li>\n");
      out.write("                <li><a href=\"./About.jsp\"  id=\"aboutmenu\">About Us</a></li>\n");
      out.write("                <li><a href=\"./profile.jsp\" id=\"profilemenu\">Profile</a></li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("          </nav>\n");
      out.write("           \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <main>\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <footer>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- Compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("    <link href=\"colors.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <!-- Compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <footer class=\"page-footer bg-green \">\n");
      out.write("          <div class=\"container \">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col l6 s12\">\n");
      out.write("                <h5 class=\"white-text\">Developer Info:</h5>\n");
      out.write("                <p class=\"grey-text text-lighten-4\">This web application is developed and maintained by Akash Palghadmal.</p>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col l4 offset-l2 s12\">\n");
      out.write("                <h5 class=\"white-text\">Know more</h5>\n");
      out.write("                <ul>\n");
      out.write("                  <li><a class=\"grey-text text-lighten-3\" href=\"#!\">About</a></li>\n");
      out.write("                  <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Terms and conditions</a></li>\n");
      out.write("                  <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Privacy policy</a></li>\n");
      out.write("                  <li><a class=\"grey-text text-lighten-3\" href=\"#!\">Help</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"footer-copyright\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("            © 2019 copyright Property of Akash Palghadmal\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </footer>\n");
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
