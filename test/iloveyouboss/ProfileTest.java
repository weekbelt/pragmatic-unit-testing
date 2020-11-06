/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
 ***/
package iloveyouboss;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @BeforeEach
    public void create() {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    @DisplayName("matchAnswersFalseWhenWhenMustMatchCriteriaNotMet")
    public void matchAnswersFalseWhenWhenMustMatchCriteriaNotMet() {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE),Weight.MustMatch));

        // when
        boolean matches = profile.matches(criteria);

        // then
        assertFalse(matches);
    }

    @Test
    @DisplayName("matchAnswersTrueForAnyDontCareCriteria")
    public void matchAnswersTrueForAnyDontCareCriteria() {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE),Weight.DontCare));

        // when
        boolean matches = profile.matches(criteria);

        // then
        assertTrue(matches);
    }
}
