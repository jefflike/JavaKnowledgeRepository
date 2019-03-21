## 走一个mybatis的流程
1. 创建javabean
2. 数据库连接相关信息配置
3. 编写mapper接口与xml的sql查询语句
4. 编写config.xml获取数据库连接，并且将mapper与xml的sql关联
5. 创建sqlsession进行测试