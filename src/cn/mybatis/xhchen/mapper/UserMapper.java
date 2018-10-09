package cn.mybatis.xhchen.mapper;

import java.util.List;

import cn.mybatis.xhchen.entity.EncapsulationUser;
import cn.mybatis.xhchen.entity.User;
import cn.mybatis.xhchen.entity.UserQueryVo;

/**
 * 
 * ClassName: UserMapper
 * 
 * @Description: ʵ��pojo��User�ӿ�
 * @author XHChen
 * @date 2018��10��8�� ����11:41:50
 */
public interface UserMapper {

	// ��������
	public void insertUser(User user) throws Exception;

	// �޸�����
	public void updateUser(User user) throws Exception;

	// ɾ������
	public void deleteUser(int id) throws Exception;

	// ͨ��id��ѯ
	public User findUserById(int id) throws Exception;

	// ͨ���û���ģ����ѯ
	public List<User> findUserByLike(String name) throws Exception;

	// pojo�û�������ѯ
	public List<EncapsulationUser> findUserByList(UserQueryVo userQueryVo) throws Exception;

	// pojo�û�������ѯ����
	public int findUserByCount(UserQueryVo userQueryVo) throws Exception;

}
