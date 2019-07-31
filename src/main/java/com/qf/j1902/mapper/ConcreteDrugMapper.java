package com.qf.j1902.mapper;

import com.qf.j1902.pojo.ConcreteDrug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
@Mapper
public interface ConcreteDrugMapper {
    ConcreteDrug getConcreteDrug(Integer concreteDrugID);
    List<ConcreteDrug> getConcreteDrugsAll();
    List<ConcreteDrug> getConcreteDrugsByKeywords(String keywords);
}
