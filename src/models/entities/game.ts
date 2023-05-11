import { DataTypes, Model } from 'sequelize';
import storage from 'storage';
import Round from './round';
import Team from './team';
import { definePk } from '$utils';

export enum GameFieldNames {
    GAME_ID = 'GAME_ID',
    START_DATE = 'START_DATE',
    END_DATE = 'END_DATE',
}

class Game extends Model {
    declare gameId: string;
    declare gameName: string;
    declare startDate: Date;
    declare endDate: Date;
    declare rounds: Round[];
    declare teams: Team[];
};

Game.init({
    gameId: definePk(GameFieldNames.GAME_ID),
    gameName: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    startDate: {
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW,
        field: GameFieldNames.START_DATE,
    },
    endDate: {
        type: DataTypes.DATE,
        field: GameFieldNames.END_DATE,
    },
}, {
    sequelize: storage,
    modelName: 'Game',
    tableName: 'GAMES',
});

export default Game;
