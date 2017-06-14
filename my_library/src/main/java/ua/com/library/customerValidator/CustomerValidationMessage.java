package ua.com.library.customerValidator;


public interface CustomerValidationMessage {
String EMPTY_USERNAME_FIELD="Enter your name";
String EMPTY_PASSWORD_FIELD="Enter your password";
String EMPTY_EMAIL_FIELD="Enter your email address";
String EMPTY_TELEPHONE_FIELD="Enter your phone number";

String NAME_ALREADY_EXISTS="A user with that name already exists";
String EMAIL_ALREADY_EXISTS="A user with that email address exists";
String TELEPHONE_ALREADY_EXISTS="A user with this phone already exists";
String NOT_EMAIL="Wrong email adress";
String NOT_TELEPHONE="Wrong telephone";

}
