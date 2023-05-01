import express from 'express';

const playerRouter = express.Router();

playerRouter.get('/checkGame', (req, res) => {
    res.json({ game: 'STARTED' })
});

export default playerRouter;