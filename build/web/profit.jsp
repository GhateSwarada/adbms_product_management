<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Profit Calculation</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5" style="max-width: 600px;">
            <h2 class="text-center mb-4 text-dark">Calculate Product Profit</h2>

            <!-- Form to submit product ID -->
            <form action="" method="POST" class="p-2 bg-white rounded shadow-sm">
                <div class="form-group">
                    <label for="product_id">Enter Product ID:</label>
                    <input type="number" class="form-control" id="product_id" name="product_id" placeholder="Enter Product ID" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Calculate Profit</button>
            </form>

            <div class="mt-4">
                <%
                String url = "jdbc:mysql://localhost:3306/adbms";
                String username = "root";
                String password = "Mysql@2004";
                String productId = request.getParameter("product_id");
                double profit  = 0.0;

                if (productId != null && !productId.trim().isEmpty()) {
                    int pid = Integer.parseInt(productId);
                    Connection con = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection(url, username, password);

                        stmt = con.createStatement();

                        String query = "SELECT calculate_profit(" + pid + ") AS profit";
                        rs = stmt.executeQuery(query);

                        if (rs.next()) {
                            profit = rs.getDouble("profit");
                            out.println("<div class='alert alert-success mt-3'>Profit of Product ID " + productId + " is: " + profit + "</div>");
                        } else {
                            out.println("<div class='alert alert-danger mt-3'>No result found for Product ID " + productId + "</div>");
                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                        out.println("<div class='alert alert-danger mt-3'>Error occurred: " + e.getMessage() + "</div>");
                    } finally {
                        if (rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
                        if (stmt != null) try { stmt.close(); } catch(SQLException e) { e.printStackTrace(); }
                        if (con != null) try { con.close(); } catch(SQLException e) { e.printStackTrace(); }
                    }
                } 
                %>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
