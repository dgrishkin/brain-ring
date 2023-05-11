const path = require('path');

module.exports = {
    development: {
        database: path.resolve(__dirname, 'db', 'games.db'),
        storage: 'sqlite',
    }
};