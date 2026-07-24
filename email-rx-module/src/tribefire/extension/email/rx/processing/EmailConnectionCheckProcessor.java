package tribefire.extension.email.rx.processing;

import com.braintribe.gm.model.reason.Maybe;
import com.braintribe.model.email.service.CheckConnections;
import com.braintribe.model.email.service.ConnectionCheckResult;
import com.braintribe.model.email.service.ConnectionCheckResultEntry;
import com.braintribe.model.email.service.reason.ConfigurationMissing;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.processing.service.api.ServiceRequestContext;
import com.braintribe.model.service.api.ServiceRequest;

import hiconic.rx.check.api.CheckProcessor;
import hiconic.rx.check.api.CheckProcessorSymbol;
import hiconic.rx.check.model.result.CheckResult;
import hiconic.rx.check.model.result.CheckResultEntry;
import hiconic.rx.check.model.result.CheckStatus;

public class EmailConnectionCheckProcessor implements CheckProcessor {

	public static final CheckProcessorSymbol symbol = () -> "emailConnectionCheckProcessor";
	private Evaluator<ServiceRequest> evaluator;

	@Override
	public CheckResult check(ServiceRequestContext context) {
		CheckResult response = CheckResult.T.create();
		Maybe<? extends ConnectionCheckResult> result = CheckConnections.T.create().eval(evaluator).getReasoned();
		if (result.isUnsatisfied()) {
			CheckResultEntry entry = CheckResultEntry.T.create();
			entry.setName("Email Connectors");
			if (result.isUnsatisfiedBy(ConfigurationMissing.T)) {
				entry.setCheckStatus(CheckStatus.ok);
				entry.setMessage("No connectors available.");
			} else {
				entry.setCheckStatus(CheckStatus.fail);
				entry.setMessage("Error while checking email connections.");
				entry.setDetails(result.whyUnsatisfied().stringify());
			}
			response.getEntries().add(entry);
			return response;
		}

		for (ConnectionCheckResultEntry source : result.get().getEntries()) {
			CheckResultEntry entry = CheckResultEntry.T.create();
			entry.setName(source.getName() + " (" + source.getType().name().toLowerCase() + ")");
			entry.setCheckStatus(source.getSuccess() ? CheckStatus.ok : CheckStatus.fail);
			entry.setDetails(source.getSuccess() ? source.getDetails() : source.getErrorMessage());
			response.getEntries().add(entry);
		}
		return response;
	}

	public void setEvaluator(Evaluator<ServiceRequest> evaluator) {
		this.evaluator = evaluator;
	}
}
