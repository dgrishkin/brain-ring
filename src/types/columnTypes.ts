import { DataTypes } from 'sequelize';

export const PRIMARY_KEY = {
    type: DataTypes.UUID,
    defaultValue: DataTypes.UUIDV4,
    primaryKey: true,
};