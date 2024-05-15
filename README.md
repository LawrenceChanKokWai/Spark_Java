# RDD - Reduces

### Testing Spark
1. A list is created with hard-coded data(s) and add some data into the list.
<br>
```
List<Double> myList = new ArrayList<>();
myList.add(12.134);
.......
.......
N(times)
```

2. Spark Configuration, making connection to 
Spark Cluster and close connection.
```
SparkConf conf = new SparkConf();
JavaSparkContext sc = new JavaSparkContext(conf);

sc.close();
```
3. Load the collection of data and turning it into a RDD.
Initialize it to myRDD.
```
JavaRDD myRdd = sc.parallelize(myList);
```

