package com.zxl.conf

import java.util.Properties

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkContext, SparkConf}

/**
  * 用于创建spark程序入口，供其他程序继承
  * Created by ZXL on 2018/3/4.
  */
trait AppConf {
  val localClusterURL = "local[2]"
  val clusterMasterURL = "spark://server101:7077"
  val conf = new SparkConf().setMaster(clusterMasterURL)
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)
  val hc = new HiveContext(sc)

  //jdbc连接
  val jdbcURL = "jdbc:mysql://localhost:3306/movie?useUnicode=true&characterEncoding=utf-8"
  val alsTable = "movie.alsTab"
  val recResultTable = "movie.similarTab"
  val top5Table = "movie.top5Result"
  val userTable= "movie.user"
  val ratingTable= "movie.rating"
  val mysqlusername = "root"
  val mysqlpassword = "123456"
  val prop = new Properties
  prop.put("driver", "com.mysql.jdbc.Driver")
  prop.put("user", mysqlusername)
  prop.put("password", mysqlpassword)
}
