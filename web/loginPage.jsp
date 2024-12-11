<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    
                    <%
                        String dbURL = "jdbc:mysql://localhost:3306/adbms";
                        String dbUsername = "root";
                        String dbPassword = "Mysql@2004";
                        Connection conn = null;
                        CallableStatement stmt = null;

                        String username = request.getParameter("username");
                        String password = request.getParameter("password");

                        if (username != null && password != null) {
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                                // Call the login function
                                stmt = conn.prepareCall("{? = CALL validate_login(?, ?)}");
                                stmt.registerOutParameter(1, Types.VARCHAR);  // Register return value
                                stmt.setString(2, username);
                                stmt.setString(3, password);

                                stmt.execute();
                                String message = stmt.getString(1);  // Get the message
                                response.sendRedirect("homePage.jsp");
                            } catch (Exception e) {
                                e.printStackTrace();
                                out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
                            } finally {
                                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                            }
                        }
                    %>
</body>
</html>
