package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Doctorsreply;
import com.qf.j1902.vo.FamousDoctorVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Created by xiaotaozi on 2019/7/25.
 */
@Mapper
public interface FamousDoctorMapper {
    public List<FamousDoctorVo> findAll();
    public FamousDoctorVo findAllByid(Integer id);
    public Doctorsreply findAllById(Integer id);
}
