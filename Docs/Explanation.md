**Data Structures**

```java
// Main.dateToBooking
private HashMap<Integer, Booking> dateToBooking;
```
Maps the day of the month (1 - 31) to a Booking
Why HashMap? instant access to certain days for fast checking availability,
compared to a fixed size array, which would require iterating over the whole array every time availability needed to be checked
- Uses null to mark free dates
- private + no methods to remove key-value pairs, as it should be fixed size of 31




**Methods**


**Other reasoning**
Main.rowcount, Main.columncount, Main.numOfdays
- uses static final, so they can be referenced from anywhere clearly
- avoids use of magic numbers around the program for easier code reading



**Problems**
not completely sure on a good way to implement printSeatView()
have to print out 10 lines, with each line having 10 characters to represent whether a seat is taken or not

