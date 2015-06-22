package com.asos;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class PolyTest {
    @Test
    public void polyMethodTest(){

        SuperClass[] superClassArray = {new SuperClass(), new SubClass1(), new SubClass2() };

        assertEquals(-1, superClassArray[0].methodToOverride()) ;
        assertEquals(1, superClassArray[1].methodToOverride()) ;
        assertEquals(2, superClassArray[2].methodToOverride()) ;

    }

}
