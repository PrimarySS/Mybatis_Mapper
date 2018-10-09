package cn.mybatis.xhchen.mapper;

import java.util.List;

import cn.mybatis.xhchen.entity.EncapsulationUser;
import cn.mybatis.xhchen.entity.User;
import cn.mybatis.xhchen.entity.UserQueryVo;

/**
 * 
 * ClassName: UserMapper
 * 
 * @Description: 实现pojo的User接口
 * @author XHChen
 * @date 2018年10月8日 上午11:41:50
 */
public interface UserMapper {

	// 插入数据
	public void insertUser(User user) throws Exception;

	// 修改数据
	public void updateUser(User user) throws Exception;

	// 删除数据
	public void deleteUser(int id) throws Exception;

	// 通过id查询
	public User findUserById(int id) throws Exception;

	// 通过用户名模糊查询
	public List<User> findUserByLike(String name) throws Exception;

	// pojo用户条件查询
	public List<EncapsulationUser> findUserByList(UserQueryVo userQueryVo) throws Exception;

	// pojo用户条件查询总数
	public int findUserByCount(UserQueryVo userQueryVo) throws Exception;

}
