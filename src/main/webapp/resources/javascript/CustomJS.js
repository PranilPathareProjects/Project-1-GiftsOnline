function checkPass()
{
    //Store the password field objects into variables ...
    var password1 = document.getElementById('password');
    var password2 = document.getElementById('confirmpassword');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var correctColor = "#66cc66";
    var wrongColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(password1.value == password2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        password2.style.backgroundColor = correctColor;
        message.style.color = correctColor;
        message.innerHTML = "Passwords Match"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        password2.style.backgroundColor = wrongColor;
        message.style.color = wrongColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}