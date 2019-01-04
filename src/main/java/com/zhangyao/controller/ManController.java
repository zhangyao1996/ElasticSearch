package com.zhangyao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyao.entity.Man;
import com.zhangyao.mapper.ManDao;

/**
 * @author zhangyao
 *@date Jan 4, 2019
 */
@Controller
public class ManController {
	@Autowired
	private ManDao manDao;
	
	/**
	 * 1、查  id
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	@ResponseBody
	public Optional<Man> getBookById(@PathVariable String id) {
		return manDao.findById(id);
	}
}
