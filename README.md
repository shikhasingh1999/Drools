# Drools Order Processing Demo

This repository demonstrates how to use [Drools](https://www.drools.org/) as a business rule engine for dynamic order processing, customer categorization, and automatic discount application in a Spring Boot application.

## Features

- **Drools Rule Engine Integration:** Spring Boot configuration for Drools, enabling rule-driven business logic.
- **Order Flow APIs:** Prepare and place orders via REST endpoints.
- **Dynamic Customer Segmentation:** Customer type and category determined by rules (e.g., REGULAR, VIP; BRONZE, GOLD, etc.).
- **Automated Discount Calculation:** Discount percentage applied based on customer segmentation rules.
- **Extensible Rule Sets:** Easily add or modify rules without changing Java code.

## How It Works

1. **Prepare Order:**  
   - Submit customer and order details to `/orders/prepare`.
   - Drools rules identify customer type, category, and calculate applicable discount.
   - Response includes the order details, calculated discount, and confirmation prompt.

2. **Place Order:**  
   - Confirm and place the order via `/orders/place`.
   - Generates a unique order ID and finalizes the transaction.

## Tech Stack

- **Spring Boot**
- **Drools (KIE)**
- **Java (Lombok for models)**
- **RESTful API (Spring Web)**

## Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/shikhasingh1999/Drools.git
   cd Drools
   ```

2. **Build and Run**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or use your IDE to run `DroolsDemoApplication.java`.

3. **Test Orders via API**
   - Prepare Order:
     ```http
     POST /orders/prepare
     Content-Type: application/json

     {
       "customerName": "John Doe",
       "ordersCount": 15,
       "cardType": "VISA",
       "totalSpent": 5000,
       "amount": 1200
     }
     ```
   - Place Order:
     ```http
     POST /orders/place
     Content-Type: application/json

     {
       ...order data from previous response...
     }
     ```

## Rule Structure

Rules are organized by customer type, category, and discount calculation in the `RuleSet` enum. See the `src/main/resources` folder for `.drl` rule files.

## Project Structure

- `src/main/java/com/example/config/DroolsConfig.java` – Drools setup
- `src/main/java/com/example/service/impl/OrderServiceImpl.java` – Order and rule orchestration
- `src/main/java/com/example/service/impl/RuleEngineService.java` – Rule execution logic
- `src/main/java/com/example/controller/OrderController.java` – REST API endpoints
- `src/main/java/com/example/model/` – Data models
- `src/main/java/com/example/enums/` – Customer and rule enums

## Extending Rules

To introduce new business logic:
1. Create or edit `.drl` files in the resources directory.
2. Reference the new rule set in the `RuleSet` enum and service layer.

