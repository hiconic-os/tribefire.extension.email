// ============================================================================
// BRAINTRIBE TECHNOLOGY GMBH - www.braintribe.com
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2018 - All Rights Reserved
// It is strictly forbidden to copy, modify, distribute or use this code without written permission
// To this file the Braintribe License Agreement applies.
// ============================================================================

package com.braintribe.tribefire.email.test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.braintribe.model.email.data.Email;
import com.braintribe.model.email.data.Recipient;
import com.braintribe.model.email.data.Sender;
import com.braintribe.model.email.deployment.connection.MsGraphSendConnector;
import com.braintribe.model.email.service.SendEmail;
import com.braintribe.model.email.service.SentEmail;
import com.braintribe.model.generic.eval.EvalContext;
import com.braintribe.model.processing.bootstrapping.TribefireRuntime;
import com.braintribe.model.processing.query.fluent.EntityQueryBuilder;
import com.braintribe.model.query.EntityQuery;
import com.braintribe.model.resource.Resource;
import com.braintribe.testing.category.SpecialEnvironment;
import com.braintribe.utils.DateTools;
import com.braintribe.utils.IOTools;
import com.braintribe.utils.RandomTools;

@Category(SpecialEnvironment.class)
public class EmailTestMsGraph extends AbstractEmailTest {

	private boolean initialized = false;

	private Random rnd = new Random();// NOSONAR: it is just a test

	protected static final String TEST_EXTERNAL_ID_MS_GRAPH = "test.email.msgraph.send";

	// -----------------------------------------------------------------------
	// SETUP & TEARDOWN
	// -----------------------------------------------------------------------

	@Override
	@Before
	public void before() throws Exception {
		super.before();
		if (!initialized) {
			initialized = true;
			connectorMsGraph();
		}
	}

	// -----------------------------------------------------------------------
	// TESTS
	// -----------------------------------------------------------------------

	@Test
	@Ignore
	public void testSendAndReceiveTextWithMultipleTextAttachments() throws Exception {

		Recipient to = Recipient.create(GmailCredentials.getEmail());

		String bodyText = "Test w/ Multiple Text Attachments " + RandomTools.newStandardUuid();
		String subject = "TEXT w/ Multiple Text Attachments Test at " + DateTools.getCurrentDateString();

		String attText1 = "hello, world 1";
		Resource resource1 = Resource.createTransient(() -> new ByteArrayInputStream(attText1.getBytes("UTF-8")));
		resource1.setName("test1.txt");
		resource1.setMimeType("text/plain");

		String attText2 = "hello, world 2";
		Resource resource2 = Resource.createTransient(() -> new ByteArrayInputStream(attText2.getBytes("UTF-8")));
		resource2.setName("test2.txt");
		resource2.setMimeType("text/plain");

		Email email = Email.T.create();
		email.getToList().add(to);
		email.setSubject(subject);
		email.setTextBody(bodyText);
		email.getAttachments().add(resource1);
		email.getAttachments().add(resource2);

		SendEmail req = SendEmail.T.create();
		req.setEmail(email);
		req.setConnectorId(TEST_EXTERNAL_ID_MS_GRAPH);
		EvalContext<? extends SentEmail> evalContext = req.eval(cortexSession);
		SentEmail sentEmail = evalContext.get();
		System.out.println("Sent message: " + sentEmail.getMessageId());

	}

	@Test
	public void testSendAndReceiveWithInlineAttachment() throws Exception {

		Recipient to = Recipient.create(GmailCredentials.getEmail());

		Email email = Email.T.create();
		email.getToList().add(to);
		email.setSubject("INLINE Test at " + DateTools.getCurrentDateString());
		email.setHtmlBody("<body>Have a look at this picture: <img src=\"cid:AbcXyz123\" /><br />End of message.</body>");

		byte[] imageBytes = IOTools.inputStreamToByteArray(new FileInputStream("res/image1.png"));
		Resource inlineResource = Resource.createTransient(() -> new ByteArrayInputStream(imageBytes));
		inlineResource.setMimeType("images/png");
		inlineResource.setName("image1.png");
		inlineResource.setId("AbcXyz123");
		email.getInlineAttachments().add(inlineResource);

		SendEmail req = SendEmail.T.create();
		req.setEmail(email);
		EvalContext<? extends SentEmail> evalContext = req.eval(cortexSession);
		SentEmail sentEmail = evalContext.get();
		System.out.println("Sent message: " + sentEmail.getMessageId());

	}

	// -----------------------------------------------------------------------
	// HELPER METHODS
	// -----------------------------------------------------------------------

	protected MsGraphSendConnector connectorMsGraph() {

		EntityQuery query = EntityQueryBuilder.from(MsGraphSendConnector.T).where().property(MsGraphSendConnector.externalId)
				.eq(TEST_EXTERNAL_ID_MS_GRAPH).done();
		MsGraphSendConnector existing = cortexSession.query().entities(query).first();
		if (existing != null) {
			return existing;
		}

		if (TribefireRuntime.getProperty("MSGRAPH_TENANT") == null) {
			throw new RuntimeException("Could not initialize connection");
		}

		MsGraphSendConnector connector = cortexSession.create(MsGraphSendConnector.T);
		String externalId = TEST_EXTERNAL_ID_MS_GRAPH;
		connector.setExternalId(externalId);
		connector.setName("Email MS Graph Transmission Connection");
		// connector.setGlobalId(GLOBAL_ID_CONNECTION_PREFIX + externalId);
		connector.setAutoDeploy(true);

		connector.setTenantId(TribefireRuntime.getProperty("MSGRAPH_TENANT"));
		connector.setSendUrl("https://graph.microsoft.com/v1.0/users/${from}/sendMail");
		connector.setTokenUrl("https://login.microsoftonline.com/${tenantId}/oauth2/v2.0/token");

		Sender sender = cortexSession.create(Sender.T);
		sender.setEMailAddress(TribefireRuntime.getProperty("MSGRAPH_FROM"));

		connector.setDefaultFrom(sender);
		connector.setClientId(TribefireRuntime.getProperty("MSGRAPH_CLIENT_ID"));
		connector.setSecret(TribefireRuntime.getProperty("MSGRAPH_CLIENT_SECRET"));
		cortexSession.commit();

		logger.info(() -> "Creating MS Graph connection");

		deployDeployable(connector);

		return connector;
	}

}
