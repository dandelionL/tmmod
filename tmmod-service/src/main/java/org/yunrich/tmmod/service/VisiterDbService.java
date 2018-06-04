package org.yunrich.tmmod.service;

import org.yunrich.tmmod.dal.dao.DbStatMapper;
import org.yunrich.tmmod.dal.model.DbStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisiterDbService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DbStatMapper dbStatMapper;
	
	public DbStat checkDbStat(){
		logger.info("db test service");
		return dbStatMapper.select4VisitDb();
	}
}
