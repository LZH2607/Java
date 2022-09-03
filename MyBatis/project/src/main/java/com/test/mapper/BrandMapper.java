package com.test.mapper;

import com.test.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    // List<Brand> selectByCondition(Brand brand);
    // List<Brand> selectByCondition(Map map);
    List<Brand> selectBySingleCondition(Brand brand);
    void add(Brand brand);
    int update(Brand brand);
    int deleteById(int id);
    int deleteByIds(@Param("ids") int ids[]);
}
