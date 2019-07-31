package com.qf.j1902.mapper;

import com.qf.j1902.pojo.DrugSort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/7/27.
 */
@Mapper
public interface DrugSortMapper {
    List<DrugSort> getDrugSorts();
}
