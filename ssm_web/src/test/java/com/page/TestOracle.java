package com.page;

import com.page.ssm.dao.ProductDao;
import com.page.ssm.domain.Product;
import com.page.ssm.service.ProductService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class TestOracle {

      @Test
      public void Test1(){
          Connection con = null;// 创建一个数据库连接
          PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
          ResultSet result = null;// 创建一个结果集对象
          try
          {
              Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
              System.out.println("开始尝试连接数据库！");
              String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
              String user = "ssm";// 用户名,系统默认的账户名
              String password = "123456";// 你安装时选设置的密码
              con = DriverManager.getConnection(url, user, password);// 获取连接
              System.out.println("连接成功！");
              String sql = "select * from product";// 预编译语句，“？”代表参数
              pre = con.prepareStatement(sql);// 实例化预编译语句
             // pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
              Product product = new Product();
              result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
              while (result.next())
                  // 当结果集不为空时
                  System.out.println("状态:" + result.getString("productStatus") +"\t\t\t"+ "出发时间:"
                          + result.getString("departureTime")+"\t\t\t\t"+"产品名称："+result.getString("productName"));
          }
          catch (Exception e)
          {
              e.printStackTrace();
          }
          finally
          {
              try
              {
                  // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                  // 注意关闭的顺序，最后使用的最先关闭
                  if (result != null)
                      result.close();
                  if (pre != null)
                      pre.close();
                  if (con != null)
                      con.close();
                  System.out.println("数据库连接已关闭！");
              }
              catch (Exception e)
              {
                  e.printStackTrace();
              }
          }
      }

    @Test
    public void  run() throws Exception {
          //只能读取Mybatis文件，不然会报错
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        ProductDao productDao =sqlSession.getMapper(ProductDao.class);
        List<Product> list = productDao.findAll();
        for(Product product:list){
            System.out.println(product);
        }
        //关闭资源
        sqlSession.close();
        inputStream.close();

    }

    public  void  TestSpring() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = context.getBean("productService", ProductService.class);
        List<Product> list = productService.findAll();
        for(Product product:list){
            System.out.println(product);
        }
    }

    @Test
    public void  run2() throws Exception {
        //只能读取Mybatis文件，不然会报错
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        System.out.println("读取Mybatis配置文件成功");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        ProductDao productDao =sqlSession.getMapper(ProductDao.class);
        Product product = new Product();
        product.setCityName("深圳");
        product.setProductDesc("实惠");
        product.setProductName("香港七日游");
        product.setProductPrice(2500.0);
        product.setProductStatus(0);
        product.setProductNum("itcast-004");
        productDao.saveProduct(product);
        System.out.println("插入产品数据成功.................");
        //关闭资源
        sqlSession.close();
        inputStream.close();

    }

}
