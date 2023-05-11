import { Game } from "$models";
import { Op } from "sequelize";

export const beginGame = async (gameName: string) => await Game.create({ gameName });

export const endGame = async (id: string) => {
    const game = await Game.findByPk(id);
    await game?.update({ endDate: Date.now() });
};

export const findCurrentGame = async () => await Game.findAll({ where: { endDate: { [Op.is]: null } } });
