# Project 2: Stardew Valley

* Author: Nathan Olson
* Class: CS321 Section # 002
* Semester: Spring

## Overview

This project involved implementing a Priority Queue abstract data type
by extending a MaxHeap structure and simulating a priority-based task
management algorithm inspired by Stardew Valley. The MaxHeap contains
Task objects that are compared based on priority and hour number,
determine task order within the scheduling algorithm.



## Reflection

Overall I found this project pretty enjoyable, but there were a 
couple of issues that I ran into throughout the process of
completing it. The easiest part for me was the first half of the
project. I didn't run into too many errors while writing Task.java
or MaxHeap.java, but after that I struggled quite a bit.

Writing the MaxHeapTest class was very difficult as I couldn't
remember how to structure it for a while, but I eventually figured
it out. Then there were also quite a few errors that I had to fix
with all of the tests to get them to pass. I also had a couple of
issues with the final two classes that we had to write, but most of
difficulties that I had were with completing the MaxHeapTest class. 
I also couldn't run the tests using my Git Bash, but they worked in 
the IDE, and I could never figure out why.

## Compiling and Using

In order to run the program, you would use the command: 
java MyLifeInStardew <max-priority-level> <time-to-increment-priority> 
<total simulation-time in days> <task-generation-probability> [<seed>]
The command generates a simulation based off of the information you
give to it, and then displays the results.

## Results 

All of the tests pass, and the test-cases outputs match with each 
given input command.

## Sources used

https://www.geeksforgeeks.org/max-heap-in-java/
https://www.geeksforgeeks.org/priority-queue-class-in-java/

