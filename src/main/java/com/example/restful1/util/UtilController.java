package com.example.restful1.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/util")
public class UtilController {

	@GetMapping(value = "/sid")
	public Map<String, String> getSession(HttpServletRequest request, HttpServletResponse response) {

		HttpSession httpSession = request.getSession();
		String sid = httpSession.getId();
		String ip = request.getRemoteAddr();
		String sha256hex = DigestUtils.sha256Hex(String.format("%s-%s", ip, sid));
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("IP", ip);
		hm.put("SID", sid);
		hm.put("HASH", StringUtils.upperCase(sha256hex));
		
		return hm;
	}
}
