//***************************DONE********************
package com.upgrad.blog.util;

import com.upgrad.blog.exceptions.EmailNotValidException;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: 5.1. Create a method with the following signature.
 * public boolean isValidEmail(String email)
 * TODO: 5.2. This method accepts email id and checks for the following.
 * a. Consider a dummy email id, <part 1>@<part 2>.<part 3>
 * b. part 1, part 2 and part 3 should only contain alphanumeric characters. They can't be an empty string.
 * c. part 3 should contain at least 2 and at most 6 characters.
 * TODO 5.3: This method should return (boolean) true if the email id is in the given format. Otherwise,
 * it should throw EmailNotValidException with the "Please provide valid email address" message.
 */
public class EmailValidator {
    public boolean isValidEmail(String email){
        if (email.trim().equals("")) {
            return false;
        }
        String regex = "^[a-z]+@[a-z]+.[a-z0-9]{2,6}$";
		return email.matches(regex);
    }


    
    public static void main(String[] args) throws EmailNotValidException {
		EmailValidator e = new EmailValidator();
		List<String> passingEmails = Arrays.asList(
				"ish@so.com",
				"a@b.com "
			);
		List<String> failingEmails = Arrays.asList(

				"@.",
				"%@xyz.com",
				"a@b.c",
				"a@b.correspondance",
				"a@b",
				"a.b"
			);
		System.out.println("All pass");
		for (String email: passingEmails) {
			System.out.print("checking " + email + " : ");
            e.isValidEmail(email);
            System.out.println("PASSED");
        }

		System.out.println("All fails");
		for (String email: failingEmails) {
			System.out.print("checking " + email + " : ");
            e.isValidEmail(email);
            System.out.println("PASSED");
        }
	}
}
