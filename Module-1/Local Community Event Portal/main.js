// Console Message
console.log("Welcome to the Community Portal");

// Page Load Alert
window.onload = function(){

    alert("Page Fully Loaded");

    let saved =
    localStorage.getItem("preferredEvent");

    if(saved){

        document.getElementById("eventType").value =
        saved;
    }
};

// Array Methods
let events = ["Music", "Sports"];

events.push("Workshop");

let filteredEvents =
events.filter(event => event == "Music");

let mappedEvents =
events.map(event => "Event: " + event);

console.log(mappedEvents);

// Phone Validation
function validatePhone(){

    let phone =
    document.getElementById("phone").value;

    if(phone.length != 10){

        alert("Phone number must be 10 digits");
    }
}

// Event Fee Display
function showFee(){

    let event =
    document.getElementById("eventType").value;

    let fee = "";

    if(event == "Music"){
        fee = "₹500";
    }

    else if(event == "Sports"){
        fee = "₹300";
    }

    else if(event == "Workshop"){
        fee = "₹700";
    }

    else if(event == "Seminar"){
        fee = "₹400";
    }

    else if(event == "Dance"){
        fee = "₹350";
    }

    else if(event == "Food"){
        fee = "₹250";
    }

    document.getElementById("feeDisplay").innerHTML =
    "Event Fee: " + fee;

    localStorage.setItem(
        "preferredEvent",
        event
    );
}

// Form Submission
document.getElementById("registrationForm")
.addEventListener("submit", function(e){

    e.preventDefault();

    try{

        let name =
        document.getElementById("name").value;

        let email =
        document.getElementById("email").value;

        if(name == "" || email == ""){

            throw "All fields are required";
        }

        document.getElementById("confirmation").value =
        "Registration Submitted Successfully!";

        console.log("Form Submitted");

    }

    catch(error){

        console.log(error);
    }
});

// Image Enlarge
function enlargeImage(img){

    img.style.width = "500px";
    img.style.height = "300px";
}

// Character Counter
function countChars(){

    let text =
    document.getElementById("feedback").value;

    document.getElementById("charCount").innerHTML =
    "Characters: " + text.length;
}

// Video Ready
function videoReady(){

    alert("Video ready to play");
}

// Clear Preferences
function clearPreferences(){

    localStorage.clear();

    sessionStorage.clear();

    alert("Preferences Cleared");
}

// Geolocation
function findLocation(){

    if(navigator.geolocation){

        navigator.geolocation.getCurrentPosition(

            showPosition,

            showError,

            {
                enableHighAccuracy:true,
                timeout:5000
            }
        );

    }

    else{

        alert("Geolocation not supported");
    }
}

function showPosition(position){

    document.getElementById("location").innerHTML =

    "Latitude: " +
    position.coords.latitude +

    "<br>Longitude: " +
    position.coords.longitude;
}

function showError(error){

    if(error.code == error.PERMISSION_DENIED){

        alert("Permission Denied");
    }

    else if(error.code == error.TIMEOUT){

        alert("Location Request Timed Out");
    }
}

// Warning Before Leaving
function warningMessage(){

    return "Your form is unfinished!";
}

// Fetch API + Async/Await
async function fetchEvents(){

    try{

        let response =
        await fetch(
            "https://jsonplaceholder.typicode.com/posts"
        );

        let data =
        await response.json();

        console.log(data);

    }

    catch(error){

        console.log(error);
    }
}

fetchEvents();

// jQuery
$('#registerBtn').click(function(){

    console.log("Register Button Clicked");
});