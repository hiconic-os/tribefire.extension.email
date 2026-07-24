package com.braintribe.model.processing.email;

import java.util.List;

import com.braintribe.cfg.Configurable;
import com.braintribe.cfg.Required;
import com.braintribe.gm.model.reason.Maybe;
import com.braintribe.logging.Logger;
import com.braintribe.model.check.service.CheckRequest;
import com.braintribe.model.check.service.CheckResult;
import com.braintribe.model.check.service.CheckResultEntry;
import com.braintribe.model.check.service.CheckStatus;
import com.braintribe.model.email.service.CheckConnections;
import com.braintribe.model.email.service.ConnectionCheckResult;
import com.braintribe.model.email.service.ConnectionCheckResultEntry;
import com.braintribe.model.email.service.reason.ConfigurationMissing;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.processing.check.api.CheckProcessor;
import com.braintribe.model.processing.service.api.ServiceRequestContext;
import com.braintribe.model.service.api.ServiceRequest;

/** Cortex compatibility adapter. The portable email processing itself has no Cortex check dependency. */
public class HealthCheckProcessor implements CheckProcessor {

	private static final Logger logger = Logger.getLogger(HealthCheckProcessor.class);
	private Evaluator<ServiceRequest> systemServiceRequestEvaluator;

	@Override
	public CheckResult check(ServiceRequestContext requestContext, CheckRequest request) {
		CheckResult response = CheckResult.T.create();
		List<CheckResultEntry> entries = response.getEntries();
		CheckConnections check = CheckConnections.T.create();
		Maybe<? extends ConnectionCheckResult> result = check.eval(systemServiceRequestEvaluator).getReasoned();

		if (result.isUnsatisfied()) {
			CheckResultEntry entry = CheckResultEntry.T.create();
			entry.setName("Email Connectors");
			if (result.isUnsatisfiedBy(ConfigurationMissing.T)) {
				logger.debug(() -> "Email check is ok because there is no connector configured.");
				entry.setCheckStatus(CheckStatus.ok);
				entry.setMessage("No connectors available.");
			} else {
				String explanation = result.whyUnsatisfied().stringify();
				entry.setCheckStatus(CheckStatus.fail);
				entry.setMessage("Error while trying to establish the connection status.");
				entry.setDetails(explanation);
			}
			entries.add(entry);
			return response;
		}

		for (ConnectionCheckResultEntry source : result.get().getEntries()) {
			CheckResultEntry entry = CheckResultEntry.T.create();
			entry.setName(source.getName() + " (" + source.getType().name().toLowerCase() + ")");
			entry.setCheckStatus(source.getSuccess() ? CheckStatus.ok : CheckStatus.fail);
			entry.setDetails(source.getSuccess() ? source.getDetails() : source.getErrorMessage());
			entries.add(entry);
		}
		return response;
	}

	@Configurable
	@Required
	public void setSystemServiceRequestEvaluator(Evaluator<ServiceRequest> evaluator) {
		this.systemServiceRequestEvaluator = evaluator;
	}
}
