package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class lessStock_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Less Stock Products</title>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light\">\n");
      out.write("        <div class=\"container mt-5\" style=\"max-width: 600px;\">\n");
      out.write("            <h2 class=\"text-center mb-4 text-dark\">Products with Low Stock</h2>\n");
      out.write("\n");
      out.write("            <!-- Button form to trigger product details retrieval -->\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <div class=\"text-center mb-3\">\n");
      out.write("                    <button type=\"submit\" name=\"fetchProducts\" class=\"btn btn-primary\">Fetch Products with Low Stock</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <table class=\"table table-bordered table-striped table-hover\">\n");
      out.write("                    <thead class=\"thead-dark\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>NAME</th>\n");
      out.write("                            <th>STOCK</th>\n");
      out.write("                            <th>SOLD QUANTITY</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                    ");

                    // Check if the form was submitted by checking the button's name in the request
                    if (request.getParameter("fetchProducts") != null) {
                        String url = "jdbc:mysql://localhost:3306/adbms";
                        String username = "root";
                        String password = "Mysql@2004";

                        Connection con = null;
                        CallableStatement stm = null;
                        ResultSet rs = null;

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection(url, username, password);

                            stm = con.prepareCall("{CALL get_product_details()}");

                            boolean hasResults = stm.execute();

                            while (hasResults) {
                                rs = stm.getResultSet();

                                while (rs.next()) {
                                    int id = rs.getInt("prod_id");
                                    String name = rs.getString("prod_name");
                                    int stock = rs.getInt("prod_stock");
                                    int soldQun = rs.getInt("prod_quantity_sold");
                    
      out.write("  \n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( id );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( stock );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( soldQun );
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                    ");
        
                                }
                                hasResults = stm.getMoreResults();
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (rs != null) try { rs.close(); } catch(Exception e) { e.printStackTrace(); }
                            if (stm != null) try { stm.close(); } catch(Exception e) { e.printStackTrace(); }
                            if (con != null) try { con.close(); } catch(Exception e) { e.printStackTrace(); }
                        }
                    }
                    
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap JS and dependencies -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
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
