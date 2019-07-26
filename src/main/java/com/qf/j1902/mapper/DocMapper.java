package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/24 19:32
 */
@Mapper
public interface DocMapper {
    List<Doctor> getAllDoc();
    int delDocById(@Param("id")int id);
    boolean UpDocById(@Param("doctor")Doctor doctor);
}
