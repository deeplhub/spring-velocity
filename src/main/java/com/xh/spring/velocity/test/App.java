package com.xh.spring.velocity.test;

import org.apache.velocity.VelocityContext;

import com.xh.spring.velocity.TemplateTool;

/**
 * <b>Title: </b>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2019年2月27日
 */
public class App {

	public static void main(String[] args) {
		String templateString = "<xml><name>$!{name}</name><age>$!{age}</age><sex>$!{sex}</sex></xml>";
		// 实例化一个VelocityContext
		VelocityContext context = new VelocityContext();
		context.put("name", "乐乐");
		context.put("age", 12);
		context.put("sex", "男");

		String xml = TemplateTool.fill(context, templateString);
		System.out.println(xml);

		String tmdir = TemplateTool.class.getResource("/template/").getPath();
		System.out.println(tmdir);
		xml = TemplateTool.fill(context, tmdir, "newFile.xml");
		System.out.println(xml);
	}

}
