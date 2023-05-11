import { DataTypes, Model } from 'sequelize';
import storage from 'storage';
import Game from './game';
import Team from './team';
import { definePk } from '$utils';

export enum RoundFieldNames {
    ROUND_ID = 'ROUND_ID',
    GAME_ID = 'GAME_ID',
    ROUND_NUM = 'ROUND_NUM',
    WINNER = 'WINNER'
}

class Round extends Model {
    declare roundId: string;
    declare gameId: string;
    declare roundNumber: number;
    declare winner: Team;
};

Round.init({
    roundId: definePk(RoundFieldNames.ROUND_ID),
    roundNumber: {
        type: DataTypes.INTEGER,
        field: RoundFieldNames.ROUND_NUM,
    },
}, {
    sequelize: storage,
    modelName: 'Round',
    tableName: 'ROUNDS',
});

export default Round;
