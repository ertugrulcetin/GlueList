#GlueList ~ Fastest Java List implementation

 - GlueList is a brand new List implementation which is way faster than ArrayList and LinkedList.
 
 - This implementation inspired from ArrayList and LinkedList working mechanism.
  
 - Nodes holding data in arrays, in the beginning the world just like ArrayList ,inserts data into array one by one when there is no space for insertion to array
  new Node will be created and linked with the last Node.
  
 - The array which belongs to newly created node has half of the size of list , just like ArrayList.
  
 - In ArrayList when there is no space for it it creates new array with double of old size and inserts old data into new one.
  
 - Unlike ArrayList GlueList does it dynamically way with creating new node so old data does NOT have to be moved to another array.
  
 - You can think that GlueList is dynamic version of ArrayList.
  
#Benchmark
 - Adding and removing operations much faster than ArrayList and LinkedList.
 - Searching operations nearly same with ArrayList and way better than LinkedList.

```
Adding(1M) Elements (5 Tests Avg.)

LinkedList: 174.8 milliseconds
ArrayList:  76.4 milliseconds
GlueList:   39.2 milliseconds

Adding(10M) Elements (5 Tests Avg.)

LinkedList: 4118.2 milliseconds
ArrayList:  8975.6 milliseconds
GlueList:   3320.1 milliseconds

```
#Big-O Algorithm Complexity

```
  "m" number of created nodes.
  "n" size of node array.
  If you insert 10_000_000 record into List there will be just 36 nodes.
  
 
  Best Case
  Add O(1)
  Remove O(1)
  Search O(1)
  Access O(1)
  
  Worst Case
  Add O(n*m)
  Remove O(n*m)
  Search O(m)
  Access O(m)
```

#Licence
```
  Copyright 2015 Ertuğrul Çetin
  
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  
  http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```