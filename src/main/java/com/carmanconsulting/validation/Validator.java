package com.carmanconsulting.validation;

import java.util.LinkedList;
import java.util.List;

public class Validator<T>
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final List<Constraint<T>> constraints = new LinkedList<Constraint<T>>();

//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    public void addConstraint(Constraint<T> constraint)
    {
        constraints.add(constraint);
    }

    public void validate(T object)
    {
        final ValidationMessages messages = new ValidationMessages();
        for (Constraint<T> constraint : constraints)
        {
            constraint.check(object, messages);
        }
        if(!messages.isEmpty())
        {
            throw new ValidationException(messages);
        }
    }
}
