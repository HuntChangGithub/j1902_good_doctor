package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.THospitalsMapper;
import com.qf.j1902.pojo.THospitals;
import com.qf.j1902.pojo.THospitalsExample;
import com.qf.j1902.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 赵国林 on 2019/7/24.
 */
@Service
public class HospitalServiceImpl implements HospitalService{
    @Autowired
    private THospitalsMapper tHospitalsMapper;
    @Override
    public List<THospitals> findAll() {
        List<THospitals> hospitalsList = tHospitalsMapper.selectByExample(new THospitalsExample());
        return hospitalsList;
    }
    @Override
    public int updateHospital(THospitals tHospital) {
        int i = tHospitalsMapper.updateByPrimaryKeySelective(tHospital);
        return i;
    }
    @Transactional
    @Override
    public boolean delHospital(List<Integer> hpid){
        THospitalsExample tHospitalsExample = new THospitalsExample();
        THospitalsExample.Criteria criteria = tHospitalsExample.createCriteria();
        criteria.andHpidIn(hpid);
        boolean b=false;
        try {
            tHospitalsMapper.deleteByExample(tHospitalsExample);
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return b;
    }

    @Override
    public int  addHospital(THospitals hospital) {
        int i = tHospitalsMapper.insertSelective(hospital);
        return i;
    }
}
