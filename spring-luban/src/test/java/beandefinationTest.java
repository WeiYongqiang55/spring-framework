import com.luban.app.Appconfig;
import com.luban.app.CustomScanner;
import com.luban.app.LubanScan;
import com.luban.services.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class beandefinationTest {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

//		一个ConcurrentHashMap保存
//		Object singletonObject = this.singletonObjects.get(beanName);
//		private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
		applicationContext.getBean(IndexService .class);

//		扫描
		applicationContext.scan("com.luban");

//		添加一个filter

		CustomScanner customScanner = new CustomScanner(applicationContext);
		customScanner.addIncludeFilter(new AnnotationTypeFilter(LubanScan.class));
		int scan = customScanner.scan("com.luban");
		System.out.println(scan);//    1

	}

}
