package nl.enovation.spring.boot.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnClass({ DiscoveryClient.class })
@ConditionalOnProperty(prefix = "spring.boot.admin.discovery", name = "enabled", matchIfMissing = true)
@EnableDiscoveryClient
@Import(ConsulDiscoveryClientConfiguration.class)
public class ConsulDiscoveryConfiguration {

	@Bean
	@Primary
	DiscoveryClient discoveryClient(ConsulDiscoveryClient consul) {
		return new InternalPortFilteringDiscoveryClient(consul);
	}
	
	/* 
	 * Service ID // <hostname>:<container-name>:<internal-port>[:udp if udp]
	 * Also see https://github.com/gliderlabs/registrator
	**/
	private static class InternalPortFilteringDiscoveryClient implements DiscoveryClient {

		private ConsulDiscoveryClient consul;
		
		private String internalPort = "8081";

		public InternalPortFilteringDiscoveryClient(ConsulDiscoveryClient consul) {
			this.consul = consul;
		}

		@Override
		public String description() {
			return consul.description();
		}

		@Override
		public ServiceInstance getLocalServiceInstance() {
			return consul.getLocalServiceInstance();
		}

		@Override
		public List<ServiceInstance> getInstances(String serviceId) {
			return consul.getInstances(serviceId).stream().filter(p -> p.getServiceId().endsWith(internalPort)).collect(Collectors.toList());
		}

		@Override
		public List<String> getServices() {
			return consul.getServices().stream().filter(p -> p.endsWith(internalPort)).collect(Collectors.toList());
		}
	}
}
