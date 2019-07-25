package com.qf.j1902.mapper;

import com.qf.j1902.vo.DocDealInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther mengyuan
 * @desc
 * @date 2019/7/25 10:51
 */
@Mapper
public interface DocDealMapper {
    List<DocDealInfo> getAllDocDealInfo();
}
