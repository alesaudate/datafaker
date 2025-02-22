package net.datafaker;

import org.junit.jupiter.api.RepeatedTest;

import static net.datafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class BreakingBadTest extends AbstractFakerTest {

    @RepeatedTest(10)
    public void character() {
        assertThat(faker.breakingBad().character(), matchesRegularExpression("[\\p{L}A-Za-z0-9 .\\-;']+"));
    }

    @RepeatedTest(10)
    public void episodes() {
        assertThat(faker.breakingBad().episode(), not(is(emptyOrNullString())));
    }
}