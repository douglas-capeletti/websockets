const http = require("http");
const ws = require("ws");
const fs = require("fs");
const path = require("path");

const server = http.createServer((req, res) => {
  res.end("Connected!");
});

const webSocket = new ws.Server({ server });

webSocket.on("connection", (socket, request) => {
  socket.on("message", (data) => {
    fs.readFile(getPath(data), "utf8", (err, data) =>
      err ? socket.send("Error on reading...") : socket.send(data)
    );
  });
});

function getPath(data) {
  switch (data) {
    case "SMALL":
      return path.resolve(__dirname, "data/file_small");
    case "MEDIUM":
      return path.resolve(__dirname, "data/file_medium");
    case "LARGE":
      return path.resolve(__dirname, "data/file_large");
  }
}

server.listen(7002);
