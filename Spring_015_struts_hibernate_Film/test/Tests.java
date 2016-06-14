import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;



public class Tests {
	
	//表示它是一个测试方法,
	//他如果不是main方法，不能直接运行，但是如果他是一个测试方法，可以直接运行
	@Test
	public void test() {
		//自动生成表
		//第一个bool变量表示是否显示语句,第二个是表示是否执行
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
}
