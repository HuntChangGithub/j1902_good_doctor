package com.qf.j1902.service;

import com.qf.j1902.pojo.ConcreteDrug;

import java.util.List;

/**
 * Created by Administrator on 2019/7/29.
 */
public interface ConcreteDrugService {
    public ConcreteDrug getConcreteDrug(Integer concreteDrugID);

    List<ConcreteDrug> getConcreteDrugsAll();

    List<ConcreteDrug> getConcreteDrugsByKeywords(String keywords);
}
