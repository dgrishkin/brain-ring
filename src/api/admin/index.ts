import { beginGame, endGame, findCurrentGame } from "$services";
import express from "express";

const adminRouter = express.Router();

adminRouter.get("/checkGame", (req, res) =>
  findCurrentGame()
    .then((games) => res.json(games))
    .catch(console.error)
);

adminRouter.post("/beginGame", (req, res) =>
  beginGame(req.body.gameName).then((game) => {
    res.json({ gameId: game.gameId });
  })
);

adminRouter.post("/stopGame", (req, res) => {
  endGame(req.body.gameId).then(() => {
    console.log('>>>update ok');
    res.send(200);
  });
});

export default adminRouter;
