package com.weiyq.impotor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


//自定义逻辑  返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    /**
     * Select and return the names of which class(es) should be imported based on
     * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
     *返回值就是需要导入到容器中的全类名
     * @param importingClassMetadata 当前标注@Import 注解的类的所有注解信息
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.weiyq.entity.Blue","com.weiyq.entity.Green"};
    }
}
