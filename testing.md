# 🚀 Microservices Endpoints Reference (Localhost)

This document outlines the API endpoints for the deployed services using **localhost** and their respective ports.

| Service | Port |
| :--- | :--- |
| **Event Service** | 8081 |
| **Booking Service** | 8082 |
| **Notification Service** | 8083 |

---

## 📅 Event Service (Port 8081)

### 1. Get All Events
* **Method:** `GET`
* **URL:** `http://localhost:8081/events`

### 2. Get Event by ID
* **Method:** `GET`
* **URL:** `http://localhost:8081/events/1`

### 3. Create New Event
* **Method:** `POST`
* **URL:** `http://localhost:8081/events`
* **Body (JSON):**
```json
{
  "eventName": "New Event",
  "venue": "Main Hall",
  "date": "2025-12-10",
  "price": 150,
  "totalSeats": 100,
  "availableSeats": 100
}
````

  * **cURL:**

<!-- end list -->

```bash
curl -X POST "http://localhost:8081/events" ^
  -H "Content-Type: application/json" ^
  -d "{\"eventName\":\"New Event\",\"venue\":\"Main Hall\",\"date\":\"2025-12-10\",\"price\":150,\"totalSeats\":100,\"availableSeats\":100}"
```

### 4\. Decrease Seats (Used by Booking Service)

  * **Method:** `PUT`
  * **URL (Example: decrease 2 seats for event 1):** `http://localhost:8081/events/1/decrease?qty=2`
  * **cURL:**

<!-- end list -->

```bash
curl -X PUT "http://localhost:8081/events/1/decrease?qty=2"
```

### 5\. Update Entire Event

  * **Method:** `PUT`
  * **URL:** `http://localhost:8081/events/1`
  * **Body (JSON - full payload):**

<!-- end list -->

```json
{
  "eventName": "Updated Event",
  "venue": "Updated Venue",
  "date": "2025-12-20",
  "price": 200,
  "totalSeats": 120,
  "availableSeats": 80
}
```

### 6\. Delete One Event

  * **Method:** `DELETE`
  * **URL:** `http://localhost:8081/events/1`

### 7\. Delete All Events

  * **Method:** `DELETE`
  * **URL:** `http://localhost:8081/events`

-----

## 🎟️ Booking Service (Port 8082)

### 1\. Create Booking (Main Flow)

  * **Method:** `POST`
  * **URL:** `http://localhost:8082/bookings`
  * **Body (JSON):**

<!-- end list -->

```json
{
  "eventId": 1,
  "quantity": 2
}
```

  * **cURL (Windows cmd, one line):**

<!-- end list -->

```bash
curl -X POST "http://localhost:8082/bookings" -H "Content-Type: application/json" -d "{\"eventId\":1,\"quantity\":2}"
```

-----

## 🔔 Notification Service (Port 8083)

This service is normally called by the **Booking Service**, but can be tested manually.

### 1\. Send Test Notification

  * **Method:** `POST`
  * **URL:** `http://localhost:8083/notifications`
  * **Body (JSON):**

<!-- end list -->

```json
{
  "email": "your-email@example.com",
  "eventName": "Sample Event",
  "quantity": 2
}
```

  * **cURL:**

<!-- end list -->

```bash
curl -X POST "http://localhost:8083/notifications" ^
  -H "Content-Type: application/json" ^
  -d "{\"email\":\"your-email@example.com\",\"eventName\":\"Sample Event\",\"quantity\":2}"
```
