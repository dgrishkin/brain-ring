import apiRouter from '$api';
import express from 'express';
import http from 'http';
import { AddressInfo } from 'net';
import WebSocket from 'ws';
import storage from './storage';

const PORT = 8081;

const app = express();
app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.use(apiRouter);

const server = http.createServer(app);

const wss = new WebSocket.Server({ server });

wss.on('connection', (ws: WebSocket) => {

    //connection is up, let's add a simple simple event
    ws.on('message', (message: string) => {

        //log the received message and send it back to the client
        console.log('received: %s', message);
        ws.send(`Hello, you sent -> ${message}`);
    });

    //send immediatly a feedback to the incoming connection    
    ws.send('Hi there, I am a WebSocket server');
});

storage.authenticate().then(() => storage.sync()).then(() => {
    server.listen(PORT, () => {
        const addressInfo = server.address() as AddressInfo;
        console.log(`Server listening on ${addressInfo.address}:${addressInfo.port}`)
    });
}).catch(console.error);
