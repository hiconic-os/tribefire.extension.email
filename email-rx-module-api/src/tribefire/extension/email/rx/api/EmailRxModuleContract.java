package tribefire.extension.email.rx.api;

import com.braintribe.model.email.configuration.EmailConfiguration;

import hiconic.rx.module.api.service.ModelSymbol;
import hiconic.rx.module.api.service.ServiceProcessorSymbol;
import hiconic.rx.module.api.wire.RxExportContract;

public interface EmailRxModuleContract extends RxExportContract {

	ModelSymbol configuredEmailServiceModel = ModelSymbol.of("tribefire.extension.email:configured-email-service-model");
	ServiceProcessorSymbol emailServiceProcessor = () -> "email-services";

	EmailConfiguration configuration();
}
