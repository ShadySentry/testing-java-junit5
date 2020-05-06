package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.RepeatedTest.*;


class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person = new Person(1l, "Joe", "Buck");

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }

    @RepeatedTest(value=10, name = "{displayName} : {currentRepetition} of {totalRepetitions}" )
    @DisplayName("Repeated test")
    void myRepeatedTest() {
        System.out.println("");
    }

    @RepeatedTest(5)
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : "+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5,name = DISPLAY_NAME_PLACEHOLDER +": " +CURRENT_REPETITION_PLACEHOLDER + " of " +TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("repeatedTest With Assignment")
    void repeatedTestWithAssignment(){

    }
}