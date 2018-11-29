package com.hybrid.hybrid.webDaoImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hybrid.hybrid.webDao.SampleDAO;

@Repository
public class SampleDAOImpl implements SampleDAO{
	
	@Inject
    private SqlSession session;
	
	
	private static String namespace = "sample";


	@Override
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> listAny() throws Exception {
		// TODO Auto-generated method stub
		 return session.selectList(namespace+".listAny");
	}

}
