import apiRouter from './api';
import express from 'express';
import http from 'http';
import { AddressInfo } from 'net';
import WebSocket from 'ws';
import sqlite3 from 'sqlite3';

const sq = sqlite3.verbose();

const PORT = 8081;

const app = express();
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

const db = new sq.Database('./db/games.db', sq.OPEN_READWRITE | sq.OPEN_CREATE, (err) => {
    if (err) {
        console.error(err.message);
        console.error(err.stack);
    } else {
        console.log('Connected to the games database');
        server.listen(PORT, () => {
            const addressInfo = server.address() as AddressInfo;
            console.log(`Server listening on ${addressInfo.address}:${addressInfo.port}`)
        });
    }
});