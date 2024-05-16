# Mapping Operations

### Operation
When RDD is created, the values are immutable. As such,
a new RDD_SQRT is created in holding the mapped values
```mermaid
classDiagram
    direction LR
    RDD --|> sqrtValue
    sqrtValue --|> RDD_SQRT

    class RDD {
        double 35
        double 12
        double 90
        double 20
    }
    class sqrtValue {
        sqrt(value)
    }
    class RDD_SQRT {
        double 5.916
        double 3.464
        double 9.486
        double 4.472
    }
```

### Syntax
```
JavaRDD<Double> sqrtRDD = myRDD.map( 
    value -> Math.sqrt(value) 
);
```

### Outputting the result
The common way is to write the data into a file.
It could write it to a file system like HDFS, and be distributed
across multiple nodes in a cluster.
For testing purposes, we just just a foreach method.
```
sqrtRDD.foreach(
    value -> System.out.println( value )
);
```

