package net.datafaker;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static net.datafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class IdNumberTest extends AbstractFakerTest {

    @Test
    public void testValid() {
        assertThat(faker.idNumber().valid(), matchesRegularExpression("[0-8]\\d{2}-\\d{2}-\\d{4}"));
    }

    @Test
    public void testInvalid() {
        assertThat(faker.idNumber().invalid(), matchesRegularExpression("[0-9]\\d{2}-\\d{2}-\\d{4}"));
    }

    @RepeatedTest(100)
    public void testSsnValid() {
        assertThat(faker.idNumber().ssnValid(), matchesRegularExpression("[0-8]\\d{2}-\\d{2}-\\d{4}"));
    }

    @RepeatedTest(100)
    public void testValidSwedishSsn() {
        final Faker f = new Faker(new Locale("sv_SE"));
        assertThat(f.idNumber().validSvSeSsn(), matchesRegularExpression("\\d{6}[-+]\\d{4}"));
    }

    @RepeatedTest(100)
    public void testInvalidSwedishSsn() {
        final Faker f = new Faker(new Locale("sv_SE"));
        assertThat(f.idNumber().invalidSvSeSsn(), matchesRegularExpression("\\d{6}[-+]\\d{4}"));
    }

    @RepeatedTest(100)
    public void testValidEnZaSsn() {
        final Faker f = new Faker(new Locale("en_ZA"));
        assertThat(f.idNumber().validEnZaSsn(), matchesRegularExpression("[0-9]{10}(0|1)8[0-9]"));
    }

    @RepeatedTest(100)
    public void testInvalidEnZaSsn() {
        final Faker f = new Faker(new Locale("en_ZA"));
        assertThat(f.idNumber().inValidEnZaSsn(), matchesRegularExpression("[0-9]{10}(0|1)8[0-9]"));
    }

    @RepeatedTest(100)
    public void testSingaporeanFin() {
        assertThat(faker.idNumber().singaporeanFin(), matchesRegularExpression("G[0-9]{7}[A-Z]"));
    }

    @RepeatedTest(100)
    public void testSingaporeanFinBefore2000() {
        assertThat(faker.idNumber().singaporeanFinBefore2000(), matchesRegularExpression("F[0-9]{7}[A-Z]"));
    }

    @RepeatedTest(100)
    public void testSingaporeanUin() {
        assertThat(faker.idNumber().singaporeanUin(), matchesRegularExpression("T[0-9]{7}[A-Z]"));
    }

    @RepeatedTest(100)
    public void testSingaporeanUinBefore2000() {
        assertThat(faker.idNumber().singaporeanUinBefore2000(), matchesRegularExpression("S[0-9]{7}[A-Z]"));
    }

    @RepeatedTest(100)
    public void testPeselNumber() {
        assertThat(faker.idNumber().peselNumber(), matchesRegularExpression("[0-9]{11}"));
    }
}
