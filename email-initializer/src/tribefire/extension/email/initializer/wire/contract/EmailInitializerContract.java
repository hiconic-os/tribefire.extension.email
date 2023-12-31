// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package tribefire.extension.email.initializer.wire.contract;

import java.util.Set;

import com.braintribe.gm.model.reason.meta.HttpStatusCode;
import com.braintribe.gm.model.reason.meta.LogReason;
import com.braintribe.model.ddra.DdraMapping;
import com.braintribe.model.email.deployment.service.EmailServiceProcessor;
import com.braintribe.model.extensiondeployment.check.CheckBundle;
import com.braintribe.model.meta.data.MetaData;
import com.braintribe.model.service.domain.ServiceDomain;
import com.braintribe.wire.api.space.WireSpace;

public interface EmailInitializerContract extends WireSpace {

	EmailServiceProcessor emailServiceProcessor();

	MetaData processWithEmailServiceProcessor();

	CheckBundle connectivityCheckBundle();

	Set<DdraMapping> ddraMappings();

	ServiceDomain apiServiceDomain();

	LogReason logReasonTrace();
	HttpStatusCode httpStatus500Md();
	HttpStatusCode httpStatus404Md();
	HttpStatusCode httpStatus501Md();
	HttpStatusCode httpStatus502Md();

}
