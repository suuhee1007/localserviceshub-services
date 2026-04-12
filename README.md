# LocalServicesHub Services

Spring Boot backend for the LocalServicesHub application.

## Run locally

1. Create a PostgreSQL database named `localserviceshub`.
2. Update `src/main/resources/application.properties` with your database username and password.
3. Build and run the backend:

   ```bash
   cd localserviceshub-services
   mvn clean spring-boot:run
   ```

The backend listens on `http://localhost:8080` and exposes the following APIs:

- `POST /api/services` - register a new service
- `GET /api/services` - list all services
- `GET /api/services?type={serviceType}` - list services by type
- `GET /api/services/{id}` - view service details by id
