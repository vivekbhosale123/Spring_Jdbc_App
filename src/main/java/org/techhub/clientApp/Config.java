package org.techhub.clientApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages ={"org.techhub.service","org.techhub.repository"})
public class Config {
     
	@Bean(name="data")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.cj.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/practice");
		d.setUsername("root");
		d.setPassword("Aai@8530");
		return d;
	}
	@Bean(name="template")
	public JdbcTemplate getTemplate()
	{
		return new JdbcTemplate(getDataSource());
	}
}
