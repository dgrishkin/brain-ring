import express from 'express';

const adminRouter = express.Router();

adminRouter.get('/beginGame', (req, res) => {
    res.json({ game: 'STARTED' })
});

export default adminRouter;