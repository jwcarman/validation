package com.carmanconsulting.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class ValidationMessages
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final List<String> messages = new LinkedList<String>();

//----------------------------------------------------------------------------------------------------------------------
// Canonical Methods
//----------------------------------------------------------------------------------------------------------------------

    public String toString()
    {
        return StringUtils.join(messages, "\n");
    }

//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    public void addMessage(String message)
    {
        messages.add(message);
    }

    public String getMessage(int index)
    {
        return messages.get(index);
    }

    public boolean isEmpty()
    {
        return messages.isEmpty();
    }
}
