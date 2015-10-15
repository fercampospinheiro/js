package br.com.js.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "br.com.js")
public class AppWebConfiguration extends WebMvcConfigurerAdapter
{

   @Bean
   public InternalResourceViewResolver  internalResourceViewResolver(){
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/views/");
       resolver.setSuffix(".jsp");
       return resolver;
   }
   
    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setJavaMailProperties(getPropertiesMail());
        return javaMailSender;
    }
    
    private Properties getPropertiesMail(){
        FileInputStream file = null;
       try {
           Properties prop = new Properties();
           file = new FileInputStream("./resources/application.properties");
           prop.load(file);
           return prop;
       } catch (FileNotFoundException ex) {
           Logger.getLogger(AppWebConfiguration.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(AppWebConfiguration.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           try {
               file.close();
           } catch (IOException ex) {
               Logger.getLogger(AppWebConfiguration.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return null;
    }

}
