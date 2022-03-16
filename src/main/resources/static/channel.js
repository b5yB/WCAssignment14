let user = sessionStorage.getItem("user");

if (user == null){
    window.location.href="/welcome"
}
else {
    user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user);
}

var textBox = document.querySelector("#textBox")

textBox.addEventListener('keyup', (e) => {
	if (e.keyCode === 13) {
		let message = {
                'user': user,
				'content': textBox.value
		}
		

        textBox.value = '';

        fetch(`/channel/${channelId}/message`, {
			method: 'POST',
            headers: {'Content-Type': 'application/json; charset=utf-8'},
			body: JSON.stringify(message)})
	}

})

let allMessages = [];
fetch(`/channel/${channelId}/message`)
.then(response => response.json())
.then(messages => {messages.forEach(message => {allMessages.push(JSON.stringify(message))})})

setInterval(getMessages, 500)

async function getMessages () {

	let messageBox = document.querySelector(".messageBox")

	await fetch(`/channel/${channelId}/message`)
	.then(response => response.json())
    .then(messages => {messages.forEach(message => {if(allMessages.includes(JSON.stringify(message)) === false){ 
							messageBox.innerHTML += 		
							`<div>
							<span class="messageName">${message.user.name}: </span>
							<span class="messageContent">${message.content}</span>
							</div>`
							allMessages.push(JSON.stringify(message));
							console.log(allMessages);
							}})})
}
