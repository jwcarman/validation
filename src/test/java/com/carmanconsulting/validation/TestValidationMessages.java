package com.carmanconsulting.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestValidationMessages
{
    @Test
    public void testToString()
    {
        ValidationMessages messages = new ValidationMessages();
        messages.addMessage("Foo");
        assertEquals("Foo", messages.toString());
        messages.addMessage("Bar");
        assertEquals("Foo\nBar", messages.toString());
    }

    @Test
    public void testIsEmpty()
    {
        ValidationMessages messages = new ValidationMessages();
        assertTrue(messages.isEmpty());
        messages.addMessage("Foo");
        assertFalse(messages.isEmpty());
    }
}
