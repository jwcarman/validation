package com.carmanconsulting.validation.facet;

import com.carmanconsulting.validation.Constraint;
import com.carmanconsulting.validation.ValidationMessages;
import org.apache.commons.lang3.Validate;

public abstract class FacetConstraint<T> implements Constraint<T>
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final Facet<T> facet;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public FacetConstraint(Facet<T> facet)
    {
        Validate.notNull(facet, "Facet cannot be null.");
        this.facet = facet;
    }

//----------------------------------------------------------------------------------------------------------------------
// Abstract Methods
//----------------------------------------------------------------------------------------------------------------------

    protected abstract void checkFacetValue(Object value, ValidationMessages messages);

//----------------------------------------------------------------------------------------------------------------------
// Constraint Implementation
//----------------------------------------------------------------------------------------------------------------------


    @Override
    public void check(T bean, ValidationMessages messages)
    {
        checkFacetValue(facet.getValue(bean), messages);
    }
}
