<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Purchase Product</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5" style="max-width: 600px;">
            <div class="card">
                <div class="card-header text-dark text-center">
                    <h3>Purchase Product</h3>
                </div>
                <div class="card-body">
                    <!-- Form to submit product ID and quantity -->
                    <form action="" method="POST" class="p-4">
                        <div class="form-group">
                            <label for="pid">Product ID:</label>
                            <input type="number" class="form-control" id="pid" name="pid" placeholder="Enter Product ID" required>
                        </div>
                        <div class="form-group">
                            <label for="qun">Quantity:</label>
                            <input type="number" class="form-control" id="qun" name="qun" placeholder="Enter Quantity" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Make Purchase</button>
                    </form>
                    
                    <div class="mt-4">
                        <%
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
                        }
                        %>
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
