<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Calculate Product Revenue</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5" style="max-width: 600px;">
            <div class="card">
                <div class="card-header text-dark text-center">
                    <h3>Calculate Product Revenue</h3>
                </div>
                <div class="card-body">
                    <!-- Form to submit product ID -->
                    <form action="" method="POST" class="p-4">
                        <div class="form-group">
                            <label for="pid">Product ID:</label>
                            <input type="number" class="form-control" id="pid" name="pid" placeholder="Enter Product ID" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Calculate Revenue</button>
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
