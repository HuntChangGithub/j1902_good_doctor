package com.qf.j1902.mapper;

import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.pojo.Drugwu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/7/27.
 */
@Mapper
public interface DrugwuMapper {
     List<Drugwu> getDrugwusBySortID(Integer sortID);
     List<ConcreteDrug> getConcreteDrugByDrugwuID(Integer drugwuID);
     Drugwu getDrugwuByDrugwuID(Integer drugwuID);
}
