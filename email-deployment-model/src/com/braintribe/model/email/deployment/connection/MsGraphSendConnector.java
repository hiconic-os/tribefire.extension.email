// ============================================================================
// BRAINTRIBE TECHNOLOGY GMBH - www.braintribe.com
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2018 - All Rights Reserved
// It is strictly forbidden to copy, modify, distribute or use this code without written permission
// To this file the Braintribe License Agreement applies.
// ============================================================================

package com.braintribe.model.email.deployment.connection;

import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@SelectiveInformation("MS Graph Send Connector")
public interface MsGraphSendConnector extends MsGraphSendConnectorConfiguration, SendConnector {

	EntityType<MsGraphSendConnector> T = EntityTypes.T(MsGraphSendConnector.class);

}
