package com.zhangyao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhangyao.entity.Man;

/**
 * @author zhangyao
 *@date Jan 4, 2019
 */
@Mapper
public interface ManDao extends ElasticsearchRepository<Man, String>{

}
