package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class form_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Inserting Product</title>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-center mt-5\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h3 class=\"card-title text-center mb-4\">Insert New Product</h3>\n");
      out.write("                            <form action=\"\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"pname\">Enter Product Name:</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"pname\" name=\"pname\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"stock\">Enter Stock of Product:</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" id=\"stock\" name=\"stock\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"cprice\">Enter Cost Price:</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" id=\"cprice\" name=\"cprice\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"sprice\">Enter Selling Price:</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" id=\"sprice\" name=\"sprice\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"qun\">Enter Quantity Sold:</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control\" id=\"qun\" name=\"qun\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary btn-block\">Insert New Product</button>\n");
      out.write("                            </form>\n");
      out.write("                            ");

                                String name = request.getParameter("pname");
                                String stockParam = request.getParameter("stock");
                                String costPriceParam = request.getParameter("cprice");
                                String sellingPriceParam = request.getParameter("sprice");
                                String quantitySoldParam = request.getParameter("qun");

                                if (name != null && stockParam != null && costPriceParam != null && sellingPriceParam != null && quantitySoldParam != null) {
                                    int stock = Integer.parseInt(stockParam);
                                    int costPrice = Integer.parseInt(costPriceParam);
                                    int sellingPrice = Integer.parseInt(sellingPriceParam);
                                    int quantitySold = Integer.parseInt(quantitySoldParam);

                                    String url = "jdbc:mysql://localhost:3306/adbms";
                                    String username = "root";
                                    String password = "Mysql@2004";

                                    Connection con = null;
                                    CallableStatement stm = null;

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        con = DriverManager.getConnection(url, username, password);

                                        String sql = "{CALL insert_product(?, ?, ?, ?, ?)}";
                                        stm = con.prepareCall(sql);
                                        stm.setString(1, name);     // Product name
                                        stm.setInt(2, stock);       // Stock
                                        stm.setInt(3, costPrice);   // Cost price
                                        stm.setInt(4, sellingPrice);// Selling price
                                        stm.setInt(5, quantitySold);// Quantity sold

                                        int rowsInserted = stm.executeUpdate();
                                        if (rowsInserted > 0) {
                                            out.println("<div class='alert alert-success mt-3'>Product inserted successfully!</div>");
                                        } else {
                                            out.println("<div class='alert alert-danger mt-3'>Product insertion failed!</div>");
                                        }
                                    } catch (Exception e) {
                                        out.println("<div class='alert alert-danger mt-3'>Error: " + e.getMessage() + "</div>");
                                        e.printStackTrace();
                                    } finally {
                                        try {
                                            if (stm != null) stm.close();
                                            if (con != null) con.close();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
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
