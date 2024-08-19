# Maximum Quality
For given list of inputs, and channels find the maximum quality that would be achievable with input values distribution over the channels.
Quality is mesaured as:

sum of medians of the distributed sub lists on each channel.

Rule: each channel must have atleast one element.

Example:
```
Input: 1,2,3,4,5
Channels: 2
```
So possible combinations of configurations are:
```
Channel1      Channel2                median
 1                   2,3,4,5                    1 + (3+4)/2 = 1+ 3.5 = 4.5 = 5 (rounded)
 1,2                   3,4,5                    (1+2)/2 + 4 =1.5+4 = 5.5 =6
 1,2,3                   4,5                    2 + (4+5)/2 = 6.5 =7
 1,2,3,4                   5                    (2+3)/2 + 5 =2.5 + 5 = 7.5 = 8
```
So answer is maximun Qulity achivable is '8' with configuration 1,2,3,4 on channel 1 and 5 on channel 2

Similarly for
```
input: 1,2,3,4,5
channels: 3
```
possible configurations are:
```
ch1             ch2                   ch3                         medians     

1                 2                      3,4,5                        1+2+4 = 7
1                 2,3                   4,5                           1+2.5+4.5 = 8
1                 2,3,4                5                              1+3+5 = 9

1,2               3                    4,5                            1.5+ 3 + 4.5 = 9
1,2               3,4                 5                               1.5 + 3.5 + 5 = 10

1,2,3            4                    5                               2 + 4 + 5 = 11
```
So maximum quality attainable is 11 with configuration 1,2,3 on channel1, 4 on channel 2 and 5 on channel 3.