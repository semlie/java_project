package com.sem.lape.rondomData;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Faker f =new Faker();
        String n =f.name();
       
    }
}
