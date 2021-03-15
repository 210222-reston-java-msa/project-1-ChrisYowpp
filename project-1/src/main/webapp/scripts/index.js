function sendLogin(){
  let uName = document.getElementById('uName').value;

  let pWord = document.getElementById('pWord').value;

  console.log(`Username: ${uName}`);
  console.log(`Password: ${pWord}`);

  let loginCredentials = {
    username: uName,
    password: pWord
  }


let xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
  if (this.readyState === 4 && this.status === 200) {
    console.log("success");

    sessionStorage.setItem('currentUser', this.responseText)

    window.location = "http://localhost:8080/project-1/home.html"

    console.log(sessionStorage.getItem('currentUser'));
  }
  
  if (this.readyState === 4 && this.status ===204) {
    console.log("failed to find user");

    let childDiv = document.getElementById('warningText');
    childDiv.textContent = "Failed to login! Username or Password is incorrect"
  }
}

xhr.open("POST", "http://localhost:8080/project-1/login")
xhr.send(JSON.stringify(loginCredentials))

}