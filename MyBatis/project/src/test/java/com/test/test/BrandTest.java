package com.test.test;

import com.test.mapper.BrandMapper;
import com.test.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandTest {
    @Test
    public void testSelectAll() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        List<Brand> brands = brandMapper.selectAll();

        // 处理结果
        System.out.println(brands);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int id = 1;
        Brand brand = brandMapper.selectById(id);

        // 处理结果
        System.out.println(brand);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

        /*Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        // List<Brand> brands = brandMapper.selectByCondition(map);

        // 处理结果
        System.out.println(brands);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectBySingleCondition() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int status = 1;
        String companyName = "%华为%";
        String brandName = "%华为%";

        Brand brand = new Brand();
        // brand.setStatus(status);
        brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);

        List<Brand> brands = brandMapper.selectBySingleCondition(brand);

        // 处理结果
        System.out.println(brands);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int status = 1;
        String brandName = "苹果";
        String companyName = "苹果公司";
        String description = "不同凡想";
        int ordered = 50;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        brandMapper.add(brand);

        // 提交事务
        sqlSession.commit();

        // 处理结果
        System.out.println(brand);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int id = 2;
        String brandName = "小米";
        String companyName = "小米科技有限公司";
        String description = "Are You Okey?";
        int ordered = 0;
        int status = 1;

        Brand brand = new Brand();
        brand.setId(id);
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);
        // brand.setDescription(description);
        brand.setOrdered(ordered);
        // brand.setStatus(status);

        int count = brandMapper.update(brand);

        // 提交事务
        sqlSession.commit();

        // 处理结果
        System.out.println(count);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int id = 2;
        int count = brandMapper.deleteById(id);

        // 提交事务
        sqlSession.commit();

        // 处理结果
        System.out.println(count);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        // 加载MyBatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 执行sql
        int ids[] = {4, 5, 6};
        int count = brandMapper.deleteByIds(ids);

        // 提交事务
        sqlSession.commit();

        // 处理结果
        System.out.println(count);

        // 释放资源
        sqlSession.close();
    }
}
