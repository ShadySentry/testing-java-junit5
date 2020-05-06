package guru.springframework;

import org.junit.jupiter.api.*;

@Tag("model")
public interface ModelTests {
    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition());
    }
}
