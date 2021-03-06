package management.dao;

import management.entity.Position;

public interface PositionDao {
	
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
	int addPosition(String job);
	
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	int deletePosition(long id);

}
