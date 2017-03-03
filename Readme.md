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

## ORIGINAL (time diff + SystemOut)
```
Adding(1M) Elements (5 Tests Avg.)

LinkedList: 174.8 milliseconds
ArrayList:  76.4 milliseconds
GlueList:   39.2 milliseconds

Adding(10M) Elements (5 Tests Avg.)

LinkedList: 8975.6 milliseconds
ArrayList:  4118.2 milliseconds
GlueList:   3320.1 milliseconds

```
## JMH
 - Prepare local for JMH : "mvn -e clean install"
 - Launch Java Class (containing void main) : com.ertu.collection.jmh.GlueListJMH
 - for eclipse developers : 3 tools available in "eclipse-tools" directory (you have to configure "mvn" variable in Eclipse Preferences "String subsitutions" pointing to your maven directory)

```
Run complete. Total time: 00:02:13

Benchmark                                 Mode  Cnt    Score    Error  Units
GlueListJMH.test_1_add_500k_linked_list  thrpt    5  182,338 ± 32,451  ops/s
GlueListJMH.test_2_add_500k_array_list   thrpt    5  214,535 ±  7,479  ops/s
GlueListJMH.test_3_add_500k_glue_list    thrpt    5  251,288 ± 14,355  ops/s
GlueListJMH.test_4_add_1m_linked_list    thrpt    5   80,549 ± 10,526  ops/s
GlueListJMH.test_5_add_1m_array_list     thrpt    5   93,010 ±  4,741  ops/s
GlueListJMH.test_6_add_1m_glue_list      thrpt    5  121,447 ± 12,033  ops/s
GlueListJMH.test_7_add_10m_linked_list   thrpt    5    2,090 ±  1,890  ops/s
GlueListJMH.test_8_add_10m_array_list    thrpt    5    5,713 ±  1,720  ops/s
GlueListJMH.test_9_add_10m_glue_list     thrpt    5    9,644 ±  5,810  ops/s
```
```
Run complete. Total time: 00:19:37

Benchmark                                 Mode  Cnt    Score   Error  Units
GlueListJMH.test_1_add_500k_linked_list  thrpt   50  174,315 ± 8,554  ops/s
GlueListJMH.test_2_add_500k_array_list   thrpt   50  207,423 ± 3,637  ops/s
GlueListJMH.test_3_add_500k_glue_list    thrpt   50  286,250 ± 5,346  ops/s
GlueListJMH.test_4_add_1m_linked_list    thrpt   50   77,277 ± 1,607  ops/s
GlueListJMH.test_5_add_1m_array_list     thrpt   50   91,264 ± 3,051  ops/s
GlueListJMH.test_6_add_1m_glue_list      thrpt   50  131,970 ± 3,007  ops/s
GlueListJMH.test_7_add_10m_linked_list   thrpt   50    2,026 ± 0,195  ops/s
GlueListJMH.test_8_add_10m_array_list    thrpt   50    6,085 ± 0,208  ops/s
GlueListJMH.test_9_add_10m_glue_list     thrpt   50    8,842 ± 0,360  ops/s
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