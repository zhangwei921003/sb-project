package com.purchasing.springbootmybatis.xml;

import com.purchasing.springbootmybatis.xml.entity.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 * @author zhangwei
 * @createTime 2018/10/27
 */
public class XmlConfigurationMain {

    public static void main(String[] args) throws IOException {

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("mybatis/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader,"development");

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Member member = sqlSession.selectOne("com.purchasing.springbootmybatis.xml.MemberMapper.selectById",28);

        System.out.println(member);

        sqlSession.close();
    }
}
