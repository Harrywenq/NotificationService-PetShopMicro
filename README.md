# 📩 Notification Service - PetShop Microservice

Notification Service là microservice chịu trách nhiệm gửi thông báo trong hệ thống **PetShop Microservice**.

Service này có thể xử lý các loại thông báo như:

- Gửi email xác nhận đơn hàng
- Thông báo đăng ký tài khoản thành công
- Gửi thông báo thay đổi trạng thái đơn hàng
- Thông báo hệ thống

---

## 🏗 Vai trò trong hệ thống

Notification Service hoạt động độc lập và nhận request từ các service khác như:

- Auth Service
- User Service
- Order Service

Thông thường sẽ được gọi khi:

- User đăng ký thành công
- Đơn hàng được tạo
- Trạng thái đơn hàng thay đổi

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Mail**
- **Spring Web**
- **Spring Validation**
- **Lombok**
- **Maven**

(Nếu có tích hợp message broker như Kafka / RabbitMQ thì có thể bổ sung thêm.)

---

## 📌 Kiến trúc tổng quan


Order Service
│
▼
Notification Service
│
▼
Email Server (SMTP)


Notification Service có thể hoạt động theo hai cơ chế:

- Gọi trực tiếp qua REST
- Hoặc nhận message qua Message Broker (nếu có)

---

## 📂 Cấu trúc project

```
src/main/java/com/huytpq/notification_service
├── config # Mail configuration
├── controller # REST API nhận request gửi mail
├── dto # Request / Response DTO
├── service # Business logic gửi mail
└── NotificationServiceApplication.java
```

---

## ✉️ Chức năng chính

- Gửi email đơn giản (Simple Mail)
- Gửi email HTML (nếu có template)
- Validate dữ liệu đầu vào
- Xử lý lỗi gửi mail
- Logging

---

## ⚙️ Cấu hình

`application.yml`:

```yml
server:
  port: 8085

spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: your-email@gmail.com
    password: your-app-password
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

## ▶️ Chạy project
```
mvn clean install
mvn spring-boot:run
```
Hoặc:
```
java -jar target/notification-service-0.0.1-SNAPSHOT.jar
```
## 📡 REST API

- Base URL:
```
/api/notifications
```
