package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class total_005frev_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Calculate Product Revenue</title>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light\">\n");
      out.write("        <div class=\"container mt-5\" style=\"max-width: 600px;\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header text-dark text-center\">\n");
      out.write("                    <h3>Calculate Product Revenue</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <!-- Form to submit product ID -->\n");
      out.write("                    <form action=\"\" method=\"POST\" class=\"p-4\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"pid\">Product ID:</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"pid\" name=\"pid\" placeholder=\"Enter Product ID\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block\">Calculate Revenue</button>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <div class=\"mt-4\">\n");
      out.write("                        ");

                        String url = "jdbc:mysql://localhost:3306/adbms";
                        String username = "root";
                        String password = "Mysql@2004";

                        Connection con = null;
                        CallableStatement stmt = null;
                        ResultSet rs = null;

                        String productIdStr = request.getParameter("pid");

                        if (productIdStr != null && !productIdStr.trim().isEmpty()) {

                            int productId = Integer.parseInt(productIdStr);

                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");

                                con = DriverManager.getConnection(url, username, password);

                                // Call the calculate_revenue function
                                stmt = con.prepareCall("{? = CALL calculate_revenue(?)}");
                                stmt.registerOutParameter(1, Types.DECIMAL);
                                stmt.setInt(2, productId);

                                stmt.execute();

                                // Get the revenue result
                                double revenue = stmt.getDouble(1);

                                out.println("<div class='alert alert-success'>The total revenue for Product ID " + productId + " is: " + revenue + ".</div>");

                            } catch (SQLException e) {
                                if (e.getMessage().contains("No such product found")) {
                                    out.println("<div class='alert alert-danger'>No such product found with ID " + productId + ".</div>");
                                } else {
                                    out.println("<div class='alert alert-danger'>Error occurred: " + e.getMessage() + "</div>");
                                }
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                out.println("<div class='alert alert-danger'>Driver not found: " + e.getMessage() + "</div>");
                                e.printStackTrace();
                            } finally {
                                if (rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
                                if (stmt != null) try { stmt.close(); } catch(SQLException e) { e.printStackTrace(); }
                                if (con != null) try { con.close(); } catch(SQLException e) { e.printStackTrace(); }
                            }
                        }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
