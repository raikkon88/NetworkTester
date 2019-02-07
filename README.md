# Network Tester 

## Description

Using this program you will be able to send amounts of requests in a network from a unique computer. Not only network requests even you can execute same command in prallel n times where n is a number given for you as parameter. 

## Requirements

**You need a Linux machine to execute this program**

This software is prepared to send : 

- http requests
- arp requests

This software is prepared to execute any instruction in paral·lel n times. 

## Usage 

    java -jar networkTester <type> -m <int> [-I -d <seconds> -i <increment>]

Where : 

To do http requests.  
    
    java -jar networkTester http <host> -n <int>
    
To do arping requests.

    java -jar networkTester arping <host> <mac> -n <int>  
 
To do any terminal command. 
    
    java -jar networkTester executable -n <int> [-I -d <seconds> -i <increment>] "<instruction>"

## Functionalities

You are able to execute the parallel instruction in two ways. 

### Simultaneous 

Means -n parameter stands for the maximum number of processes that you will generate and the program will start all together.

### Incremental
 
Means groups of processes will be generated and thrown with a delay in seconds between each one and with a incremental value. 

- -d : <int> stands for the delay between each group of processes in milliseconds. 
- -i : <int> stands for the incremental number

For instance. 

In case you put the parameters -n 1000 -I -d 1000 -i 10 the result will be : 

    10 processes 
    20 processes 
    30 processes 
    .
    .
    .
    100 processes. 
    
You will throw a total number of 550 processes. 

## Output 

The program will print the same output that will be thrown from command line, it means that you can redirect this output to files. 

## License 

Feel free to use this software and to redistribute it as you expect. If you wants to participate with it please use fork action to clone it in your wokrspace and make a pull request to includde your changes. 

 


