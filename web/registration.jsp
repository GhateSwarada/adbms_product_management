<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
</head>
<body class="bg-light">
                    <%
                        String dbURL = "jdbc:mysql://localhost:3306/adbms";
                        String dbUsername = "root";
                        String dbPassword = "Mysql@2004";
                        Connection conn = null;
                        CallableStatement stmt = null;

                        String username = request.getParameter("username");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");

                        if (username != null && email != null && password != null) {
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                                // Call the stored procedure
                                stmt = conn.prepareCall("{CALL register_user(?, ?, ?, ?)}");
                                stmt.setString(1, username);
                                stmt.setString(2, password);
                                stmt.setString(3, email);
                                stmt.registerOutParameter(4, Types.VARCHAR);  // OUT parameter for message

                                stmt.execute();
                                String message = stmt.getString(4);
                                response.sendRedirect("index.html");
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
