package assertions;

import annotations.markTest;

public class Assertion {

    public String assertTrue(boolean toTest){
        if(toTest){
            return "Success";
        }
        return "Failure";
    }


    public static void ageEquals(int age1, int age2){
        if(age1 == age2){
            System.out.println("Equal");
        }else{
            System.out.println("Expected: " + age1);
            System.out.println("Actual: " + age2);
        }
    }





}
