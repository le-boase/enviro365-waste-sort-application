# Enviro Assessment

## Description

The Enviro Assessment application is designed to manage waste categories, disposal guidelines, and recycling tips. It provides RESTful APIs using Spring Boot to expose the required functionalities for data retrieval and manipulation.

## Features

- **Waste Categories**: Create, update, delete, and retrieve waste categories.
- **Disposal Guidelines**: Create, update, delete, and retrieve disposal guidelines.
- **Recycling Tips**: Create, update, delete, and retrieve recycling tips.

## Technologies Used

- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- Hibernate
- H2 Database (for testing)
- JUnit and Mockito (for testing)

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

## Running the Application

1. **Clone the repository**:
    ```sh
    git clone https://github.com/le-boase/enviro-assessment.git
    cd enviro-assessment
    ```

2. **Run the application**:
    ```sh
    Run the Application file 
    ```

4. **Access the API**:
    - The application will be running at `http://localhost:8080`.
    - You can use tools like `curl` or Postman to interact with the endpoints.

## API Endpoints

### Waste Categories

- `GET /api/waste-categories`: Retrieve all waste categories.
- `GET /api/waste-categories/{id}`: Retrieve a specific waste category by ID.
- `POST /api/waste-categories`: Create a new waste category.
- `PUT /api/waste-categories/{id}`: Update an existing waste category by ID.
- `DELETE /api/waste-categories/{id}`: Delete a waste category by ID.

### Disposal Guidelines

- `GET /api/disposal-guidelines`: Retrieve all disposal guidelines.
- `GET /api/disposal-guidelines/{id}`: Retrieve a specific disposal guideline by ID.
- `POST /api/disposal-guidelines`: Create a new disposal guideline.
- `PUT /api/disposal-guidelines/{id}`: Update an existing disposal guideline by ID.
- `DELETE /api/disposal-guidelines/{id}`: Delete a disposal guideline by ID.

### Recycling Tips

- `GET /api/recycling-tips`: Retrieve all recycling tips.
- `GET /api/recycling-tips/{id}`: Retrieve a specific recycling tip by ID.
- `POST /api/recycling-tips`: Create a new recycling tip.
- `PUT /api/recycling-tips/{id}`: Update an existing recycling tip by ID.
- `DELETE /api/recycling-tips/{id}`: Delete a recycling tip by ID.

## Testing

To run the tests, use the following command:
```sh
mvn test
