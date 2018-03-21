package com.sorokin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sorokin.ValidationFailedException;
import com.sorokin.ValidatorFactory;
import com.sorokin.ChooserData;
import static com.sorokin.Homework7.createValidatorBySpecialty;
import com.sorokin.Validator;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Samsung
 */
public class Homework7Test {
    
    @Test
    public void testValidator_Int_1() throws ValidationFailedException {
        String line = "1";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        String expResult = "1";
        String result = validator.validate(line);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidator_Int_5() throws ValidationFailedException {
        String line = "5";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        String expResult = "5";
        String result = validator.validate(line);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidator_Int_10() throws ValidationFailedException {
        String line = "10";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        String expResult = "10";
        String result = validator.validate(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidate_String_Hello() throws ValidationFailedException {
        String line = "Hello";

        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        String expResult = "Hello";
        String result = validator.validate(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidate_String_hello() throws ValidationFailedException {
        String line = "hello";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        String expResult = "hello";
        String result = validator.validate(line);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChooserData_Int() throws ValidationFailedException {
        String line = "1";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);

        String expResult = "int";
        String result = ChooserData.chooseData(line);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testChooserData_String() throws ValidationFailedException {
        String line = "hello";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);

        String expResult = "string";
        String result = ChooserData.chooseData(line);
        assertEquals(expResult, result);
    }
    
    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFails1() throws ValidationFailedException {
        String line = "e3e3";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
                
        validator.validate(line);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateIntFails2() throws ValidationFailedException {
        String line = "3e3e";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        validator.validate(line);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateIntFails3() throws ValidationFailedException {
        String line = "";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        validator.validate(line);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateStringFails1() throws ValidationFailedException {
        String line = "Hello world, abc";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();
        
        validator.validate(line);
    }

    @Test(expected = ValidationFailedException.class)
    public void testValidateStringFails3() throws ValidationFailedException {
        String line = "";
        String validatorType = "";

        validatorType = ChooserData.chooseData(line);
        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();

        validator.validate(line);
    }
}
