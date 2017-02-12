package org.cloudmeter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc
//@EnableWebSocket
public class CloudMeterConfig extends WebMvcConfigurerAdapter {
//	implements WebSocketConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		super.addResourceHandlers(registry);
		
//		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
//		registry.addResourceHandler("/static/html/**").addResourceLocations("classpath:/html/");
		
	}
	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//	    registry.addViewController("/").setViewName("forward:/static/html/home.html");
//	}

//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
//		arg0.addHandler(testRunHandler(), "/testrun");		
//	}
//	
//    @Bean
//    public TestRunHandler testRunHandler() {
//        return new TestRunHandler();
//    }

}
