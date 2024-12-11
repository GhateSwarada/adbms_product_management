<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Delete Product</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container">
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title text-center mb-4">Delete Product</h3>
                            <form action="" method="post">
                                <div class="form-group">
                                    <label for="proId">Enter Product ID:</label>
                                    <input type="number" class="form-control" id="proId" name="proId" required>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block">Delete Product</button>
                            </form>
                            <%
                                String productIdStr = request.getParameter("proId");

                                if (productIdStr != null && !productIdStr.trim().isEmpty()) {
                                    int productId = Integer.parseInt(productIdStr);

                                    String url = "jdbc:mysql://localhost:3306/adbms";
                                    String username = "root";
                                    String password = "Mysql@2004";

                                    Connection con = null;
                                    CallableStatement stmt = null;

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        con = DriverManager.getConnection(url, username, password);

                                        // Call the procedure `delete_product_if_low_profit`
                                        stmt = con.prepareCall("{CALL delete_product_if_low_profit(?)}");
                                        stmt.setInt(1, productId);

                                        // Execute the procedure
                                        stmt.execute();

                                        // If successful, show message
                                        out.println("<div class='alert alert-success mt-3'>Product deleted successfully.</div>");
                                    } catch (SQLException e) {
                                        out.println("<div class='alert alert-danger mt-3'>Error occurred: " + e.getMessage() + "</div>");
                                        e.printStackTrace();
                                    } catch (ClassNotFoundException e) {
                                        out.println("<div class='alert alert-danger mt-3'>Driver not found: " + e.getMessage() + "</div>");
                                        e.printStackTrace();
                                    } finally {
                                        if (stmt != null) try { stmt.close(); } catch(SQLException e) { e.printStackTrace(); }
                                        if (con != null) try { con.close(); } catch(SQLException e) { e.printStackTrace(); }
                                    }
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
