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
 * @Description: pojo测试
 * @author XHChen
 * @date 2018年10月8日 上午11:55:20
 */
public class UserMapperTest {

	// 创建会话工厂
	private SqlSessionFactory sqlSessionFactory;

	@Before
	/**
	 * 
	 * @Description: 加载配置文件
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 上午11:56:04
	 */
	public void setUp() throws IOException {

		// 定义核心配置文件
		String resource = "SqlMapConfig.xml";

		// 获得核心配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，加载配置文件流
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	/**
	 * 
	 * @Description: 插入数据
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午12:06:01
	 */
	public void testInsertUser() throws Exception {

		// 开启SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 创建对象
		User user = new User();

		// 插入数据
		user.setUsername("XHChen");
		user.setPassword("ID9527");

		// 调用动态代理方法
		userMapper.insertUser(user);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: 更新数据
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:14:12
	 */
	public void testupdateUser() throws Exception {

		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 更新操作
		User user = new User();

		user.setId(16);
		user.setUsername("XHChen_05");
		user.setPassword("ID9531");

		// 调用动态代理放法
		userMapper.updateUser(user);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: 删除数据
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:14:29
	 */
	public void testdeleteUser() throws Exception {

		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 删除操作
		// 调用代理方法
		userMapper.deleteUser(17);

		// 提交事务
		sqlSession.commit();

		// 关闭资源
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: 通过id查询
	 * @param
	 * @return void
	 * @throws Exception
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:29:06
	 */
	public void testfindUserById() throws Exception {

		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 查询操作
		User user = userMapper.findUserById(16);

		System.out.println(user);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: 通过用户名模糊查询
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:33:11
	 */
	public void testfindUserByLike() throws Exception {

		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 查询操作
		List<User> list = userMapper.findUserByLike("XH");

		System.out.println(list);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();

	}

	@Test
	/**
	 * 
	 * @Description: pojo用户条件查询
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:46:10
	 */
	public void testfindUserByList() throws Exception {
		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 查询操作

		// 创建UserQueryVo对象
		UserQueryVo userQueryVo = new UserQueryVo();
		// 创建EncapsulationUser对象
		EncapsulationUser encapsulationUser = new EncapsulationUser();

		// 设置查询条件
		encapsulationUser.setPassword("ID952");
		encapsulationUser.setUsername("XHChen");

		// pojo封装userCustom
		userQueryVo.setEncapsulationUser(encapsulationUser);

		// 调用动态代理方法
		List<EncapsulationUser> list = userMapper.findUserByList(userQueryVo);

		System.out.println(list);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();
	}

	@Test
	/**
	 * 
	 * @Description: pojo用户条件查询总数
	 * @param    
	 * @return void  
	 * @throws
	 * @author XHChen
	 * @date 2018年10月8日 下午4:58:13
	 */
	public void testfindUserByCount() throws Exception {

		// 开启sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 开启代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 查询操作
		// 创建pojo UserQueryVo对象
		UserQueryVo userQueryVo = new UserQueryVo();
		// 创建EncapsulationUser封装对象
		EncapsulationUser encapsulationUser = new EncapsulationUser();

		// 设置查询条件
		encapsulationUser.setPassword("ID953");
		encapsulationUser.setUsername("XHChen");

		// 调用UserQueryVo里的方法
		userQueryVo.setEncapsulationUser(encapsulationUser);

		// 调用代理方法
		int count = userMapper.findUserByCount(userQueryVo);

		System.out.println(count);

		// 提交事务
		sqlSession.commit();

		// 关闭事务
		sqlSession.close();

	}

}
