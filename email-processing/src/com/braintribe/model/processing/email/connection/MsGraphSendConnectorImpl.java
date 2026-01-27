// ============================================================================
// BRAINTRIBE TECHNOLOGY GMBH - www.braintribe.com
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2018 - All Rights Reserved
// It is strictly forbidden to copy, modify, distribute or use this code without written permission
// To this file the Braintribe License Agreement applies.
// ============================================================================

package com.braintribe.model.processing.email.connection;

import com.braintribe.cfg.Configurable;
import com.braintribe.cfg.Required;
import com.braintribe.logging.Logger;

public class MsGraphSendConnectorImpl implements com.braintribe.model.processing.email.connection.MsGraphSendConnector {

	private static final Logger logger = Logger.getLogger(MsGraphSendConnectorImpl.class);

	private com.braintribe.model.email.deployment.connection.MsGraphSendConnector connector;

	@Configurable
	@Required
	public void setConnector(com.braintribe.model.email.deployment.connection.MsGraphSendConnector connector) {
		this.connector = connector;
	}

}
