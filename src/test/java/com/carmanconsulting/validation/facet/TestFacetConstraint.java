package com.carmanconsulting.validation.facet;

import com.carmanconsulting.validation.ValidationBean;
import com.carmanconsulting.validation.ValidationMessages;
import com.carmanconsulting.validation.Validator;
import com.carmanconsulting.validation.facet.ognl.OgnlFacet;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicReference;

public class TestFacetConstraint
{
    @Test
    public void testConstraintAppliesToValue()
    {
        final AtomicReference<Object> valueHolder = new AtomicReference<Object>();
        FacetConstraint<ValidationBean> constraint = new FacetConstraint<ValidationBean>(new OgnlFacet<ValidationBean>("stringProperty"))
        {
            @Override
            protected void checkFacetValue(Object value, ValidationMessages messages)
            {
                valueHolder.set(value);
            }
        };
        Validator<ValidationBean> validator = new Validator<ValidationBean>();
        validator.addConstraint(constraint);
        ValidationBean bean = new ValidationBean();
        bean.setStringProperty("testValue");
        validator.validate(bean);
        assertEquals("testValue", valueHolder.get());
    }

}
