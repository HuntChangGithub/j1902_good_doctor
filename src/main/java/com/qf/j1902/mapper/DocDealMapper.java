package com.qf.j1902.mapper;

import com.qf.j1902.vo.DocDealInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:51
 */
@Mapper
public interface DocDealMapper {

    //得到所有医生审核信息
    List<DocDealInfo> getAllDocDealInfo();
    //通过审核操作
    int passto(@RequestParam("id") int id);
    //冻结该医生
    int sealDoc(@RequestParam("id") int id);
}
