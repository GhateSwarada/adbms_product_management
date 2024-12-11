package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class sale_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Purchase Product</title>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light\">\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header bg-primary text-white text-center\">\n");
      out.write("                    <h3>Purchase Product</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <!-- Form to submit product ID and quantity -->\n");
      out.write("                    <form action=\"\" method=\"POST\" class=\"p-4\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"pid\">Product ID:</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"pid\" name=\"pid\" placeholder=\"Enter Product ID\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"qun\">Quantity:</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"qun\" name=\"qun\" placeholder=\"Enter Quantity\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block\">Make Purchase</button>\n");
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
                        String quantityStr = request.getParameter("qun");

                        if (productIdStr != null && !productIdStr.trim().isEmpty() && 
                            quantityStr != null && !quantityStr.trim().isEmpty()) {

                            int productId = Integer.parseInt(productIdStr);
                            int quantity = Integer.parseInt(quantityStr);

                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");

                                con = DriverManager.getConnection(url, username, password);

                                stmt = con.prepareCall("{CALL make_purchase(?, ?)}");
                                stmt.setInt(1, productId);
                                stmt.setInt(2, quantity);

                                stmt.execute();

                                out.println("<div class='alert alert-success'>Purchase processed successfully for Product ID " + productId + " with Quantity " + quantity + ".</div>");

                            } catch (SQLException e) {
                                out.println("<div class='alert alert-danger'>Error occurred: " + e.getMessage() + "</div>");
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                out.println("<div class='alert alert-danger'>Driver not found: " + e.getMessage() + "</div>");
                                e.printStackTrace();
                            } finally {
                                if (rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
                                if (stmt != null) try { stmt.close(); } catch(SQLException e) { e.printStackTrace(); }
                                if (con != null) try { con.close(); } catch(SQLException e) { e.printStackTrace(); }
                            }
                        } else {
                            out.println("<div class='alert alert-warning'>Please provide both Product ID and Quantity.</div>");
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