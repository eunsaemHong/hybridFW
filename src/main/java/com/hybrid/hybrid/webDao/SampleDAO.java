package com.hybrid.hybrid.webDao;

import java.util.HashMap;
import java.util.List;

import com.hybrid.hybrid.webCommon.hybridServiceDTO;

public interface SampleDAO {
	 public List<HashMap<String, String>> listAny() throws Exception;

	 public List<hybridServiceDTO> serviceList() throws Exception;
	 
}
