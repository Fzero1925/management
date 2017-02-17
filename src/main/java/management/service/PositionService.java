package management.service;

import management.entity.Position;

public interface PositionService {
	
	/**
	 * 查询职位信息
	 * @param id
	 * @return
	 */
	Position queryPositionByName(String job);
	
	/**
	 * 增加职位
	 * @param positionId
	 * @param positionName
	 * @return
	 */
	String addPosition(String job);
	
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	String deletePosition(long id);

}
