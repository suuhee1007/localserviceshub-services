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

## Keep the app awake without upgrading Render

Render free/auto-sleep plans will put the app to sleep after idle time. To avoid slow first responses, use a scheduled ping from GitHub Actions or another free scheduler.

1. Add a health endpoint to the backend: `GET /health`
2. Configure the GitHub Actions workflow below to call your deployed Render URL every 10 minutes.
3. Replace `https://your-render-app.onrender.com/health` with your real app URL.

This does not require upgrading your Render plan — it keeps the service warm by sending periodic traffic.
