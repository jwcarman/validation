package com.carmanconsulting.validation.facet;

public interface Facet<T>
{
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    Object getValue(T bean);
    void setValue(T bean, Object value);
}
