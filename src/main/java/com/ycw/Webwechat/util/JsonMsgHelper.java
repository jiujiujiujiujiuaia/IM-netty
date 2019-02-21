package com.ycw.Webwechat.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class JsonMsgHelper {

	private static final ObjectMapper JSONMAPPER = new ObjectMapper();

	public static void writeJson(HttpServletResponse response, Object pojo, HttpStatus status)
			throws JsonGenerationException, JsonMappingException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(status.value());
		writeJson(response.getWriter(), pojo);
	}

	public static void writeJson(Writer writer, Object pojo)
			throws JsonGenerationException, JsonMappingException, IOException {
		JSONMAPPER.writeValue(writer, pojo);
	}
}
