import com.weiyq.config.MainConfig;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;


/**
 * 动态代理测试
 */
public class DepencyTest {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

//		mianconfig类，不加@Configuration注解 就是原本的MainConfig类，com.weiyq.config.MainConfig@932bc4a
//		加了@Configuration注解 之后就是代理类了 com.weiyq.config.MainConfig$$EnhancerBySpringCGLIB$$1de07f1d@7db12bb6
		MainConfig bean = applicationContext.getBean(MainConfig.class);
		System.out.println(bean);

		DataSource dataSource = null;
		TransactionFactory transactionFactory =
				new JdbcTransactionFactory();
		Environment environment =
				new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(MainConfig.class);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(configuration);


	}


}
