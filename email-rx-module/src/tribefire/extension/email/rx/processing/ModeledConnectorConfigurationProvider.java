package tribefire.extension.email.rx.processing;

import java.util.List;
import java.util.Set;

import com.braintribe.gm.model.reason.Maybe;
import com.braintribe.gm.model.reason.Reason;
import com.braintribe.gm.model.reason.Reasons;
import com.braintribe.model.email.configuration.EmailConfiguration;
import com.braintribe.model.email.deployment.connection.EmailConnectorConfiguration;
import com.braintribe.model.email.deployment.connection.RetrieveConnectorConfiguration;
import com.braintribe.model.email.service.reason.RetrieveConnectorMissing;
import com.braintribe.model.email.service.reason.SendConnectorMissing;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.processing.email.api.ConnectorConfigurationProvider;
import com.braintribe.utils.StringTools;

public class ModeledConnectorConfigurationProvider implements ConnectorConfigurationProvider {

	private final EmailConfiguration configuration;

	public ModeledConnectorConfigurationProvider(EmailConfiguration configuration) {
		this.configuration = configuration;
		validateUniqueIds();
	}

	@Override
	public <C extends EmailConnectorConfiguration> List<C> getConnectorConfigurations(EntityType<C> type, Set<String> externalIds) {
		Set<String> ids = externalIds == null ? Set.of() : externalIds;
		return configuration.getConnectors().stream()
				.filter(EmailConnectorConfiguration::getEnabled)
				.filter(c -> type.isAssignableFrom(c.entityType()))
				.filter(c -> ids.isEmpty() || ids.contains(c.getExternalId()))
				.map(type.getJavaType()::cast)
				.toList();
	}

	@Override
	public <T extends EmailConnectorConfiguration> Maybe<T> getConnectorConfiguration(EntityType<T> type, String connectorId) {
		List<T> candidates = getConnectorConfigurations(type,
				StringTools.isBlank(connectorId) ? Set.of() : Set.of(connectorId));
		if (!candidates.isEmpty())
			return Maybe.complete(candidates.getFirst());

		boolean retrieve = RetrieveConnectorConfiguration.T.isAssignableFrom(type);
		EntityType<? extends Reason> reasonType = retrieve ? RetrieveConnectorMissing.T : SendConnectorMissing.T;
		String kind = retrieve ? "retrieve" : "send";
		String text = StringTools.isBlank(connectorId)
				? "There exists no enabled " + kind + " connector."
				: "The " + kind + " connector " + connectorId + " does not exist or is disabled.";
		return Reasons.build(reasonType).text(text).toMaybe();
	}

	private void validateUniqueIds() {
		Set<String> ids = new java.util.HashSet<>();
		for (EmailConnectorConfiguration connector : configuration.getConnectors())
			if (!ids.add(connector.getExternalId()))
				throw new IllegalStateException("Duplicate email connector externalId: " + connector.getExternalId());
	}
}
