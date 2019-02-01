package com.jrh.support;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseHelper {
	private static final String SUCCESS = "{\"success\":true}"; 
	private static final String ERROR = "{\"success\":false}";
	private static final String EMPTY_RESULT = "{}";
	

	public static void success(HttpServletResponse res){
		writeAsJSON(res,SUCCESS);
	}
	
	public static void fail(HttpServletResponse res){
		writeAsJSON(res,ERROR);
	}
	
	public static void empty(HttpServletResponse res){
		writeAsJSON(res,EMPTY_RESULT);
	}
	
	public static void writeAsJSON(HttpServletResponse res,Object object) {
		if (object == null) {
			writeAsJSON(res,EMPTY_RESULT);
		} else {
			writeAsJSON(res,object.toString());
		}
	}
	
	//application/json
	public static void writeAsJSON(HttpServletResponse res,String jsonString) {
		PrintWriter outer  = null;

		try {
			res.setHeader("Pragma","No-cache"); 
			res.setHeader("Cache-Control","no-cache"); 
			res.setDateHeader("Expires", 0); 
//			res.setHeader("Content-Type", "application/json; charset=UTF-8");
			res.setHeader("Content-Type", "text/html; charset=UTF-8");
			//允许ajax跨域的参数设置
			res.setHeader("Access-Control-Allow-Origin", "*");
			outer = res.getWriter();
			outer.write(jsonString);
			outer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(outer != null) outer.close();
		}
	}
	
	public static void writeAsTextHtml(HttpServletResponse res,String jsonString) {
		PrintWriter outer  = null;
		try {
			res.setHeader("Pragma","No-cache"); 
			res.setHeader("Cache-Control","no-cache"); 
			res.setDateHeader("Expires", 0); 
			res.setHeader("Content-Type", "text/html; charset=UTF-8");
			outer = res.getWriter();
			outer.write(jsonString);
			outer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(outer != null) outer.close();
		}
	}
	
/*	public static void notFound(ChannelHandlerContext ctx) {
		FullHttpResponse response = new DefaultFullHttpResponse(
				HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND, Unpooled.copiedBuffer("Can't found resource.", CharsetUtil.UTF_8));
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}*/
}
