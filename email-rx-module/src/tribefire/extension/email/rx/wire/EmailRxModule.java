package tribefire.extension.email.rx.wire;

import hiconic.rx.module.api.wire.Exports;
import hiconic.rx.module.api.wire.RxModule;
import tribefire.extension.email.rx.api.EmailRxModuleContract;
import tribefire.extension.email.rx.wire.space.EmailRxModuleSpace;

public enum EmailRxModule implements RxModule<EmailRxModuleSpace> {
	INSTANCE;

	@Override
	public void bindExports(Exports exports) {
		exports.bind(EmailRxModuleContract.class, EmailRxModuleSpace.class);
	}
}
