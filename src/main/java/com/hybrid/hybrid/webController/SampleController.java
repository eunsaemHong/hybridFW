package com.hybrid.hybrid.webController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hybrid.hybrid.deviceService.SampleService;
import com.hybrid.hybrid.webCommon.CommandMap;
import com.hybrid.hybrid.webDaoImpl.SampleDAOImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;



/**
 * Handles requests for the application home page.
 */
@Controller
@Api(value="swag-rest-controller",description="swagtest")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
    private SampleService sampleservice;
	
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
	
	
	@ApiOperation(value = "조회")
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, String>>> listAny(){
	 
	    ResponseEntity<List<HashMap<String, String>>> entity = null;
	    try{
	    	entity = new ResponseEntity<>(sampleservice.listAny(), HttpStatus.OK);
	    	// entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST );
	    } catch(Exception e){
	        e.printStackTrace();
	        
	        entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST );
	    }
	 
	    return entity;
	}

	
	 @ApiOperation(value = "등록")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "key", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
	    })
	@RequestMapping(value="/boardInsert", method=RequestMethod.POST)
	public ResponseEntity<?> insertProject(@RequestParam HashMap<String, String> map) throws Exception {
		try{
			System.out.println(map.get("key"));
	        return new ResponseEntity<>(HttpStatus.OK);
	    }catch(Exception ex){
	    	
	    	
	    	
	   
	        String errorMessage;
	        errorMessage = ex + " <== error";
	        //System.exit("0");
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	/*
	 * @RequestMapping(value="/board/{bno}", method=RequestMethod.GET)
    public ResponseEntity<List<HashMap<String, String>>> listAny(@PathVariable("bno") Integer bno){
 
        ResponseEntity<List<HashMap<String, String>>> entity = null;
        try{
            entity = new ResponseEntity<>(service.listAny(bno), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
 
        return entity;
    }*/
}
