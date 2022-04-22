package com.bcp.challenge.moneyexchange.exception;

public class EntityNotFoundException extends RuntimeException
{
    public EntityNotFoundException(String message )
    {
        super(message);
    }
}
