import com.weiyq.config.LifeCycleConfig;
import com.weiyq.service.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.junit.Test;
//import org.junit.jupiter.api.Test;

/**
 * 测试bean的生命周期
 */
public class lifecycle_test {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        Object car = context.getBean("Car");
//        context.start();
        System.out.println("容器创建完成");

        IndexService indexService = (IndexService) context.getBean("indexService");
        System.out.println("indexserver.userserver:"+indexService.getUsersService());
//        关闭容器 会销毁bean
        context.close();
    }


}
