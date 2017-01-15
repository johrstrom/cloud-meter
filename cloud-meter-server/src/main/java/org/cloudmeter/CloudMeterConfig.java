package org.cloudmeter;

import org.cloudmeter.ws.TestRunHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class CloudMeterConfig extends WebMvcConfigurerAdapter {
//	implements WebSocketConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
//		registry.addResourceHandler("asdfasf").addResourceLocations(arg0)
		registry.addResourceHandler("/html/**").addResourceLocations("classpath:/html/");
	}
	
	

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
