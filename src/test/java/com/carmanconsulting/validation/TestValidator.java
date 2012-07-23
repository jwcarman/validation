package com.carmanconsulting.validation;

import org.easymock.Capture;
import org.easymock.EasyMockSupport;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class TestValidator extends EasyMockSupport
{
//----------------------------------------------------------------------------------------------------------------------
// Other Methods
//----------------------------------------------------------------------------------------------------------------------

    @Test
    public void testWithFailingConstraint()
    {
        ValidationBean bean = new ValidationBean();
        Validator<ValidationBean> validator = new Validator<ValidationBean>();
        validator.addConstraint(new Constraint<ValidationBean>()
        {
            @Override
            public void check(ValidationBean object, ValidationMessages messages)
            {
                messages.addMessage("This bean stinks!");
            }
        });
        try
        {
            validator.validate(bean);
            fail("Validation should fail.");
        }
        catch (ValidationException e)
        {
            assertEquals("This bean stinks!", e.getValidationMessages().getMessage(0));
            assertEquals("This bean stinks!", e.getMessage());
        }
    }

    @Test
    public void testWithNoConstraints()
    {
        Validator<ValidationBean> validator = new Validator<ValidationBean>();
        validator.validate(new ValidationBean());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testWithSuccessfulConstraint()
    {
        Constraint<ValidationBean> constraint = createMock(Constraint.class);
        Capture<ValidationBean> beanCapture = new Capture<ValidationBean>();
        Capture<ValidationMessages> messagesCapture = new Capture<ValidationMessages>();
        constraint.check(capture(beanCapture), capture(messagesCapture));
        expectLastCall();

        replayAll();

        ValidationBean bean = new ValidationBean();
        Validator<ValidationBean> validator = new Validator<ValidationBean>();
        validator.addConstraint(constraint);
        validator.validate(bean);

        verifyAll();

        assertSame(bean, beanCapture.getValue());
    }
}
