## Test
###
Exercise: Sliding window average
- Accepts an endless series of data records (value + timestamp). It is guaranteed that timestamp of each received record will be greater or equal to timestamp of the previous record. Datatype of the values is your choice.
- On each record it returns a value average over a sliding time window. The sliding window ends at the timestamp of the last record and its beginning is at lastTimestamp – windowLength, where windowLength is provided as a parameter on the object creation.

### Technology Stack
- Java 11
- Junit 5
- Gradle

### Build Command
#####Make sure docker machine is installed already.
- To build and run tests
> gradle clean build


### Todo
- Improve performance of PriorityWindowAverage.java
- Accept endless series of records
- Add unit tests to check thread safety 