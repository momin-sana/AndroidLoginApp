# AndroidLoginApp
This is a Login app in Android Java. It was made as assignment to practise the Validations.
following points have been coverd in this project:
* It has 3 Activities; **Splash Screen, Main Activity, AfterLogin Activity**.


  * *SPLASH SCREEN* contains simple welcome text with progressBar, both for 4secs. This is my Launcher activity.
 
 
  * *MAIN ACTIVITY* Here the Validations will take place i.e., 
 Email validation: 
```Java
    private Boolean validateEmail() {
        String emailInput = Objects.requireNonNull(textInputEmail.getEditText()).getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field cannot be empty");
            return false;
        } else if (!emailInput.matches(emailPattern)) {
//            else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){ //this is build-in pattern matcher
            textInputEmail.setError("Please enter a valid email address");
            Toast.makeText(this, R.string.email_order, Toast.LENGTH_LONG).show();
            return false;
        } else {
//            remove error msg and room for it
            textInputEmail.setError(null);
            textInputEmail.setErrorEnabled(false);
            return true;
        }
    }

```

and Password validation:
```Java
    private Boolean validatePassword() {
        String passInput = Objects.requireNonNull(textInputPassword.getEditText()).getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$";
        if (passInput.isEmpty()) {
            textInputPassword.setError("Field cannot be empty");
            return false;
        } else if (!passInput.matches(passwordVal)) {
            textInputPassword.setError("Password is too weak");
            Toast.makeText(this, R.string.password_order, Toast.LENGTH_LONG).show();
            return false;
        } else {
            textInputPassword.setError(null);
            textInputPassword.setErrorEnabled(false);
            return true;
        }
    }
```

When both the input values are valid user may enter AfterLogin activity, otherwise error will be shown.


 * *AfterLogin Activity*
Here a **Congratulation** msg shows here.
