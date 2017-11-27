package cz.expertkom.ju.L07HomeWorkProduts;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import cz.expertkom.ju.L07HomeWorkProduts.Api.ApplicationApi;
import cz.expertkom.ju.L07HomeWorkProduts.Api.Impl.ApplicationApiImpl;

@SpringBootApplication
@ComponentScan(basePackages = "cz.expertkom.ju")
public class L07HomeWorkProdutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(L07HomeWorkProdutsApplication.class, args);
	}
	
	@Autowired
	Bus bus;
	
	@Bean
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
		return embeddedDatabaseBuilder.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.H2);
		jpaVendorAdapter.setGenerateDdl(true);

		final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		localContainerEntityManagerFactoryBean.setPackagesToScan("cz.expertkom.ju");
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());

		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
	public ApplicationApi appApi() {
		return new ApplicationApiImpl();
	}
	
	@Bean
	public JSONProvider<?> jsonProvider() {
	JSONProvider<?> jsonProvider = new JSONProvider<>();
	jsonProvider.setDropRootElement(true);
	jsonProvider.setSupportUnwrapped(true);
	return jsonProvider;
	}
	
	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setProvider(jsonProvider());
		endpoint.setBus(bus);
		endpoint.setAddress("/Home/Work/L07");
		endpoint.setServiceBeans(Arrays.<Object>asList(appApi()));
	return endpoint.create();
	
	
}
}
