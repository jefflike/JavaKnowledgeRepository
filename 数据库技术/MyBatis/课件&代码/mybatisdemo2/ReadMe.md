## 注意项
1. xml的namespace指向mapper的全类名，将mapper接口和xml关联起来
2. sqlsession是线程不安全的，所以千万不要提取出来做成成员变量
3. properties读类路径下的文件的数据，可以用做数据库连接，一般不用
4. environments配置环境，一般就是连接池，数据库连接等，一般也不用，可以切换运行或者测试等环境
5. settings配置缓存，懒加载，延迟加载，驼峰映射等很多设置
6. resultType返回结果的封装类型
7. useGeneratedKeys获取到插入数据库时的数据的自增id
8. 多个参数最好是使用@Param注解。


