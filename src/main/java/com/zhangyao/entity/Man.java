package com.zhangyao.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

/**
 * @author zhangyao
 *@date Jan 4, 2019
 */
@Data
@Document(indexName = "people", type = "man")//people索引相当于数据库，man类型相当于数据表
public class Man implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String country;
}
