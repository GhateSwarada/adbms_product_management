<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inserting Product</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container">
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title text-center mb-4">Insert New Product</h3>
                            <form action="" method="post">
                                <div class="form-group">
                                    <label for="pname">Enter Product Name:</label>
                                    <input type="text" class="form-control" id="pname" name="pname" required>
                                </div>
                                <div class="form-group">
                                    <label for="stock">Enter Stock of Product:</label>
                                    <input type="number" class="form-control" id="stock" name="stock" required>
                                </div>
                                <div class="form-group">
                                    <label for="cprice">Enter Cost Price:</label>
                                    <input type="number" class="form-control" id="cprice" name="cprice" required>
                                </div>
                                <div class="form-group">
                                    <label for="sprice">Enter Selling Price:</label>
                                    <input type="number" class="form-control" id="sprice" name="sprice" required>
                                </div>
                                <div class="form-group">
                                    <label for="qun">Enter Quantity Sold:</label>
                                    <input type="number" class="form-control" id="qun" name="qun" required>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block">Insert New Product</button>
                            </form>
                            <%
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
