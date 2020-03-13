package second;
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.*;  
  
public class Test1 {  
    public static void main(String[] args) {  
          
        Resource r=new ClassPathResource("applicationTwo.xml");  
        BeanFactory factory=new XmlBeanFactory(r);  
          
        Employee1 s=(Employee1)factory.getBean("e");  
        s.show();  
          
    }  
}  
