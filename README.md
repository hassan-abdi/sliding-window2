## Test
###
Exercise: Sliding window average
- Accepts an endless series of data records (value + timestamp). It is guaranteed that timestamp of each received record will be greater or equal to timestamp of the previous record. Datatype of the values is your choice.
- On each record it returns a value average over a sliding time window. The sliding window ends at the timestamp of the last record and its beginning is at lastTimestamp – windowLength, where windowLength is provided as a parameter on the object creation.

### Moving Average
In statistics, a moving average (rolling average or running average) is a calculation to analyze data points by creating a series of averages of different subsets of the full data set. It is also called a moving mean (MM)[1] or rolling mean and is a type of finite impulse response filter. Variations include: simple, cumulative, or weighted forms (described below).

Given a series of numbers and a fixed subset size, the first element of the moving average is obtained by taking the average of the initial fixed subset of the number series. Then the subset is modified by "shifting forward"; that is, excluding the first number of the series and including the next value in the subset.

A moving average is commonly used with time series data to smooth out short-term fluctuations and highlight longer-term trends or cycles. The threshold between short-term and long-term depends on the application, and the parameters of the moving average will be set accordingly. For example, it is often used in technical analysis of financial data, like stock prices, returns or trading volumes. It is also used in economics to examine gross domestic product, employment or other macroeconomic time series. Mathematically, a moving average is a type of convolution and so it can be viewed as an example of a low-pass filter used in signal processing. When used with non-time series data, a moving average filters higher frequency components without any specific connection to time, although typically some kind of ordering is implied. Viewed simplistically it can be regarded as smoothing the data.

[Moving Average Reference](https://en.wikipedia.org/wiki/Moving_average)


### Technology Stack
- Java 11
- Junit 5
- Gradle

### Build Command

- To build and run tests
> gradle clean build


### Todo
- Add unit tests to check thread safety 