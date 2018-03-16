
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sorokin
 */

public class Homework7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ValidationFailedException {
        String line;
        
        System.out.println("Введите строку:");
        Scanner sc = new Scanner(System.in);
        line = sc.next();
        
        String validatorType = "";

      
        
        validatorType = ChooserData.chooseData(line);

        ValidatorFactory validatorFactory = createValidatorBySpecialty(validatorType);
        Validator validator = validatorFactory.createValidator();

        validator.validate(line);

    }
    
    static ValidatorFactory createValidatorBySpecialty(String specialty) throws ValidationFailedException {
        if (specialty.equalsIgnoreCase("int")) {
            return new IntValidatorFactory();
        } else if (specialty.equalsIgnoreCase("string")) {
            return new StringValidatorFactory();
        } else {
            throw new ValidationFailedException(specialty + " is unknown specialty ");
        }
    }
}
