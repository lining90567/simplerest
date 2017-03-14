轻量级的RESTful - SimpleREST
===================

SimpleREST是用guice、resteasy、mybatis、undertow实现的轻量级restful服务。

 - IoC容器使用Google Guice，和Spring相比，其更轻量，性能上号称比Spring快十倍左右。
 - RESTful Web Services框架基于RESTEasy，其是 JAX-RS 规范的一个完整实现并通过 JCP 认证。
 - 持久化框架基于MyBatis，简单灵活，对SQL可控。
 - 使用Undertow作为嵌入式的Web容器，方便部署。

----------

启动SimpleREST
-------------

**启动MySQL并执行脚本：**
脚本文件在script文件夹下。

**在开发工具（以Eclipse为例）中启动：**
 1. 导入到Eclipse
 2. 设置配置文件：src/main/resources/conf/simplerest.properties，相关设置项请参考文件中的注释设置。
 3. 在启动配置中，添加启动参数：-f 盘符:\simplerest\src\main\resources\conf\simplerest.properties
 4. 启动程序
 5. 打开浏览器，输入地址：http://localhost:8888/goods/，检查是否可以返回数据，如果不能返回数据，请查看输出日志获取错误原因。

> **Eclipse中启动参数的设置:**

> - 鼠标右键点击项目simplerest，选择Run As->Run Configurations...
> - 点击右侧的Arguments页签
> - 在Program arguments中输入：-f 盘符:\simplerest\src\main\resources\conf\simplerest.properties
> - 点击Apply

----------

**打包**
执行 mvn package，成功后会在项目的target文件下生成 simplerest-1.0.0.zip，解压后执行bin\run.bat（linux下执行run.sh）即可运行服务。

----------

**相关RESTful API**

以货品（goods）为例，主机名：localhost，端口为默认的8888

 - 获取全部货品（Method：GET）

 
 http://localhost:8888/goods/
	 

 - 分页查询货品（Method：GET）

 
 http://localhost:8888/goods/listPaged?pageIndex=1&pageSize=2
	 

 - 得到指定Id的货品（Method：GET）

 
 http://localhost:8888/goods/223c9e36055811e7b74a00155d010e04
	

 - 添加货品（Method：POST）

 
 http://localhost:8888/goods/
 
 http body（application/json）
 
 {
 
 "name": "固态硬盘"
 
 }
	

 - 修改货品（Method：POST）

 
 http://localhost:8888/goods/223c9e36055811e7b74a00155d010e04
 
 http body（application/json）
 
 {
 
 	"name": "奥迪轿车"
 	
 }
	 

 - 删除货品（Method：DELETE）

 
 http://localhost:8888/goods/223c9e36055811e7b74a00155d010e04

----------
	 
> **调试工具**

> - 建议使用Chrome浏览器，安装Postman插件。

----------

**开发步骤：**

 1. 在model包中创建模型类，如Student.java。
 2. 在src/main/resources/com/ln/simplerest/mapper下创建mapper.xml，如StudentMapper.xml，并在xml文件中定义CURD方法。
 3. 在mapper包中定义mapper类，如StudentMapper.java。
 4. 在dao包中定义dao接口，如StudentDao.java
 5. 在dao.impl包中实现dao接口，如StudentMapperDaoImpl.java，注意设置为@Singleton单例模式。
 6. 在service包中定义service接口，如StudentService.java。
 7. 在service.impl包中实现service接口，如StudentServiceImp.java，注意设置为@Singleton单例模式。
 8. 在resource包下定义资源文件，如StudentResource.java，注意继承AbstractResource类并将其设置为@Singleton单例模式。
 9. 在support.guice包的AppModule.java中绑定dao和service类。
 10. 在support.undertow包的ApplicationClass.java中注册资源类（StudentResource.java）。

----------

**作者信息**

博客：[http://blog.csdn.net/hyxhbj1](http://blog.csdn.net/hyxhbj1)

邮箱：lining90567@sina.com