package Softwear_Project_Acceptance_Test;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class EventManagementTests {

    EventService eventService = Mockito.mock(EventService.class);
    UserService userService = Mockito.mock(UserService.class);

    // Other test methods (testCreateEventWithAllDetails, testEditEventDetails, testDeleteEvent) would be here as well

    @Test
    void testParticipantRegistrationForEvent() {
        Mockito.when(userService.isLoggedInAsParticipant()).thenReturn(true);
        Mockito.when(eventService.registerForEvent(Mockito.anyString(), Mockito.any(Participant.class))).thenReturn("Registered successfully");

        assertTrue(userService.isLoggedInAsParticipant());

        Participant participant = new Participant("John Doe");
        String result = eventService.registerForEvent("Conference", participant);

        assertEquals("Registered successfully", result);
    }

    @Test
    void testRegistrationForFullEvent() {
        Mockito.when(userService.isLoggedInAsParticipant()).thenReturn(true);
        Mockito.when(eventService.registerForEvent("Full Conference", Mockito.any(Participant.class))).thenReturn("Event is full");

        assertTrue(userService.isLoggedInAsParticipant());

        Participant participant = new Participant("Jane Doe");
        String result = eventService.registerForEvent("Full Conference", participant);

        assertEquals("Event is full", result);
    }

    @Test
    void testRegistrationForCanceledEvent() {
        Mockito.when(userService.isLoggedInAsParticipant()).thenReturn(true);
        Mockito.when(eventService.registerForEvent("Canceled Event", Mockito.any(Participant.class))).thenReturn("Event is canceled");

        assertTrue(userService.isLoggedInAsParticipant());

        Participant participant = new Participant("Bob Smith");
        String result = eventService.registerForEvent("Canceled Event", participant);

        assertEquals("Event is canceled", result);
    }
}
