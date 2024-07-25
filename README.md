
---

# 🛠️ Microservices Monorepo

Welcome to the **Spring-boot-distributed-architecture**! This repository showcases a suite of Spring Boot microservices designed to illustrate both synchronous and asynchronous communication patterns. It includes essential microservices infrastructure and supports seamless service integration.

## 🚀 Overview

This project includes:

- **Customer Service**: Manages customer data and operations. 🧑‍🤝‍🧑
- **Order Service**: Handles order management. 📦
- **Gateway API**: Routes requests and manages cross-cutting concerns. 🚪
- **Discovery Service**: Manages service registration and discovery. 🔍
- **Config Server**: Centralizes configuration management. ⚙️

## 🏗️ Architecture

- **Customer Service**: Manages all customer-related functionalities.
- **Order Service**: Manages order-related operations.
- **Gateway API**: Serves as the entry point for external requests.
- **Discovery Service**: Utilizes Spring Cloud Netflix Eureka for service discovery.
- **Config Server**: Provides centralized configuration for microservices.

## 🐳 Docker Compose Setup

Docker Compose simplifies the management of multi-container applications. Use the provided `docker-compose.yml` file for an easy setup.

### 🛠️ Prerequisites

- **Docker**: Ensure Docker is installed and running.
- **Docker Compose**: Ensure Docker Compose is installed.

### 🚀 Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/firasabdelaziz/SpringbootDistributedArchitecture.git
   ```

2. **Configure Services**
   - Adjust configuration files (`application.yml`) if necessary for database connections and service URLs.

3. **Start Services**
   Launch all services with Docker Compose:
   ```bash
   docker-compose up
   ```
   This command will:
   - Build Docker images for each service.
   - Start containers and display logs in your terminal.

4. **Access Services**
   - **Gateway API**: `http://localhost:8080` 🚪
   - **Discovery Service**: `http://localhost:8761` 🔍
   - **Config Server**: `http://localhost:8888` ⚙️

5. **Stop and Clean Up**
   To stop and remove containers, networks, and volumes:
   ```bash
   docker-compose down
   ```


- **Integration Tests**: Ensure all services are operational before running integration tests.

## 🛠️ Troubleshooting

- **Service Issues**: Check container logs:
  ```bash
  docker logs <container_name>
  ```
- **Service Discovery**: Confirm the Discovery Service is active and configured correctly.
- **Configuration Issues**: Verify that the Config Server is operational and serving the correct configurations.

## 🤝 Contributing

- **Fork the Repository**: Create a branch for your changes.
- **Submit Pull Requests**: Include clear descriptions and testing details.

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 📫 Contact

For questions or issues, contact [firasabdelaziz123@gmail.com](mailto:firasabdelaziz123@gmail.com).

---
