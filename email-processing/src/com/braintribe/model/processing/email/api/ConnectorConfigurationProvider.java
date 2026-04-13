package com.braintribe.model.processing.email.api;

import java.util.List;
import java.util.Set;

import com.braintribe.gm.model.reason.Maybe;
import com.braintribe.model.email.deployment.connection.EmailConnectorConfiguration;
import com.braintribe.model.generic.reflection.EntityType;

/**
 * @author peter.gazdik
 */
public interface ConnectorConfigurationProvider {

	<C extends EmailConnectorConfiguration> List<C> getConnectorConfigurations(EntityType<C> type, Set<String> externalIds);

	<T extends EmailConnectorConfiguration> Maybe<T> getConnectorConfiguration(EntityType<T> type, String connectorId);

}
