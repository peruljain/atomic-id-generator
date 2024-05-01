# Context
Developed a POC for understanding various ways for id generation

Why ID generation is required ?
We can use mysql auto increment id generator but what if we have sharded data then auto increment generator will not work correctly because
each database has their own auto_increment

# Approaches

## Approach-1
Single Application instance will generate auto_increment id

## Approach-2
In approach-1 , what if application restarted then it will again start from 0
To avoid above issue, we will save count to disk after every iteration and load count from disk during bootstrap
Vary n in the approach-2 solution to understand time taken according to n increase

## Approach-3
In approach-2 , we are saving count to disk everytime, hence it will take much more in higher throughput
To overcome approach-2, we will save to disk after every X iterations

Benchmark
Approach-2 : n = 100000 , time_taken = 5439ms
Approach-3 : n = 100000 , time_taken = 409ms

