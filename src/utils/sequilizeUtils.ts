import { PRIMARY_KEY } from "$types"

export const definePk = (fieldName: string) => {
    return {
        ...PRIMARY_KEY,
        field: fieldName,
    }
}