# Enterprise Request & Approval Management System

A production-oriented backend learning project built with **Java 17, Spring Boot, and Oracle Database**, designed to demonstrate practical enterprise application development and intermediate-level backend engineering skills.

## Project Overview

Enterprise Request & Approval Management System provides a structured backend for managing organizational purchase requests, employee assignments, and approval decisions.

Employees can submit purchase requests, while authorized approvers can review, approve, or reject them. The system is designed to enforce business rules, preserve historical changes, and maintain data consistency.

The project is being developed incrementally, with an emphasis on clean architecture, maintainability, security, database integrity, and automated testing.

## Project Objectives

The main objective is to design and implement a maintainable enterprise-style backend application while applying essential Java and Spring Boot concepts to realistic business scenarios.

Key engineering objectives include:

- **Domain-Driven Business Logic:** Model organizational entities, request lifecycles, approval rules, and valid state transitions.
- **RESTful API Development:** Build consistent APIs using DTOs, validation, pagination, filtering, and standardized responses.
- **Database Design and Migration:** Design relational schemas in Oracle Database and manage version-controlled schema changes through Liquibase XML.
- **Authentication and Authorization:** Secure APIs using Spring Security, JWT authentication, and role-based access control.
- **Transaction Management:** Maintain consistency across business operations using Spring transactions and appropriate rollback behavior.
- **Concurrency Control:** Prevent conflicting updates using optimistic locking and meaningful conflict responses.
- **Auditability:** Track creation and modification timestamps, preserve entity revisions with Hibernate Envers, and record approval decisions.
- **Performance Optimization:** Identify and resolve common JPA performance issues, including N+1 queries, inefficient fetching, and missing indexes.
- **Exception Handling:** Implement centralized error handling with consistent HTTP status codes and error responses.
- **Automated Testing:** Validate business rules and persistence behavior using JUnit, Mockito, and integration tests.
- **Deployment and Delivery:** Containerize the application and introduce automated build and test workflows.

## Technology Stack

| Category | Technologies |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| Persistence | Spring Data JPA, Hibernate |
| Database | Oracle Database |
| Migration | Liquibase XML |
| Security | Spring Security, JWT |
| Validation | Jakarta Bean Validation |
| Auditing | Spring Data JPA Auditing, Hibernate Envers |
| Testing | JUnit 5, Mockito |
| Build | Maven |
| DevOps | Docker, GitHub Actions |

## Core Business Features

### Department and Employee Management
Maintain organizational departments and employees, including their relationships and active status.

### Purchase Request Management
Allow employees to create and manage purchase requests with titles, descriptions, requesters, approvers, and lifecycle statuses.

### Approval Processing
Implement controlled approval and rejection operations with business validation, authorized access, and transaction safety.

### Approval History
Maintain a dedicated history of approval decisions for business traceability.

### Authentication and Authorization
Restrict application operations based on authenticated users and assigned roles.

### Auditing and Concurrency
Preserve entity revision history and prevent conflicting modifications through optimistic locking.

## Architecture

The application follows a modular, layered monolithic architecture.

**Controller → Service → Repository → Oracle Database**

Supporting components include:

- DTOs and object mapping
- Security configuration
- Centralized exception handling
- Validation
- Auditing
- Database migrations
- Automated tests

The architecture intentionally prioritizes clarity and maintainability over unnecessary distributed-system complexity.

## Development Roadmap

### Phase 1 — Persistence Foundation
- Entity modeling and relationships
- Oracle sequences and constraints
- Liquibase initial schema (v1.1.1)
- Spring Data JPA auditing
- Hibernate Envers configuration

### Phase 2 — Application and Business Logic
- Repository layer
- Service layer
- Request lifecycle and approval rules
- DTOs, mapping, and validation
- REST controllers
- Exception handling

### Phase 3 — Security and Data Consistency
- Spring Security and JWT
- Role-based authorization
- Transaction boundaries
- Optimistic locking and conflict handling
- Approval history

### Phase 4 — Testing and Performance
- Unit and integration testing
- Repository query optimization
- N+1 query prevention
- Pagination and filtering
- Database indexing

### Phase 5 — Delivery and Deployment
- Docker configuration
- Environment-specific configuration
- GitHub Actions CI
- Application documentation
- Final refactoring and review

## Project Status

**Active Development — Phase 1**

The initial domain model and Liquibase migration files are being prepared. Application services, REST APIs, security, tests, and deployment features are planned for subsequent phases.

## Engineering Focus

This project emphasizes practical engineering decisions rather than framework usage alone:

- Separation of responsibilities between application layers
- Explicit business rules and consistent state transitions
- Reliable database migrations
- Transactional consistency and concurrency safety
- Secure API design
- Testable and maintainable code
- Performance-aware persistence
- Incremental delivery through version control

## Scope

The project intentionally uses a modular monolithic architecture. Advanced workflow engines, HR synchronization, organizational position management, and microservices are outside the current scope.

## License

To be determined.