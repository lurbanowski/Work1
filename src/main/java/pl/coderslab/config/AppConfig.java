package pl.coderslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.DocumentConverter;
import pl.coderslab.converter.FileConverter;
import pl.coderslab.converter.PersonConverter;
import pl.coderslab.model.Document;
import pl.coderslab.model.File;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }



    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("work1PersistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getPersonConverter());
        registry.addConverter(getDocumentConverter());
       registry.addConverter(getFileConverter());

    }
    @Bean
    public PersonConverter getPersonConverter() {return new PersonConverter();
    }
    @Bean
    public DocumentConverter getDocumentConverter() {return new DocumentConverter();
    }
    @Bean
    public FileConverter getFileConverter() {return new FileConverter();
    }


    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}