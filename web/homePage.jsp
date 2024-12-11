<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #007bff; /* Bootstrap Primary Color */
                color: white;
                text-align: center;
                padding-top: 50px;
            }
            h1 {
                margin-bottom: 50px;
            }
            .btn-custom {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Welcome</h1>
        <div class="container">
            <form>
                <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="form.jsp">Insert Product</button>
            <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="delete.jsp">Delete Product</button>
            <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="lessStock.jsp">Less Stock Product List</button>
            <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="profit.jsp">Profit Product</button>
            <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="sale.jsp">Sale a Product</button>
            <button type="submit" class="btn btn-light btn-lg btn-custom" formaction="total_rev.jsp">Total Revenue</button>
            </form>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
