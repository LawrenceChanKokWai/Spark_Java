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

public class Reduces {
    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();
        myList.add(12.231);
        myList.add(1.54);
        myList.add(5.321);
        myList.add(40.56);

        SparkConf conf = new SparkConf()
                .setAppName("starting_spark")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Double> myRDD = sc.parallelize(myList);

        // Reduces
        Double result = myRDD.reduce(
                (valueOne, valueTwo) -> valueOne + valueTwo
                //Double::sum
        );

        System.out.println(result);

        sc.close();
    }
}