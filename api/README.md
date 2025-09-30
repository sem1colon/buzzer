# Buzzer API

A Spring Boot REST API for the Buzzinga online buzzer system. This backend service manages contests and contestants for real-time buzzer competitions.

## Overview

The Buzzer API provides RESTful endpoints for:
- Creating and managing contests
- Managing contestants and their participation
- Real-time buzzer functionality for competitive events

## Tech Stack

- **Java 8**
- **Spring Boot 2.5.4**
- **Spring Data JPA** - For data persistence
- **H2 Database** - In-memory/file-based database
- **Maven** - Build tool

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/sem1colon/buzzer/
│   │       ├── BuzzerApplication.java          # Main application class
│   │       ├── contest/                        # Contest domain
│   │       │   ├── Contest.java               # Contest entity
│   │       │   ├── ContestController.java     # REST endpoints
│   │       │   ├── ContestRepository.java     # Data access layer
│   │       │   ├── ContestService.java        # Business logic
│   │       │   └── InvalidContestException.java
│   │       └── contestant/                     # Contestant domain
│   │           ├── Contestant.java            # Contestant entity
│   │           └── ...                        # Other contestant classes
│   └── resources/
│       └── application.properties             # Configuration
└── test/
    └── java/
        └── com/sem1colon/buzzer/
            └── BuzzerApplicationTests.java     # Test classes
```

## Prerequisites

- Java 8 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
cd buzzer/api
```

### 2. Build the project
```bash
# Using Maven wrapper (recommended)
./mvnw clean install

# Or using system Maven
mvn clean install
```

### 3. Run the application
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using system Maven
mvn spring-boot:run

# Or run the compiled JAR
java -jar target/buzzer-api-0.0.1-SNAPSHOT.jar
```

The API will be available at: `http://localhost:8080/buzzer`

## Configuration

The application uses H2 database with the following default configuration (in `application.properties`):

```properties
# Database Configuration
spring.datasource.url=jdbc:h2:file:./buzzer-data
spring.datasource.username=sa
spring.datasource.password=password

# JPA Configuration
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# H2 Console (for development)
spring.h2.console.enabled=true

# Context Path
server.servlet.contextPath=/buzzer
```

### H2 Database Console

Access the H2 database console at: `http://localhost:8080/buzzer/h2-console`

- **JDBC URL**: `jdbc:h2:file:./buzzer-data`
- **Username**: `sa`
- **Password**: `password`

## API Endpoints

### Contest Management
- `GET /buzzer/contests` - Get all contests
- `POST /buzzer/contests` - Create a new contest
- `GET /buzzer/contests/{id}` - Get contest by ID
- `PUT /buzzer/contests/{id}` - Update contest
- `DELETE /buzzer/contests/{id}` - Delete contest

### Contestant Management
- `GET /buzzer/contestants` - Get all contestants
- `POST /buzzer/contestants` - Add a new contestant
- `GET /buzzer/contestants/{id}` - Get contestant by ID
- `PUT /buzzer/contestants/{id}` - Update contestant
- `DELETE /buzzer/contestants/{id}` - Remove contestant

## Testing

Run the test suite:

```bash
# Using Maven wrapper
./mvnw test

# Or using system Maven
mvn test
```

## Development

### Code Style
- Follow Java naming conventions
- Use meaningful variable and method names
- Add appropriate comments for complex logic

### Adding New Features
1. Create feature branch: `git checkout -b feature/new-feature`
2. Implement your changes following the existing project structure
3. Add appropriate tests
4. Update documentation if needed
5. Submit a pull request

## Troubleshooting

### Common Issues

1. **Port already in use**: Change the port in `application.properties`:
   ```properties
   server.port=8081
   ```

2. **Database connection issues**: Ensure H2 database file permissions are correct

3. **Build failures**: Clean and rebuild:
   ```bash
   ./mvnw clean install
   ```

## Production Deployment

For production deployment:

1. **Database**: Replace H2 with a production database (PostgreSQL, MySQL, etc.)
2. **Configuration**: Use environment-specific configuration files
3. **Security**: Add Spring Security for authentication/authorization
4. **Monitoring**: Add actuator endpoints for health checks

Example production configuration:
```properties
# Production Database (example with PostgreSQL)
spring.datasource.url=jdbc:postgresql://localhost:5432/buzzer
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=validate
spring.h2.console.enabled=false
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## License

This project is part of the Buzzinga application. See the main project README for license information.

## Support

For issues and questions:
- Create an issue in the main repository
- Check existing documentation
- Review the H2 console for database-related issues