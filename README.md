# Mybatis_Mapper
mybatis动态代理实现数据库的增改删查功能和pojo包装类映射

开发规范：

1、在mapper.xml中namespace等于mapper接口地址

2、mapper.java接口中的方法名和mapper.xml中statement的id一致

3、mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致

4、mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致

针对复杂查询的条件，建议使用自定义的包装类型的pojo
在包装类型的pojo中讲复杂的查询条件包装进去

注意：
不管是输出的pojo单个对象还是一个列表（list中包括pojo），在mapper.xml中resultType指定的类型是一样的。
在mapper.java指定的方法返回值不一样：
1、输入单个pojo对象，方法返回是单个对象
2输入pojo对象是list，方法返回是List<Pojo>

