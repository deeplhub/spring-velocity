package com.xh.spring.velocity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.xh.spring.velocity.model.WebLog;

/**
 * <b>Title: 日志管理</b>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2018年8月21日
 */
@Controller
public class WebLogController {

	@RequestMapping("/index")
	public String index() {

		List<WebLog> list = this.constructList();
		System.out.println(JSON.toJSONString(list));

		VelocityContext context = new VelocityContext();
		context.put("webLogList", list);
		context.put("webLogDate", new Date());
		context.put("flag", true);

		return "velocity";
	}

	private List<WebLog> constructList() {
		List<WebLog> list = new ArrayList<WebLog>();
		WebLog log = null;
		for (int i = 1; i < 10; i++) {
			log = new WebLog();
			log.setId(i);
			log.setHolderName(i + "_" + i);
			log.setCreateTime(new Date());

			list.add(log);
		}
		return list;
	}
}
