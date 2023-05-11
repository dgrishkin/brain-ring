import { Sequelize } from "sequelize";
import { resolve } from 'path';

const storage = new Sequelize({
    dialect: 'sqlite',
    storage: resolve(__dirname, '..', 'db', 'games.db'),
});

export default storage;