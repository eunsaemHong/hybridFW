package com.hybrid.hybrid.deviceServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hybrid.hybrid.deviceService.SampleService;
import com.hybrid.hybrid.webCommon.hybridServiceDTO;
import com.hybrid.hybrid.webDao.SampleDAO;

@Service
public class SampleServiceImpl implements SampleService{

	@Inject
	private SampleDAO sampledao;
	@Override
	public List<HashMap<String, String>> listAny() throws Exception {
		// TODO Auto-generated method stub
		return sampledao.listAny();
	}
	@Override
	public List<hybridServiceDTO> serviceList() throws Exception {
		// TODO Auto-generated method stub
		return sampledao.serviceList();
	}

}
