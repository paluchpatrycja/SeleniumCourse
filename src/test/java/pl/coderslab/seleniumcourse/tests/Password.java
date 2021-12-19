package pl.coderslab.seleniumcourse.tests;

import java.util.Random;

public class Password {
    private String myPassword;
    public static void main(String[] args) {
        Random r = new Random(42);
        System.out.println(r.nextInt(100));
        System.out.println(r.nextInt(100));
    }
    public void generateRandomPassword(){
        this.myPassword = "alamakota";
    }
    public void fillForm() {
        String formElement = this.myPassword;
    }
}


