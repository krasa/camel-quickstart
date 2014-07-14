package krasa.camel;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainJavaConfig.class)
public class MainJavaConfigTest {

	@Produce(uri = "direct:input")
	private ProducerTemplate producerTemplate;
	@EndpointInject(uri = "mock:output")
	private MockEndpoint mockEndpoint;

	@Test
	public void test() throws Exception {
		mockEndpoint.expectedMessageCount(1);
		producerTemplate.sendBody("hello");
		mockEndpoint.assertIsSatisfied();
	}
}