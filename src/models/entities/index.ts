import Game, { GameFieldNames } from './game';
import Round, { RoundFieldNames } from './round';
import Team from './team';

Game.hasMany(Round, { foreignKey: GameFieldNames.GAME_ID, as: 'rounds' });
Game.hasMany(Team, { foreignKey: GameFieldNames.GAME_ID, as: 'teams' });

Round.belongsTo(Game, { foreignKey: GameFieldNames.GAME_ID, as: 'game' });
Round.belongsTo(Team, { foreignKey: RoundFieldNames.WINNER, as: 'winner' });

Team.belongsTo(Game, { foreignKey: GameFieldNames.GAME_ID, as: 'game' });
Team.hasMany(Round, { foreignKey: RoundFieldNames.WINNER, as: 'rounds' });

export { Game, Round, Team };
