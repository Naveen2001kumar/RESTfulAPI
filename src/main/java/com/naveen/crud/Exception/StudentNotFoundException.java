package com.naveen.crud.Exception;

public class StudentNotFoundException extends RuntimeException{
  public   StudentNotFoundException(String message)
    {
        super(message);
    }
}
