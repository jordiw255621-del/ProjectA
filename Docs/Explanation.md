**Data Structures**

```java
private HashMap<Integer, Booking> dateToBooking;
```
Maps the day of the month (1 - 31) to a Booking
Why HashMap? instant access to certain days for fast checking availability,
compared to a fixed size array, which would require iterating over the whole array every time availability needed to be checked









**Methods**
