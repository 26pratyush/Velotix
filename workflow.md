# 🎫 Event Booking Workflow (No UI)

This workflow outlines the typical sequence of API calls to manage event creation and booking, assuming a microservices architecture (`Event Service` on port 8081 and a `Booking Service` on 8082).


## 1\. Create Events

  * **Endpoint:** `POST /events`
  * **Action:** You (as the admin/user) create new events by sending **JSON data** with event details to the **Event Service**.
  * **Tool:** Postman or `curl`.
  * **Result:** Event details are stored in the database.

> ### Example `curl`
>
> ```bash
> curl -X POST http://localhost:8081/events \
> -H "Content-Type: application/json" \
> -d '{"eventName":"Concert","venue":"Main Hall","date":"2025-12-05","price":200,"totalSeats":100}'
> ```


## 2\. List Available Events

  * **Endpoint:** `GET /events`
  * **Action:** Retrieve all events from the **Event Service**.
  * **Tool:** Postman, `curl`, or browser.
  * **Result:** You see details for all events, including the current count of **available seats**.

> ### Example `curl`
>
> ```bash
> curl http://localhost:8081/events
> ```


## 3\. Book Tickets

  * **Endpoint:** `POST /bookings` (via **Booking Service**)
  * **Action:** Submit a booking request with the **`eventId`** and the desired seat **quantity**.
  * **Tool:** Postman or `curl`.
  * **Result:**
      * The **Booking Service** checks seat availability with the **Event Service**.
      * If seats are available, the **Booking Service** decrements available seats in the database (typically by coordinating with the **Event Service**).
      * Returns booking confirmation, usually as JSON.

> ### Example `curl`
>
> ```bash
> curl -X POST http://localhost:8082/bookings \
> -H "Content-Type: application/json" \
> -d '{"eventId":1,"quantity":2}'
> ```


## 4\. Check Seat Update

  * **Endpoint:** `GET /events/{id}`
  * **Action:** Query a specific event by its ID (`1` in the example) to verify the updated seat count.
  * **Tool:** Postman or `curl`.
  * **Result:** Confirm that the number of **available seats** was reduced after the booking request.

> ### Example `curl`
>
> ```bash
> curl http://localhost:8081/events/1
> ```


## 5\. Notification (if implemented)

  * **Endpoint:** (Notification Service, triggered by Booking Service)
  * **Action:** The system confirms the booking—this is often visible only as a **log entry** or console output in a headless environment.
