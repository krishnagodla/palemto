package jdbc;

import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
  
public class Test {  
public static void main(String[] args) {  
    Resource r=new ClassPathResource("applicationJdbc.xml");  
    BeanFactory factory=new XmlBeanFactory(r);
    Employee obj=new Employee();
    Employee q=(Employee)factory.getBean("obj");  
    q.results();      
}  
}  

