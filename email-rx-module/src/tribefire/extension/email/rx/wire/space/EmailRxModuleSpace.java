package tribefire.extension.email.rx.wire.space;

import com.braintribe.gm.model.reason.essential.CommunicationError;
import com.braintribe.gm.model.reason.essential.InternalError;
import com.braintribe.gm.model.reason.essential.NotFound;
import com.braintribe.gm.model.reason.meta.HttpStatusCode;
import com.braintribe.gm.model.reason.meta.LogReason;
import com.braintribe.model.email.configuration.EmailConfiguration;
import com.braintribe.model.email.service.EmailServiceRequest;
import com.braintribe.model.email.service.reason.ConfigurationMissing;
import com.braintribe.model.logging.LogLevel;
import com.braintribe.model.processing.email.EmailProcessor;
import com.braintribe.model.processing.email.cache.MailerCache;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import hiconic.rx.check.api.CheckContract;
import hiconic.rx.check.model.aspect.CheckCoverage;
import hiconic.rx.check.model.aspect.CheckLatency;
import hiconic.rx.module.api.service.ModelConfiguration;
import hiconic.rx.module.api.service.ModelConfigurations;
import hiconic.rx.module.api.service.ServiceDomainConfigurations;
import hiconic.rx.module.api.service.ServiceProcessorRegistry;
import hiconic.rx.module.api.wire.RxModuleContract;
import hiconic.rx.module.api.wire.RxPlatformContract;
import tribefire.extension.email.rx.api.EmailRxModuleContract;
import tribefire.extension.email.rx.processing.EmailConnectionCheckProcessor;
import tribefire.extension.email.rx.processing.ModeledConnectorConfigurationProvider;

@Managed
public class EmailRxModuleSpace implements RxModuleContract, EmailRxModuleContract {

	@Import private RxPlatformContract platform;
	@Import private CheckContract check;

	@Override
	public void configureModels(ModelConfigurations configurations) {
		ModelConfiguration serviceModel = configurations.bySymbol(configuredEmailServiceModel);
		serviceModel.addModelByName("tribefire.extension.email:email-service-model");
		serviceModel.bindRequestBySymbol(EmailServiceRequest.T, emailServiceProcessor);
		serviceModel.configureModel(editor -> {
			editor.onEntityType(CommunicationError.T).addMetaData(httpStatus(502), logReasonTrace());
			editor.onEntityType(NotFound.T).addMetaData(httpStatus(404), logReasonTrace());
			editor.onEntityType(InternalError.T).addMetaData(httpStatus(500), logReasonTrace());
			editor.onEntityType(ConfigurationMissing.T).addMetaData(httpStatus(503), logReasonTrace());
		});
	}

	@Override
	public void configureServiceDomains(ServiceDomainConfigurations configurations) {
		configurations.byId(configuration().getServiceDomainId()).addModel(configuredEmailServiceModel);
	}

	@Override
	public void registerServiceProcessors(ServiceProcessorRegistry registry) {
		registry.register(emailServiceProcessor, this::emailProcessor, this::configuration);
	}

	@Override
	public void onDeploy() {
		if (configuration().getHealthCheckEnabled())
			check.checkProcessorRegistry().registerProcessor(EmailConnectionCheckProcessor.symbol, emailConnectionCheckProcessor(),
					CheckCoverage.connectivity, CheckLatency.moderate, "email");
	}

	@Override
	@Managed
	public EmailConfiguration configuration() {
		return platform.configuration().readConfig(EmailConfiguration.T).get();
	}

	@Managed
	private EmailProcessor emailProcessor() {
		EmailProcessor bean = new EmailProcessor();
		bean.setConnectorConfigurationProvider(new ModeledConnectorConfigurationProvider(configuration()));
		bean.setModuleClassLoader(EmailRxModuleSpace.class.getClassLoader());
		bean.setMailerCache(mailerCache());
		bean.setPipeStreamFactory(platform.transientData().streamPipeFactory());
		bean.setHealthCheckExecutor(platform.execution().executorService());
		return bean;
	}

	@Managed
	private MailerCache mailerCache() {
		return new MailerCache();
	}

	@Managed
	private EmailConnectionCheckProcessor emailConnectionCheckProcessor() {
		EmailConnectionCheckProcessor bean = new EmailConnectionCheckProcessor();
		bean.setEvaluator(platform.serviceProcessing().systemEvaluator());
		return bean;
	}

	private static HttpStatusCode httpStatus(int code) {
		HttpStatusCode metadata = HttpStatusCode.T.create();
		metadata.setCode(code);
		return metadata;
	}

	private static LogReason logReasonTrace() {
		LogReason metadata = LogReason.T.create();
		metadata.setLevel(LogLevel.TRACE);
		return metadata;
	}
}
