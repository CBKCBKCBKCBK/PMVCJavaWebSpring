package tw.com.pcschool.web.misc;

import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
//@EnableWebMvc
public class Conversion extends WebMvcConfigurationSupport{
//	@Autowired
	private DateFormatter dateFormatter;
//	@Bean(name = "conversionService")
	public DateFormatter dateFormatter() {
		return new DateFormatter("dd/MM/yyyy");
	}
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService
		=new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar=new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
		registrar.registerFormatters(conversionService);
		return conversionService;
	}
//	@Bean(name = "conversionService")
//	public ConversionService getConversionService() {
////		ConversionServiceFactoryBean bean=new ConversionServiceFactoryBean();
////		
////		bean.setConverters(null);
////		bean.afterPropertiesSet();
////		return bean.getObject();
////		FormattingConversionServiceFactoryBean bean=new FormattingConversionServiceFactoryBean();
//		
////		bean.setFormatterRegistrars(new DateFormatter().setPattern(""));
//		return null;
//	}
	
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(dateFormatter);
	}
	
}
