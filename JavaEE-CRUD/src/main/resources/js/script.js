document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const name = document.querySelector("#name").value;
    const email = document.querySelector("#email").value;
    const address = document.querySelector("#address").value;

    const studentData = {
      name: name,
      email: email,
      address: address,
    };

    console.log(studentData);

    //Create JSON
    const studentJSON = JSON.stringify(studentData);
    console.log(studentJSON);

//     //Introduce AJAX
//     const http = new XMLHttpRequest();
//     http.onreadystatechange = () => {
//       //http readyState explain => https://www.w3schools.com/xml/ajax_xmlhttprequest_response.asp/
//       //https://www.geeksforgeeks.org/explain-the-different-ready-states-of-a-request-in-ajax/
//
//       if (http.readyState == 4) {
//         if (http.status == 201) {
//           var responseTextJSON = JSON.stringify(http.responseText);
//           console.log(responseTextJSON);
//
//           //clear fields
//             document.querySelector("#name").value = "";
//             document.querySelector("#email").value = "";
//             document.querySelector("#address").value = "";
//
//         } else {
//           console.error("Failed!");
//           console.error("Status: ", http.status); //Success status values =>
//           console.log("Ready State: ", http.readyState);
//         }
//       } else {
//         console.error("Failed!");
//         console.error("Status: ", http.status); //Success status values =>
//         console.log("Ready State: ", http.readyState);
//       }
//     };
//
//     http.open("POST", "http://localhost:8080/StudentManagement/student", true);
//     http.setRequestHeader("Content-Type", "application/json");
//     http.send(studentJSON);
//   });
// });

    //AJAX with JQuery
    $.ajax({
      url: "http://localhost:8080/StudentManagement/student",
      type: "POST",
      data: studentJSON, // Stringify the JSON data
      contentType: "application/json", // Correct header for JSON
      success: (res) => {
        console.log(JSON.stringify(res));
        // Clear fields
        document.querySelector("#name").value = "";
        document.querySelector("#email").value = "";
        document.querySelector("#address").value = "";
      },
      error: (xhr, status, error) => {
        console.error("Failed to submit the form:", error);
      }
    });
  });
});



//Safe http methods
// https://developer.mozilla.org/en-US/docs/Glossary/Safe/HTTP
