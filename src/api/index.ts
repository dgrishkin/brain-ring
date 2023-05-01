import express from 'express';
import adminRouter from './admin';
import playerRouter from './player';

const apiRouter = express.Router();

apiRouter.use('/api/admin', adminRouter);
apiRouter.use('/api/player', playerRouter);

export default apiRouter;