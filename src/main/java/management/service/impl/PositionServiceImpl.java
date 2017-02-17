package management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import management.dao.PositionDao;
import management.entity.Position;
import management.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionDao positionDao;

	public Position queryPositionByName(String job) {
		return positionDao.queryPositionByName(job);
	}

	@Transactional
	public String addPosition(String job) {
		int result = positionDao.addPosition(job);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

	@Transactional
	public String deletePosition(long id) {
		int result = positionDao.deletePosition(id);
		if(result > 0){
			return "success";
		}else{
			return "error";
		}
	}

}
