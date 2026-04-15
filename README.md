# 🛒 E-Commerce Web Application Automation Framework

## 📌 Project Overview

This project focuses on building a Selenium-based automation framework for testing an E-Commerce web application. The framework is designed to automate key user flows such as login, product search, cart operations, checkout, and form validations.

A structured approach using the Page Object Model (POM) has been followed to keep the code organized, reusable, and easy to maintain.

---

## 🚀 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Extent Reports

---

## 📂 Project Structure

```
src/
 ├── main/java/
 │    ├── base/        → Common reusable methods
 │    ├── pages/       → Page classes for each screen
 │    └── utils/       → Utility classes (config, Excel, reporting)
 │
 └── test/
      ├── java/
      │    ├── base/        → Test setup and driver handling
      │    ├── listeners/   → Screenshot and reporting logic
      │    └── tests/       → Test case classes
      │
      └── resources/
           ├── testdata/        → Excel test data
           └── config.properties → Configuration file

screenshots/   → Screenshots captured on failure  
reports/       → Execution reports  
testng.xml     → Test execution file  
pom.xml        → Project dependencies  
```

---

## ✅ Features

* Page Object Model implementation
* Data-driven testing using Excel
* Screenshot capture on test failure
* Extent report generation after execution
* Use of explicit waits for handling dynamic elements
* Configuration handled through properties file
* End-to-End test scenario implemented

---

## 🧪 Test Coverage

### User Authentication

* Login with valid credentials
* Login with invalid credentials
* Logout functionality
* User registration

### Product Module

* Search products
* Category navigation
* Product detail validation

### Cart Module

* Add product to cart
* Remove product from cart
* Cart count validation

### Checkout Module

* Complete checkout flow
* Checkout without login

### Form Validation

* Empty field validation
* Invalid email validation

---

## 🔄 End-to-End Flow

Login → Search Product → Add to Cart → View Cart → Checkout → Payment → Order Confirmation

---

## ▶️ How to Run

1. Clone the repository
2. Open the project in an IDE (Eclipse or IntelliJ)
3. Run the `testng.xml` file

---

## 📸 Reporting

* Test execution results are generated using Extent Reports
* Screenshots are captured automatically when a test fails

---

## ⚙️ Design Approach

* Followed Page Object Model for better code organization
* Used WebDriverWait instead of hard waits
* Implemented listener for reporting and failure handling
* Separated test logic and page logic clearly

---

## 👩‍💻 Author

Vaishnavi

---

## 🏁 Summary

The framework provides a structured and maintainable way to automate testing of an E-Commerce application, covering both individual functionalities and complete user flows.
