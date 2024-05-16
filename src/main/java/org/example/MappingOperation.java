package org.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

/**
    *
    * @project Spark in Java Practice
    * @author chankokwai
    * @date 15/5/24
    *
   */

public class MappingOperation {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        myList.add(35);
        myList.add(12);
        myList.add(90);
        myList.add(20);

        SparkConf conf = new SparkConf()
                .setAppName("starting_spark")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> myRDD = sc.parallelize(myList);

        // RDD
        Integer result = myRDD.reduce(
                (valueOne, valueTwo) -> valueOne + valueTwo
                //Double::sum
        );
        System.out.println(result);

        // RDD_SQRT
        JavaRDD<Double> sqrtRDD = myRDD.map( value ->Math.sqrt(value) );
        sqrtRDD.foreach( value -> System.out.println(value) );

        // ++++++ Getting count ++++++++++++
        // Besides using the count() method. NOT RECOMMENDED...
        System.out.println( sqrtRDD.count() );

        // Use map and reduce
        JavaRDD<Long> singleSqrtRDD = sqrtRDD.map( value -> 1L );
        Long count = singleSqrtRDD.reduce( (value1, value2) -> value1 + value2 );
        System.out.println(count);




        sc.close();
    }
}