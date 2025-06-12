# 📦 ADBMS Product Management Application

This application is a robust, full-stack product management system designed to streamline the handling of product data. Built with **Spring Boot** on the backend for powerful logic and **Thymeleaf** for dynamic web pages, it interacts with a database using **PL/SQL** for efficient data operations. The user interface is crafted with clean **HTML** and **CSS**, ensuring an intuitive and responsive experience.

## ✨ Key Features

* **Comprehensive Product Management:** Create, read, update, and delete (CRUD) product records effortlessly.
* **Secure & Efficient Data Handling:** Utilizes PL/SQL stored procedures and functions for optimized and secure database interactions.
* **Dynamic Web Interface:** Thymeleaf templates provide a server-rendered, interactive user experience.
* **Robust Backend:** Spring Boot ensures a scalable and maintainable application foundation.
* **User-Friendly Design:** Clean HTML and CSS for a visually appealing and easy-to-navigate interface.

## 🚀 Technologies & Tools

* **Spring Boot:** Framework for building the backend application.
* **PL/SQL:** Used for database stored procedures and functions to manage product data.
* **Thymeleaf:** Server-side templating engine for rendering dynamic HTML content.
* **HTML5:** Structure for the web pages.
* **CSS3:** Styling and visual design of the application.
* **Java:** Primary programming language for the backend.
* **Maven:** Dependency management and build automation.
* **Oracle Database:** (Assumed) The relational database system where PL/SQL procedures reside.

## 🛠️ Getting Started

Follow these steps to set up and run the project on your local machine.

### Prerequisites

* **Java Development Kit (JDK) 8 or higher:** Ensure Java is installed and configured.
* **Maven:** For building the project and managing dependencies.
* **Oracle Database:** An Oracle database instance with the necessary schema and permissions.
* **SQL Developer (or similar client):** To execute PL/SQL scripts and manage your database.
* **An IDE:** Such as IntelliJ IDEA, Eclipse, or VS Code with Spring Boot extensions.

### Database Setup

1.  **Connect to your Oracle Database:** Use SQL Developer or your preferred client.
2.  **Create Schema and Tables:** Execute the necessary SQL scripts (if provided in the repository, e.g., `schema.sql`, `data.sql`) to create the product table and any other required tables.
3.  **Implement PL/SQL Procedures:** Deploy the PL/SQL stored procedures, functions, and packages (e.g., `product_pkg.sql` or similar files) into your database schema. These procedures handle the actual CRUD operations for products.

    *Make sure the database connection details in your `application.properties` (or `application.yml`) file in the Spring Boot project match your database configuration.*

### Installation

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/GhateSwarada/adbms_product_management.git](https://github.com/GhateSwarada/adbms_product_management.git)
    ```
2.  **Navigate into the Project Directory:**
    ```bash
    cd adbms_product_management
    ```
3.  **Build the Project:** Use Maven to compile and package the application.
    ```bash
    mvn clean install
    ```

### Running the Application

1.  **Via IDE:**
    * Open the `adbms_product_management` project in your IDE.
    * Locate the main application class (e.g., `AdbmsProductManagementApplication.java`).
    * Run the `main` method.

2.  **Via Command Line:**
    * After building, navigate to the `target` directory.
    * Execute the JAR file:
        ```bash
        java -jar adbms_product_management-0.0.1-SNAPSHOT.jar # Adjust version as needed
        ```

The application should start on `http://localhost:8080` (or the port configured in `application.properties`).

## 🖥️ Usage

Once the application is running, open your web browser and go to `http://localhost:8080`. You will be greeted with the product management interface where you can:

* View a list of existing products.
* Add new products with their details.
* Edit existing product information.
* Delete products from the system.
