let user = sessionStorage.getItem("user");

if (user == null){
    let name = prompt ('What is your name?')
    fetch ('/new', {
        method: 'POST',
        body: name
    })
    .then(response => response.json())
    .then(user => {
        sessionStorage.setItem('user', JSON.stringify(user));
        console.log(user);
    })
}
else {
    user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user);
}