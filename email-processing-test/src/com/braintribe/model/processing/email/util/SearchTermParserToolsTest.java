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
package com.braintribe.model.processing.email.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;

import jakarta.mail.Flags;
import jakarta.mail.Message;
import jakarta.mail.search.AndTerm;
import jakarta.mail.search.BodyTerm;
import jakarta.mail.search.ComparisonTerm;
import jakarta.mail.search.FlagTerm;
import jakarta.mail.search.FromStringTerm;
import jakarta.mail.search.NotTerm;
import jakarta.mail.search.OrTerm;
import jakarta.mail.search.ReceivedDateTerm;
import jakarta.mail.search.RecipientStringTerm;
import jakarta.mail.search.SearchTerm;
import jakarta.mail.search.SentDateTerm;
import jakarta.mail.search.SubjectTerm;

public class SearchTermParserToolsTest {

	@Test
	public void testFrom() throws Exception {

		String input = "from \"roman\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(FromStringTerm.class);

		FromStringTerm from = (FromStringTerm) result;
		assertThat(from.getPattern()).isEqualTo("roman");
	}

	@Test
	public void testTo() throws Exception {

		String input = "to \"roman\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(RecipientStringTerm.class);

		RecipientStringTerm recp = (RecipientStringTerm) result;
		assertThat(recp.getPattern()).isEqualTo("roman");
		assertThat(recp.getRecipientType()).isEqualTo(Message.RecipientType.TO);
	}

	@Test
	public void testCc() throws Exception {

		String input = "cc \"roman\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(RecipientStringTerm.class);

		RecipientStringTerm recp = (RecipientStringTerm) result;
		assertThat(recp.getPattern()).isEqualTo("roman");
		assertThat(recp.getRecipientType()).isEqualTo(Message.RecipientType.CC);
	}

	@Test
	public void testBcc() throws Exception {

		String input = "bcc \"roman\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(RecipientStringTerm.class);

		RecipientStringTerm recp = (RecipientStringTerm) result;
		assertThat(recp.getPattern()).isEqualTo("roman");
		assertThat(recp.getRecipientType()).isEqualTo(Message.RecipientType.BCC);
	}

	@Test
	public void testUnread() throws Exception {

		String input = "unread";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(FlagTerm.class);

		FlagTerm flagTerm = (FlagTerm) result;
		Flags flags = flagTerm.getFlags();

		assertThat(flags.contains(Flags.Flag.SEEN)).isTrue();
	}

	@Test
	public void testOlder() throws Exception {

		String input = "older 1234";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(ReceivedDateTerm.class);

		ReceivedDateTerm term = (ReceivedDateTerm) result;
		assertThat(term.getComparison()).isEqualTo(ComparisonTerm.LT);
	}

	@Test
	public void testYounger() throws Exception {

		String input = "younger 1234";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(ReceivedDateTerm.class);

		ReceivedDateTerm term = (ReceivedDateTerm) result;
		assertThat(term.getComparison()).isEqualTo(ComparisonTerm.GT);
	}

	@Test
	public void testRecvDate() throws Exception {

		String input = "recvdate = \"29.07.2021\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(ReceivedDateTerm.class);

		ReceivedDateTerm term = (ReceivedDateTerm) result;
		Date date = term.getDate();
		assertThat(date).hasDayOfMonth(29);
		assertThat(date).hasMonth(7);
		assertThat(date).hasYear(2021);
		assertThat(term.getComparison()).isEqualTo(ComparisonTerm.EQ);
	}

	@Test
	public void testSentDate() throws Exception {

		String input = "sentdate <= \"29.07.2021\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(SentDateTerm.class);

		SentDateTerm term = (SentDateTerm) result;
		Date date = term.getDate();
		assertThat(date).hasDayOfMonth(29);
		assertThat(date).hasMonth(7);
		assertThat(date).hasYear(2021);
		assertThat(term.getComparison()).isEqualTo(ComparisonTerm.LE);
	}

	@Test
	public void testBody() throws Exception {

		String input = "body \"test\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(BodyTerm.class);

		BodyTerm term = (BodyTerm) result;
		assertThat(term.getPattern()).isEqualTo("test");
	}

	@Test
	public void testSubject() throws Exception {

		String input = "subject \"test\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(SubjectTerm.class);

		SubjectTerm term = (SubjectTerm) result;
		assertThat(term.getPattern()).isEqualTo("test");
	}

	@Test
	public void testNegation() throws Exception {

		String input = "not subject \"test\"";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(NotTerm.class);

		NotTerm notTerm = (NotTerm) result;
		SearchTerm subTerm = notTerm.getTerm();
		assertThat(subTerm).isInstanceOf(SubjectTerm.class);

		SubjectTerm term = (SubjectTerm) subTerm;
		assertThat(term.getPattern()).isEqualTo("test");
	}

	@Test
	public void testConjunction() throws Exception {
		String input = "(subject \"test\" and sentdate != \"29.07.2021\")";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(AndTerm.class);

		AndTerm andTerm = (AndTerm) result;
		SearchTerm[] andTermParts = andTerm.getTerms();
		assertThat(andTermParts).hasSize(2);

		assertThat(andTermParts[0]).isInstanceOf(SubjectTerm.class);
		assertThat(andTermParts[1]).isInstanceOf(SentDateTerm.class);

		SubjectTerm subjectTerm = (SubjectTerm) andTermParts[0];
		SentDateTerm sentDateTerm = (SentDateTerm) andTermParts[1];

		assertThat(subjectTerm.getPattern()).isEqualTo("test");
		Date date = sentDateTerm.getDate();
		assertThat(date).hasDayOfMonth(29);
		assertThat(date).hasMonth(7);
		assertThat(date).hasYear(2021);
		assertThat(sentDateTerm.getComparison()).isEqualTo(ComparisonTerm.NE);

	}

	@Test
	public void testDisjunction() throws Exception {
		String input = "(subject \"test\" or sentdate != \"29.07.2021\")";

		SearchTerm result = SearchTermParserTools.parseSearchTerm(input);
		assertThat(result).isInstanceOf(OrTerm.class);

		OrTerm andTerm = (OrTerm) result;
		SearchTerm[] andTermParts = andTerm.getTerms();
		assertThat(andTermParts).hasSize(2);

		assertThat(andTermParts[0]).isInstanceOf(SubjectTerm.class);
		assertThat(andTermParts[1]).isInstanceOf(SentDateTerm.class);

		SubjectTerm subjectTerm = (SubjectTerm) andTermParts[0];
		SentDateTerm sentDateTerm = (SentDateTerm) andTermParts[1];

		assertThat(subjectTerm.getPattern()).isEqualTo("test");
		Date date = sentDateTerm.getDate();
		assertThat(date).hasDayOfMonth(29);
		assertThat(date).hasMonth(7);
		assertThat(date).hasYear(2021);
		assertThat(sentDateTerm.getComparison()).isEqualTo(ComparisonTerm.NE);

	}
}
