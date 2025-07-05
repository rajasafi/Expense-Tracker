# 💰 Expense Tracker

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.7-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](LICENSE)

> A comprehensive personal finance management application built with Spring Boot, featuring dual authentication (Session + JWT), intuitive UI, and robust expense tracking capabilities.

## 🌟 Features

- **💳 Expense Management**: Add, edit, delete, and categorize expenses with detailed descriptions
- **📊 Dashboard Analytics**: Real-time overview of total expenses, spending patterns, and financial insights
- **🔐 Dual Authentication**: Secure login system supporting both Session-based and JWT token authentication
- **👤 User Management**: Complete user registration and profile management
- **📱 Responsive Design**: Mobile-friendly interface built with Bootstrap 5.3.0
- **🔍 Search & Filter**: Advanced filtering options for expense tracking
- **📈 Financial Reporting**: Detailed expense reports and spending analysis
- **🎨 Modern UI**: Clean, intuitive interface with Thymeleaf templates

## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot 3.4.7
- **Language**: Java 17
- **Security**: Spring Security with dual authentication (Session + JWT)
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven 3.8+

### Frontend
- **Template Engine**: Thymeleaf
- **CSS Framework**: Bootstrap 5.3.0
- **JavaScript**: jQuery 3.7.0
- **Icons**: Bootstrap Icons

### Additional Libraries
- **JWT**: JJWT (Java JWT) for token-based authentication
- **Validation**: Spring Boot Validation
- **Code Generation**: Lombok
- **Object Mapping**: MapStruct
- **API Documentation**: SpringDoc OpenAPI (Swagger)

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- MySQL 8.0+
- Git

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/rajasafi/Expense-Tracker.git
cd Expense-Tracker
```

3. **Configure Database**
```bash
Create a MySQL database and update `application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Install Dependencies**
```bash
mvn clean install
```


4. **Run the Application**
```bash
mvn spring-boot:run
```


5. **Access the Application**
- ** Open your browser and navigate to `http://localhost:8080`**



## 🔧 Configuration

### Database Configuration
```git
  spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### JPA/Hibernate Configuration
```git
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### JWT Configuration
```git
jwt.secret=your-secret-key
jwt.expiration=86400000
```


## 🎯 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login (returns JWT token)
- `POST /api/auth/logout` - User logout

### Expense Management
- `GET /api/expenses` - Get all expenses
- `POST /api/expenses` - Create new expense
- `GET /api/expenses/{id}` - Get expense by ID
- `PUT /api/expenses/{id}` - Update expense
- `DELETE /api/expenses/{id}` - Delete expense

### Dashboard
- `GET /api/dashboard/summary` - Get expense summary
- `GET /api/dashboard/analytics` - Get spending analytics



## 🎨 Screenshots

### Login Page
Clean and secure authentication interface with dual login options.
![Log In UI](https://i.imghippo.com/files/YwV9056O.png)

### Dashboard
Comprehensive overview showing:
- Total Expenses: 5 recorded expenses
- Total Amount: ₹55,900.00
- Last Expense: Pizza - ₹50,000.00

### Add Expense
Intuitive form with fields for:
- Expense Name
- Amount
- Date
- Description

### Expense List
Complete expense management with:
- Searchable expense list
- Edit/Delete functionality
- Category-based filtering

## 🔐 Security Features

- **Spring Security**: Comprehensive security configuration
- **Password Encryption**: BCrypt password hashing
- **JWT Authentication**: Stateless token-based authentication
- **Session Management**: Traditional session-based authentication
- **CSRF Protection**: Cross-site request forgery protection
- **Input Validation**: Server-side validation for all inputs

## 🧪 Testing

### Run Tests



```git

```

