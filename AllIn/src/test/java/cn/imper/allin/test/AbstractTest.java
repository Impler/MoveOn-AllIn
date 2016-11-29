package cn.imper.allin.test;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractTest {
	
	protected ClassPathXmlApplicationContext context = null;
	
	private String configName;
	
	public AbstractTest() {
		this(null);
	}

	public AbstractTest(String configName) {
		super();
		this.configName = configName;
		this.init();
	}
	
	public void init() {
		if(StringUtils.isEmpty(this.configName)){
			this.configName = "applicationContext.xml";
		}
		context = new ClassPathXmlApplicationContext(this.configName);
	}
}
