package com.braintribe.model.email.configuration;

import java.util.List;

import com.braintribe.model.email.deployment.connection.EmailConnectorConfiguration;
import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@SelectiveInformation("Email Configuration")
public interface EmailConfiguration extends GenericEntity {

	EntityType<EmailConfiguration> T = EntityTypes.T(EmailConfiguration.class);

	@Name("Service Domain ID")
	@Initializer("'email.services.domain'")
	String getServiceDomainId();
	void setServiceDomainId(String serviceDomainId);

	@Name("Connectors")
	@Description("Enabled send and retrieve connectors. Connector external IDs are the stable lookup keys used by email requests.")
	List<EmailConnectorConfiguration> getConnectors();
	void setConnectors(List<EmailConnectorConfiguration> connectors);

	@Name("Health Check Enabled")
	@Initializer("true")
	boolean getHealthCheckEnabled();
	void setHealthCheckEnabled(boolean healthCheckEnabled);
}
