package krasa.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vojtech Krasa
 */
@Configuration
public class RouteConfig {
	@Bean
	public RouteBuilder routeBuilder() {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:input")
						.errorHandler(deadLetterChannel("direct:fail").logStackTrace(false))
						.to("mock:output");
				
				from("direct:fail")
						.to("mock:outputFail");

			}
		};
	}

}
