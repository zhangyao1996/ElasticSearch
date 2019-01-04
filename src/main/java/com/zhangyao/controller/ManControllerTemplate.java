package com.zhangyao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangyao
 *@date Jan 4, 2019
 */
@Controller
public class ManControllerTemplate {
	
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * 查询所有
	 * @throws Exception
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<Map<String, Object>> searchAll() throws Exception {
		System.out.println("hhhhh");
		//这一步是最关键的
		Client client = elasticsearchTemplate.getClient();
		// @Document(indexName = "people", type = "man")
		SearchRequestBuilder srb = client.prepareSearch("people").setTypes("man");
		SearchResponse sr = srb.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(); // 查询所有
		SearchHits hits = sr.getHits();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (SearchHit hit : hits) {
			Map<String, Object> source = hit.getSource();
			list.add(source);
			System.out.println(hit.getSourceAsString());
		}
		return list;
	}


}
