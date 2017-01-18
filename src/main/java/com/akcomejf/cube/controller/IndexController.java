package com.akcomejf.cube.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akcomejf.cube.utils.VmTemplateHelper;
import com.akcomejf.uranus.service.DimApiService;

@Controller
public class IndexController {

	@Autowired
	private VmTemplateHelper vmTemplateHelper;

	@Autowired
	private DimApiService dimService;

	@RequestMapping("/js/dim.js")
	public String dimjs(HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodes", dimService.getNodeAll());
		String result = vmTemplateHelper.mergeTemplateIntoString("dim_node.vm", map);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/javascript;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		return null;
	}

	@RequestMapping(value = { "/", "/{[a-z]+}" })
	public String toIndex() {
		return "redirect:/regData/regChart.html";
	}

	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) {

		boolean isAjax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
		if (isAjax) {
			resp.setStatus(401);
		}
		return "/login";
	}

	@RequestMapping("/404")
	public String error404() {
		return "error-404";
	}

	@RequestMapping("/500")
	public String error500() {
		return "error-500";
	}

	@RequestMapping("/403")
	public String error403() {
		return "error-403";
	}
}
