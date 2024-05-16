<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Client</title>
</head>
<body>
    <input id="message" type="text" placeholder="Enter message">
    <button onclick="sendMessage()">Send</button>
    <ul id="messages"></ul>

    <script>
        const ws = new WebSocket('ws://localhost:8080/chat');

        ws.onopen = () => {
            console.log('Connected to the WebSocket server');
        };

        ws.onmessage = (event) => {
            const messageList = document.getElementById('messages');
            const newMessage = document.createElement('li');
            newMessage.textContent = event.data;
            messageList.appendChild(newMessage);
        };

        function sendMessage() {
            const input = document.getElementById('message');
            ws.send(input.value);
            input.value = '';
        }
    </script>
</body>
</html>
