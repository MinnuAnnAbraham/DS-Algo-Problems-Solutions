# Longest path between any pair of vertices

We are given a map of cities connected with each other via cable lines such that there is no cycle between any two cities. We need to find the maximum length of cable between any two cities for given city map. 
```
Input : n = 6  
        1 2 3  // Cable length from 1 to 2 (or 2 to 1) is 3
        2 3 4
        2 6 2
        6 4 6
        6 5 5
Output: maximum length of cable = 12

```

Solution Method 1 (Simple DFS): We create undirected graph for given city map and do DFS from every city to find maximum length of cable. While traversing, we look for total cable length to reach the current city and if it’s adjacent city is not visited then call DFS for it but if all adjacent cities are visited for current node, then update the value of max_length if previous value of max_length is less than current value of total cable length. 

