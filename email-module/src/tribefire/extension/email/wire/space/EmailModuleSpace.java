// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
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
package tribefire.extension.email.wire.space;

import com.braintribe.model.email.deployment.connection.EmailConnector;
import com.braintribe.model.email.deployment.connection.Pop3Connector;
import com.braintribe.model.email.deployment.connection.GmailImapConnector;
import com.braintribe.model.email.deployment.connection.GmailSmtpConnector;
import com.braintribe.model.email.deployment.connection.ImapConnector;
import com.braintribe.model.email.deployment.connection.SmtpConnector;
import com.braintribe.model.email.deployment.connection.YahooSmtpConnector;
import com.braintribe.model.email.deployment.service.EmailServiceProcessor;
import com.braintribe.model.email.deployment.service.HealthCheckProcessor;
import com.braintribe.model.processing.deployment.api.binding.DenotationBindingBuilder;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.module.wire.contract.TribefireModuleContract;
import tribefire.module.wire.contract.TribefireWebPlatformContract;
import tribefire.module.wire.contract.WebPlatformBindersContract;

@Managed
public class EmailModuleSpace implements TribefireModuleContract {

	@Import
	private TribefireWebPlatformContract tfPlatform;

	@Import
	private EmailDeployablesSpace deployables;

	@Import
	private WebPlatformBindersContract commonComponents;

	@Override
	public void bindDeployables(DenotationBindingBuilder bindings) {
		// @formatter:off
		bindings.bind(GmailSmtpConnector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.SmtpConnector.class)
			.expertFactory(deployables::gmailSmtpConnector);
		bindings.bind(SmtpConnector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.SmtpConnector.class)
			.expertFactory(deployables::smtpConnector);
		bindings.bind(GmailImapConnector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.ImapConnector.class)
			.expertFactory(deployables::gmailImapConnector);
		bindings.bind(ImapConnector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.ImapConnector.class)
			.expertFactory(deployables::imapConnector);
		bindings.bind(Pop3Connector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.Pop3Connector.class)
			.expertFactory(deployables::pop3Connector);
		bindings.bind(YahooSmtpConnector.T)
			.component(EmailConnector.T, com.braintribe.model.processing.email.connection.SmtpConnector.class)
			.expertFactory(deployables::smtpConnector);
		bindings.bind(HealthCheckProcessor.T)
			.component(commonComponents.checkProcessor())
			.expertFactory(this.deployables::healthCheckProcessor);
		
		// -----------------------------------------------------------------------
		// REQUEST PROCESSOR
		// -----------------------------------------------------------------------
	
		bindings.bind(EmailServiceProcessor.T)
			.component(tfPlatform.binders().serviceProcessor())
			.expertSupplier(deployables::emailServiceProcessor);
	
		// @formatter:on
	}

}
