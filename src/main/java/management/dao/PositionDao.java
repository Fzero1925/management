package management.dao;

public interface PositionDao {
	
	/**
	 * 增加职位
	 * @param positionId
	 * @param positionName
	 * @return
	 */
	int addPosition(int id, String name);
	
	/**
	 * 删除职位
	 * @param positionId
	 * @return
	 */
	int deletePosition(int id);

}
