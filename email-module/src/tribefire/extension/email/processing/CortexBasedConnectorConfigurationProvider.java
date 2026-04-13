package tribefire.extension.email.processing;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.braintribe.gm.model.reason.Maybe;
import com.braintribe.gm.model.reason.Reason;
import com.braintribe.gm.model.reason.Reasons;
import com.braintribe.model.deployment.Deployable;
import com.braintribe.model.deployment.DeploymentStatus;
import com.braintribe.model.email.deployment.connection.EmailConnector;
import com.braintribe.model.email.deployment.connection.EmailConnectorConfiguration;
import com.braintribe.model.email.deployment.connection.RetrieveConnector;
import com.braintribe.model.email.deployment.connection.RetrieveConnectorConfiguration;
import com.braintribe.model.email.deployment.connection.SendConnector;
import com.braintribe.model.email.service.reason.RetrieveConnectorMissing;
import com.braintribe.model.email.service.reason.SendConnectorMissing;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.processing.email.api.ConnectorConfigurationProvider;
import com.braintribe.model.processing.query.fluent.EntityQueryBuilder;
import com.braintribe.model.processing.session.api.persistence.PersistenceGmSession;
import com.braintribe.model.query.EntityQuery;
import com.braintribe.utils.StringTools;

/**
 * @author peter.gazdik
 */
public class CortexBasedConnectorConfigurationProvider implements ConnectorConfigurationProvider {

	private Supplier<PersistenceGmSession> cortexSessionSupplier;

	public void setCortexSessionProvider(Supplier<PersistenceGmSession> cortexSessionSupplier) {
		this.cortexSessionSupplier = cortexSessionSupplier;
	}

	@Override
	public <C extends EmailConnectorConfiguration> List<C> getConnectorConfigurations(EntityType<C> type, Set<String> externalIds) {
		PersistenceGmSession cortexSession = cortexSessionSupplier.get();

		EntityType<? extends EmailConnector> queryType = resolveQueryType(type);
		
		final EntityQuery query;
		if (externalIds.isEmpty()) {
			//@formatter:off
			query = EntityQueryBuilder.from(queryType)
					.where()
					.property(Deployable.deploymentStatus).eq(DeploymentStatus.deployed)
					.done();
			//@formatter:on
		} else {
			//@formatter:off
			query = EntityQueryBuilder.from(queryType)
					.where()
						.conjunction()
							.property(EmailConnector.deploymentStatus).eq(DeploymentStatus.deployed)
							.property(EmailConnector.externalId).in(externalIds)
						.close()
					.done();
			//@formatter:on			
		}
		List<C> list = cortexSession.query().entities(query).list();
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public <T extends EmailConnectorConfiguration> Maybe<T> getConnectorConfiguration(EntityType<T> type, String connectorId) {
		PersistenceGmSession session = cortexSessionSupplier.get();

		EntityType<? extends EmailConnector> queryType = resolveQueryType(type);

		final EntityQuery query;
		if (StringTools.isBlank(connectorId)) {
			//@formatter:off
			query = EntityQueryBuilder.from(queryType)
					.where()
						.property(EmailConnector.deploymentStatus).eq(DeploymentStatus.deployed)
					.done();
			//@formatter:on
		} else {
			//@formatter:off
			query = EntityQueryBuilder.from(queryType)
					.where()
						.conjunction()
							.property(EmailConnector.deploymentStatus).eq(DeploymentStatus.deployed)
							.property(EmailConnector.externalId).eq(connectorId)
						.close()
					.done();
			//@formatter:on
		}
		T c = session.query().entities(query).first();

		if (c == null || ((Deployable)c).getDeploymentStatus() != DeploymentStatus.deployed) {
			final String kind;
			final EntityType<? extends Reason> reasonType;
			if (RetrieveConnector.T.isAssignableFrom(type)) {
				kind = "retrieve";
				reasonType = RetrieveConnectorMissing.T;
			} else {
				kind = "send";
				reasonType = SendConnectorMissing.T;
			}
			return Reasons.build(reasonType).text(StringTools.isBlank(connectorId) ? "There exists no deployed " + kind + " connector."
					: "The " + kind + " connector " + connectorId + " does not exist or is not deployed.").toMaybe();
		}
		return Maybe.complete(c);

	}

	private EntityType<? extends EmailConnector> resolveQueryType(EntityType<? extends EmailConnectorConfiguration> type) {
		return type == RetrieveConnectorConfiguration.T ? RetrieveConnector.T : SendConnector.T;
	}

}
