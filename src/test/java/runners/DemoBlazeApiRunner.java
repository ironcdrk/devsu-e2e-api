package runners;

import com.intuit.karate.junit5.Karate;

public class DemoBlazeApiRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features/demoBlazeApi.feature");
    }
}