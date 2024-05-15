package org.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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

public class Main {
    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();
        myList.add(12.231);
        myList.add(1.54);
        myList.add(5.321);
        myList.add(40.56);

        //Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("starting_spark")
                .setMaster("local[*]");
                //.set("spark.driver.bindAddress", "127.0.0.1");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Double> myRDD = sc.parallelize(myList);

        sc.close();
    }
}