package config;

import dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
public class PropertyDrivenConfig {

    @Value("${dao.target:dao.DaoImpl}")
    private String daoClassName;

    @Bean
    public IDao dao() throws Exception {
        // Résolution par nom de classe complet
        Class<?> clazz = Class.forName(daoClassName);
        return (IDao) clazz.getDeclaredConstructor().newInstance();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}