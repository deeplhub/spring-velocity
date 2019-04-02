package com.xh.spring.velocity;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * <b>Title: </b>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2019年2月27日
 */
public class TemplateTool {

	private static Map<String, Template> templateMap = new HashMap<String, Template>();

	public static String fill(VelocityContext context, String tmdir, String tmFile) {
		String result = "";
		Template t = null;
		StringWriter writer = new StringWriter();
		try {
			if (!templateMap.containsKey(tmFile)) {
				Properties p = new Properties();
				p.setProperty("file.resource.loader.path", tmdir);
				VelocityEngine ve = new VelocityEngine();
				ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogChute");
				ve.init(p);
				t = ve.getTemplate(tmFile);
				templateMap.put(tmFile, t);
			} else {
				t = templateMap.get(tmFile);
			}
			System.out.println("=============================================================");
			System.out.println("templateMap.size():" + templateMap.size());

			t.merge(context, writer);
			result = writer.toString();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String fill(VelocityContext context, String tmdir, String tmFile, String inputEncode, String ouputEncode) {
		String result = "";
		Template t = null;
		StringWriter writer = new StringWriter();
		try {
			if (!templateMap.containsKey(tmFile)) {
				Properties p = new Properties();
				p.setProperty("file.resource.loader.path", tmdir);
				p.setProperty("ISO-8859-1", "UTF-8");
				p.setProperty("input.encoding", inputEncode);
				p.setProperty("output.encoding", ouputEncode);
				VelocityEngine ve = new VelocityEngine();
				ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogChute");
				ve.init(p);
				t = ve.getTemplate(tmFile);
				templateMap.put(tmFile, t);
			} else {
				t = templateMap.get(tmFile);
			}

			System.out.println("=============================================================");
			System.out.println("templateMap.size():" + templateMap.size());
			t.merge(context, writer);
			result = writer.toString();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String fill(VelocityContext context, String templateString) {
		String result = "";
		StringWriter writer = null;
		try {
			VelocityEngine ve = new VelocityEngine();
			ve.init();
			writer = new StringWriter();
			StringReader reader = new StringReader(templateString);
			ve.evaluate(context, writer, "temp", reader);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String test(int i) {
		return "array:" + i;
	}

	public static void main(String[] args) {
		String tmdir = TemplateTool.class.getResource("/template/").getPath();

		String inputEncode = "GBK";
		String ouputEncode = "GBK";
		String result = "";
		try {
			// // 初始化模板引擎
			// Properties p = new Properties();
			// // 配置引擎上下文对象
			// VelocityContext context = new VelocityContext();
			// // 加载模板文件
			// // context.put("selects", "");
			// p.setProperty("file.resource.loader.path", path);
			// p.setProperty("ISO-8859-1", "UTF-8");
			// p.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
			// p.setProperty(Velocity.INPUT_ENCODING, inputEncode);
			// p.setProperty(Velocity.OUTPUT_ENCODING, ouputEncode);
			// VelocityEngine ve = new VelocityEngine();
			// ve.setProperty("runtime.log.logsystem.class","org.apache.velocity.runtime.log.NullLogChute");
			// ve.init(p);
			// Template t = ve.getTemplate("test_velocity.xml");
			// for (int i = 0; i < 3; i++) {
			// System.out.println("===================== "+(i+1)+" =====================");
			// // 加载模板文件
			//
			// StringWriter writer = new StringWriter();
			// t.merge(context, writer);
			// result = writer.toString();
			// writer.close();
			// System.out.print(result.toString());
			// }

			for (int i = 0; i < 3; i++) {
				VelocityContext context = new VelocityContext();
				context.put("DLBH", "实得分是否是放松放松" + (i * 100));
				System.out.println(TemplateTool.fill(context, tmdir, "test_velocity.xml", inputEncode, ouputEncode));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
