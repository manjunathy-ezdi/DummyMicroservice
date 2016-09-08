package com.ezdi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/*@SpringBootApplication
public class Dummy2Microservice extends SpringBootServletInitializer{
*/	
	
@SpringBootApplication
public class Dummy2Microservice{
	private static final Logger LOGGER = Logger.getLogger(Dummy2Microservice.class);
	public static void main(String[] args) throws Exception{
		LOGGER.info("Inside #$#UserDetailsMgmtApplication:main()");
		ApplicationContext applicationContext = SpringApplication.run(Dummy2Microservice.class, args);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("The beans configured (automatically by spring-boot!!) are: ");
        if(beanNames != null){
            System.out.println("NUMBER : "+beanNames.length);
            Arrays.sort(beanNames);
            for(String each: beanNames){
                System.out.println(each);
            }
        }
        else{
            System.out.println("beanNames is NULL");
        }
        //test(applicationContext);
		LOGGER.info("Exiting #$#UserDetailsMgmtApplication:main()");
	}
	
	/*private static void test(ApplicationContext applicationContext) throws Exception{
		JedisConnectionFactory fac = applicationContext.getBean(JedisConnectionFactory.class);
		System.out.println("JEDIS FACTORY: hostname: "+fac.getHostName()+" ;; port: "+fac.getPort());
		String cacFilesPathStr = System.getenv("cacfilespath");
		if (cacFilesPathStr.contains("file:///")) {
			cacFilesPathStr = cacFilesPathStr.substring("file://".length(), cacFilesPathStr.length());
		}
		FileInputStream fileInputStream =  new FileInputStream(new File(cacFilesPathStr+"/application.properties"));
		Properties properties = new Properties();
		properties.load(fileInputStream);
		fileInputStream =  new FileInputStream(new File(cacFilesPathStr+"/redis.properties"));
		properties.load(fileInputStream);
		System.out.println(properties.getProperty("redis.hostname"));
	}*/
}
