package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fdiary_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <!-- Compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("        <title>New Diary</title>\n");
      out.write("        <script>  \n");
      out.write("            $(document).ready(function(){\n");
      out.write("            $('.modal').modal();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <link class=\"jsbin\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <script class=\"jsbin\" src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        function readURL(input) {\n");
      out.write("          if (input.files && input.files[0]) {\n");
      out.write("              var reader = new FileReader();\n");
      out.write("\n");
      out.write("              reader.onload = function (e) {\n");
      out.write("                  $('#image')\n");
      out.write("                      .attr('src', e.target.result)\n");
      out.write("                      .width(150)\n");
      out.write("                      .height(200);\n");
      out.write("              };\n");
      out.write("\n");
      out.write("              reader.readAsDataURL(input.files[0]);\n");
      out.write("          }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("          article, aside, figure, footer, header, hgroup, \n");
      out.write("          menu, nav, section { display: block; }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("            <div class='row'>\n");
      out.write("               <div class=\"col s2\"> \n");
      out.write("                   <a  class=\"waves-effect waves-light btn modal-trigger\" href=\"#modal_diary\">Add Diary</a>\n");
      out.write("        \n");
      out.write("               </div>\n");
      out.write("                <div class=\"col s2\"> \n");
      out.write("                   <a  class=\"waves-effect waves-light btn\" href=\"blogtype.do\" >Add Blog</a>\n");
      out.write("               </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("<!-- add diary modal-->\n");
      out.write("        <div id=\"modal_diary\" class=\"modal\">\n");
      out.write("          <div class=\"modal-content\">\n");
      out.write("            <h4>New Diary</h4>\n");
      out.write("      <div class=\"card  center\">\n");
      out.write("        <div class=\"card-content \">\n");
      out.write("          <span class=\"card-title center \">New Diary</span>\n");
      out.write("          <form method=\"post\" action=\"AddTimeline.do\">\n");
      out.write("           \n");
      out.write("           <div class=\"input-field \">\n");
      out.write("          <input id=\"d_name\" name=\"d_name\" type=\"text\" class=\"validate\">\n");
      out.write("          <label for=\"d_name\">diary name</label>\n");
      out.write("        </div>\n");
      out.write("              <div>\n");
      out.write("           <img id=\"image\"/>\n");
      out.write("           Cover Image for diary (optional):\n");
      out.write("           <input type='file' name=\"image_file\" onchange=\"readURL(this);\" />\n");
      out.write("           \n");
      out.write("              </div>\n");
      out.write("        \n");
      out.write("              <input id=\"submit\" type=\"submit\" value=\"Create diary\" class=\"waves-effect waves-light btn\" >\n");
      out.write("        </form>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"modal-footer\">\n");
      out.write("            <a href=\"#!\" class=\"modal-close waves-effect waves-green btn-flat\">Cancel</a>\n");
      out.write("          </div>\n");
      out.write("        </div>        \n");
      out.write("\n");
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
