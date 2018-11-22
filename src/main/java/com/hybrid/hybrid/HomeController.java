package com.hybrid.hybrid;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/getList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<String> getData() {
		List<String> result = new ArrayList<>();
		result.add("first");
		result.add("second");
		result.add("third");
		return result;
	}

	@RequestMapping(value = "/getMap", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, String> getMap() {
		Map<String, String> result = new HashMap<>();
		result.put("first", "firstValue");
		result.put("second", "secondValue");
		result.put("third", "thirdValue");
		return result;
	}

	@RequestMapping(value = "/getString", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getString() {
		return "stringValue";
	}
}
