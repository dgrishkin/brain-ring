import { DataTypes, Model } from 'sequelize';
import storage from 'storage';
import Game from './game';
import Round from './round';
import { definePk } from '$utils';

export enum TeamFieldNames {
    TEAM_ID = 'TEAM_ID',
    TEAM_NAME = 'TEAM_NAME',
    SCORE = 'SCORE'
}

class Team extends Model {
    declare teamId: string;
    declare game: Game;
    declare teamName: string;
    declare score: number;
    declare rounds: Round[];
};

Team.init({
    teamId: definePk(TeamFieldNames.TEAM_ID),
    teamName: {
        type: DataTypes.STRING,
        allowNull: false,
        field: TeamFieldNames.TEAM_NAME,
    },
    score: {
        type: DataTypes.INTEGER,
        defaultValue: 0,
        allowNull: false,
        field: TeamFieldNames.SCORE,
    }
}, {
    sequelize: storage,
    modelName: 'Team',
    tableName: 'TEAMS',
});

export default Team;
