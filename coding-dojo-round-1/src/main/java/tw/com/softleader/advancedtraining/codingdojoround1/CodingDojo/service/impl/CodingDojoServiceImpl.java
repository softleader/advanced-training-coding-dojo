package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao.CodingDojoDao;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import java.util.List;

@Service
@Transactional
public class CodingDojoServiceImpl implements CodingDojoService {
	
	@Autowired
	private CodingDojoDao dao;

	public CodingDojoDao getDao() {
		return dao;
	}
	
	public CodingDojo save(CodingDojo codingDojo) {
		
		return dao.save(codingDojo);
	}

	public List<CodingDojo> queryAll(){

		return dao.findAll();
	}

}
