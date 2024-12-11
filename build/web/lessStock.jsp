<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Less Stock Products</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5" style="max-width: 600px;">
            <h2 class="text-center mb-4 text-dark">Products with Low Stock</h2>

            <!-- Button form to trigger product details retrieval -->
            <form method="post">
                <div class="text-center mb-3">
                    <button type="submit" name="fetchProducts" class="btn btn-primary">Fetch Products with Low Stock</button>
                </div>
            </form>

            <div class="table-responsive">
                <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>STOCK</th>
                            <th>SOLD QUANTITY</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
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
                    %>  
                        <tr>
                            <td><%= id %></td>
                            <td><%= name %></td>
                            <td><%= stock %></td>
                            <td><%= soldQun %></td>
                        </tr>
                    <%        
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
                    %>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
