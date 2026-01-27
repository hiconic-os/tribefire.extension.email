package com.braintribe.model.processing.email;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class EmailProcessorTest {

	@Test
	public void testFindFreeFilename() throws Exception {
		Set<String> usedNames = new HashSet<>();
		assertThat(EmailProcessor.findFreeName("hello-world.txt", usedNames)).isEqualTo("hello-world.txt");
		assertThat(EmailProcessor.findFreeName("hello-world.txt", usedNames)).isEqualTo("hello-world-2.txt");
		assertThat(EmailProcessor.findFreeName("hello-world", usedNames)).isEqualTo("hello-world");
		assertThat(EmailProcessor.findFreeName("hello-world", usedNames)).isEqualTo("hello-world-2");
		assertThat(EmailProcessor.findFreeName("", usedNames)).isEqualTo("");
		assertThat(EmailProcessor.findFreeName("", usedNames)).isEqualTo("-2");
	}

}
