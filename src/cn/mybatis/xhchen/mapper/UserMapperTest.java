package cn.mybatis.xhchen.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.xhchen.entity.EncapsulationUser;
import cn.mybatis.xhchen.entity.User;
import cn.mybatis.xhchen.entity.UserQueryVo;

/**
 * 
 * ClassName: UserMapperTest
 * 
 * @Description: pojo����
 * @author XHChen
 * @date 2018��10��8�� ����11:55:20
 */
public class UserMapperTest {

	// �����Ự����
	private SqlSessionFactory sqlSessionFactory;

	@Before
	/**
	 * 
	 * @Description: ���������ļ�
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����11:56:04
	 */
	public void setUp() throws IOException {

		// ������������ļ�
		String resource = "SqlMapConfig.xml";

		// ��ú��������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự���������������ļ���
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	/**
	 * 
	 * @Description: ��������
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����12:06:01
	 */
	public void testInsertUser() throws Exception {

		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ������̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ��������
		User user = new User();

		// ��������
		user.setUsername("XHChen");
		user.setPassword("ID9527");

		// ���ö�̬������
		userMapper.insertUser(user);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: ��������
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:14:12
	 */
	public void testupdateUser() throws Exception {

		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ���²���
		User user = new User();

		user.setId(16);
		user.setUsername("XHChen_05");
		user.setPassword("ID9531");

		// ���ö�̬����ŷ�
		userMapper.updateUser(user);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: ɾ������
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:14:29
	 */
	public void testdeleteUser() throws Exception {

		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ɾ������
		// ���ô�����
		userMapper.deleteUser(17);

		// �ύ����
		sqlSession.commit();

		// �ر���Դ
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: ͨ��id��ѯ
	 * @param
	 * @return void
	 * @throws Exception
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:29:06
	 */
	public void testfindUserById() throws Exception {

		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ��ѯ����
		User user = userMapper.findUserById(16);

		System.out.println(user);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: ͨ���û���ģ����ѯ
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:33:11
	 */
	public void testfindUserByLike() throws Exception {

		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ��ѯ����
		List<User> list = userMapper.findUserByLike("XH");

		System.out.println(list);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: pojo�û�������ѯ
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:46:10
	 */
	public void testfindUserByList() throws Exception {
		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ��ѯ����

		// ����UserQueryVo����
		UserQueryVo userQueryVo = new UserQueryVo();
		// ����EncapsulationUser����
		EncapsulationUser encapsulationUser = new EncapsulationUser();

		// ���ò�ѯ����
		encapsulationUser.setPassword("ID952");
		encapsulationUser.setUsername("XHChen");

		// pojo��װuserCustom
		userQueryVo.setEncapsulationUser(encapsulationUser);

		// ���ö�̬������
		List<EncapsulationUser> list = userMapper.findUserByList(userQueryVo);

		System.out.println(list);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();
	}

	@Test
	/**
	 * 
	 * @Description: pojo�û�������ѯ����
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��8�� ����4:58:13
	 */
	public void testfindUserByCount() throws Exception {

		// ����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ��ѯ����
		// ����pojo UserQueryVo����
		UserQueryVo userQueryVo = new UserQueryVo();
		// ����EncapsulationUser��װ����
		EncapsulationUser encapsulationUser = new EncapsulationUser();

		// ���ò�ѯ����
		encapsulationUser.setPassword("ID953");
		encapsulationUser.setUsername("XHChen");

		// ����UserQueryVo��ķ���
		userQueryVo.setEncapsulationUser(encapsulationUser);

		// ���ô�����
		int count = userMapper.findUserByCount(userQueryVo);

		System.out.println(count);

		// �ύ����
		sqlSession.commit();

		// �ر�����
		sqlSession.close();

	}

}
