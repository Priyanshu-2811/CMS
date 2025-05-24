# Client Management System

A robust and intuitive web application for managing client data, built using Spring Boot, Thymeleaf, MySQL, and Spring Data JPA. This system provides comprehensive CRUD (Create, Read, Update, Delete) operations to efficiently organize and track your client information.

## 🚀 Features

* **Comprehensive Client Records**: Easily **Create, Read, Update, and Delete** client profiles with all essential details (name, email, phone, address, etc.), ensuring your data is always current and organized.
* **Robust MySQL Database**: Your client data is securely stored and managed using a reliable **MySQL database**, providing high performance, scalability, and data integrity.
* **Simplified Data Access (JPA)**: Leverages **Spring Data JPA** for seamless and efficient interactions with your database, abstracting complex SQL queries and accelerating development.
* **Modern Web Experience**: Built with **Spring Boot** and **Thymeleaf**, offering a dynamic, user-friendly interface and a robust backend for smooth and responsive operations.
* **Secure & Reliable**: Your client data is protected with modern security practices, ensuring privacy and peace of mind at all times.
* **Accessible Anywhere**: Access your client data seamlessly from any device – desktop, tablet, or mobile – thanks to our responsive web design.

## 🛠️ Technologies Used

* **Backend**:
    * Spring Boot (3.x)
    * Spring Data JPA
    * Maven (for dependency management)
* **Frontend**:
    * Thymeleaf (Templating Engine)
    * Bootstrap 5 (CSS Framework)
    * Bootstrap Icons
* **Database**:
    * MySQL Database
* **Development Tools**:
    * Java 17+
    * IDE (e.g., IntelliJ IDEA, Eclipse)

## ⚙️ Setup and Installation

Follow these steps to get the project up and running on your local machine.

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* Maven
* MySQL Server running locally
* A preferred IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)

### Database Configuration

1.  **Create a MySQL Database**:
    ```sql
    CREATE DATABASE client_manager_db;
    ```
2.  **Configure `application.properties`**:
    Navigate to `src/main/resources/application.properties` and update the database connection details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/client_manager_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update # or create for first run, then update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.thymeleaf.cache=false # For development, set to true for production
    ```
    * **Note**: `ddl-auto=update` will automatically create/update tables based on your JPA entities. For the very first run, you might set it to `create` and then change it back to `update` to prevent data loss on subsequent runs.

### Running the Application

1.  **Clone the Repository**:
    ```bash
    git clone [https://github.com/your-username/client-management-system.git](https://github.com/your-username/client-management-system.git)
    cd client-management-system
    ```
    *(Replace `your-username/client-management-system.git` with your actual repository URL)*

2.  **Build the Project**:
    ```bash
    mvn clean install
    ```

3.  **Run the Spring Boot Application**:
    You can run it from your IDE or using Maven:
    ```bash
    mvn spring-boot:run
    ```

4.  **Access the Application**:
    Open your web browser and navigate to:
    ```
    http://localhost:8080
    ```

## 🚀 Usage

* **Home Page**: Provides an overview of the system and its features.
* **Clients Page (`/clients`)**: View a list of all clients.
* **Add New Client (`/clients/new`)**: Access the form to add a new client.
* **Edit Client (`/clients/edit/{id}`)**: Modify an existing client's details.
* **Delete Client (`/clients/delete/{id}`)**: Remove a client record from the system.

## 🤝 Contributing

Feel free to fork the repository, create a new branch, and submit pull requests. Any contributions are welcome!

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
*(Create a `LICENSE` file in your repository if you choose to include one.)*

## 👤 Developer

Developed by **Priyanshu Tiwari**
