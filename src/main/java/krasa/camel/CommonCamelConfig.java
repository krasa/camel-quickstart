package krasa.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Vojtech Krasa
 */

@Configuration
public class CommonCamelConfig extends CamelConfiguration {

        @Autowired
        private List<RouteBuilder> routeBuilders;

        @Override
        public List<RouteBuilder> routes() {
                return routeBuilders;
        }
}
