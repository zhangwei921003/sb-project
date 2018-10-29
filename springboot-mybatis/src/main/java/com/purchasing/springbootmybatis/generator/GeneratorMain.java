package com.purchasing.springbootmybatis.generator;

import com.purchasing.springbootmybatis.generator.entity.TMember;
import com.purchasing.springbootmybatis.generator.entity.TUser;
import com.purchasing.springbootmybatis.generator.mapper.TMemberMapper;
import com.purchasing.springbootmybatis.generator.mapper.TUserMapper;
import com.purchasing.springbootmybatis.util.MyMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author zhangwei
 * @createTime 2018/10/28
 */
public class GeneratorMain {

    public static void main(String[] args) throws UnsupportedEncodingException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "development", new Properties());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUser user = mapper.selectByPrimaryKey(1);

        System.out.println(user);

        //Java 编码方式集成Mapper用法 参考https://github.com/abel533/Mapper/wiki
        //创建一个MapperHelper
        MapperHelper mapperHelper = new MapperHelper();
        //特殊配置
        Config config = new Config();
        //主键自增回写方法,默认值MYSQL,详细说明请看文档
        config.setIDENTITY("MYSQL");
        //支持getter和setter方法上的注解
        config.setEnableMethodAnnotation(true);
        //设置 insert 和 update 中，是否判断字符串类型!=''
        config.setNotEmpty(true);
        //校验Example中的类型和最终调用时Mapper的泛型是否一致
        config.setCheckExampleEntityClass(true);
        //启用简单类型
        config.setUseSimpleType(true);
        //设置配置
        mapperHelper.setConfig(config);
        //注册通用接口，和其他集成方式中的 mappers 参数作用相同
        //4.0 之后的版本，如果类似 Mapper.class 这样的基础接口带有 @RegisterMapper 注解，就不必在这里注册
        mapperHelper.registerMapper(MyMapper.class);
        //配置 mapperHelper 后，执行下面的操作
        mapperHelper.processConfiguration(sqlSession.getConfiguration());

        TMemberMapper tMemberMapper = sqlSession.getMapper(TMemberMapper.class);

        TMember member = tMemberMapper.selectByPrimaryKey(28);

        System.out.println(member);

        sqlSession.close();

    }
}
