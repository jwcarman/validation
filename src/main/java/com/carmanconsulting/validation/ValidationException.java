package com.carmanconsulting.validation;

public class ValidationException extends RuntimeException
{
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    private final ValidationMessages validationMessages;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public ValidationException(ValidationMessages validationMessages)
    {
        super(validationMessages.toString());
        this.validationMessages = validationMessages;
    }

//----------------------------------------------------------------------------------------------------------------------
// Getter/Setter Methods
//----------------------------------------------------------------------------------------------------------------------

    public ValidationMessages getValidationMessages()
    {
        return validationMessages;
    }
}
