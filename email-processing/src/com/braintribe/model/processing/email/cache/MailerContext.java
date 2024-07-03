// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package com.braintribe.model.processing.email.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

import org.simplejavamail.api.mailer.Mailer;

import com.braintribe.logging.Logger;

public class MailerContext implements Closeable {

	private static final Logger logger = Logger.getLogger(MailerContext.class);

	private Mailer mailer;
	private boolean sendAsync = false;
	private ExecutorService executor = null;

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public MailerContext(Mailer mailer) {
		this.mailer = mailer;
	}

	public Mailer getMailer() {
		return mailer;
	}

	public boolean getSendAsync() {
		return sendAsync;
	}

	public void setSendAsync(Boolean sendAsync) {
		if (sendAsync != null) {
			this.sendAsync = sendAsync.booleanValue();
		}
	}

	@Override
	public void close() throws IOException {
		ExecutorService ex = executor;
		if (ex != null) {
			try {
				ex.close();
				executor = null;
			} catch (Exception e) {
				logger.error("Error while trying to close executor.", e);
			}
		}
	}

}
