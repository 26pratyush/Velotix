## 💡 Feign Client Usage in Booking Service

In this project, **Feign** is used inside the **Booking Service** as a type-safe HTTP client to call other microservices by their *service names* registered in Eureka, instead of hard-coding URLs.

* Interfaces like `@FeignClient(name = "event-service")` and `@FeignClient(name = "notification-service")` declare methods that map directly to REST endpoints (for example, `getEventById` or `sendNotification`).
* Feign, together with Eureka, automatically resolves `event-service` or `notification-service` to the correct host and port, builds the HTTP request, and converts JSON to Java objects.


### Comparison: Feign vs. API Gateway for Internal Calls

For **internal** microservice-to-microservice calls, using Feign is often simpler and cleaner than putting an API Gateway in the middle:

* **Feign:** Each service can directly use Feign clients for **strongly-typed, IDE-friendly calls** without extra routing.
* **API Gateway:** An API Gateway is more useful as a **single external entry point for clients** (central routing, authentication, rate-limiting) rather than for everyday internal communication.
