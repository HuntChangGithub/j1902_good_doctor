package com.qf.j1902.service;

import com.qf.j1902.pojo.ConcreteDrug;
import com.qf.j1902.pojo.Drugwu;

import java.util.List;

/**
 * Created by Administrator on 2019/7/27.
 */
public interface DrugwuService {
    public List<Drugwu> getDrugwusBySortID(Integer sortID);
    Drugwu getDrugwuByDrugwuID(Integer drugwuID);
    List<ConcreteDrug> getConcreteDrugByDrugwuID(Integer drugwuID);
}
