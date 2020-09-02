package com.weiyq.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * MetadataReader 读取到的当前正在扫描的类的信息
 * MetadataReaderFactory  可以获取到其他任何类的信息
 */
public class CusFilterType implements TypeFilter {
    @Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
//        获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
//        获取当前类资源，累的路径
        Resource resource = metadataReader.getResource();

//        类名
        String className = classMetadata.getClassName();
        System.out.println("classname----》" + className);

//        自定义过滤规则 只要包含er 就扫描加入到容器总
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
