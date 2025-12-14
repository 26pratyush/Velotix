## Run all services with Docker

From the project root (where `docker-compose.yml` is):

```bash
docker compose up --build
```

Wait until logs show all services started and Eureka UI works at `http://localhost:8761`.

## Basic health checks (browser)

1. Eureka dashboard:  
   `http://localhost:8761`
2. Event Service through gateway:  
   `http://localhost:8080/event-service/events`

## Sample Postman requests (via API Gateway)

### 1) Create an event

- Method: **POST**  
- URL: `http://localhost:8080/event-service/events`  
- Headers: `Content-Type: application/json`  
- Body (raw JSON):

```json
{
  "eventName": "Sample Event",
  "venue": "College Auditorium",
  "date": "2025-12-01",
  "price": 100,
  "totalSeats": 50
}
```

### 2) List events

- Method: **GET**  
- URL: `http://localhost:8080/event-service/events`

Check that your event appears (note its `eventId`).

### 3) Book tickets

- Method: **POST**  
- URL: `http://localhost:8080/booking-service/bookings`  
- Headers: `Content-Type: application/json`  
- Body:

```json
{
  "eventId": 1,
  "quantity": 2
}
```

Use the actual `eventId` from step 2. This should reduce `availableSeats` and trigger a log message in `notification-service`.
