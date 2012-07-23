package com.carmanconsulting.validation;

public interface Constraint<T>
{
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    void check(T object, ValidationMessages messages);
}
