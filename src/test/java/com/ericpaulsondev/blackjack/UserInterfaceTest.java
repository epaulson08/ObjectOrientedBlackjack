package test.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.blackjack.UserInterface;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserInterfaceTest {

    UserInterface ui;

    @AfterEach
    void afterEach() {
        ui = null;
    }

    @Test
    @DisplayName("promptPlayAgain returns true when input is Y, yes, etc.")
    void testPromptPlayAgainTrue() {
        ui = new UserInterface(new ByteArrayInputStream("y".getBytes()));
        assertEquals(true, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("y".getBytes()));
        assertEquals(true, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("Yes".getBytes()));
        assertEquals(true, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("yes".getBytes()));
        assertEquals(true, ui.promptPlayAgain());

        ui = null;
    }

    @Test
    @DisplayName("promptPlayAgain returns true when input is Y, yes, etc.")
    void testPromptPlayAgainFalse() {
        ui = new UserInterface(new ByteArrayInputStream("n".getBytes()));
        assertEquals(false, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("N".getBytes()));
        assertEquals(false, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("No".getBytes()));
        assertEquals(false, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("no".getBytes()));
        assertEquals(false, ui.promptPlayAgain());

        ui = new UserInterface(new ByteArrayInputStream("aslkneqtE8997JGL~!NBDASDFAO*(*".getBytes()));
        assertEquals(false, ui.promptPlayAgain());

        ui = null;
    }

}
