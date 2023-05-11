export enum ResponseStatus {
    OK = 'OK',
    ERROR = 'ERROR'
}

export interface IApiResult<T> {
    status: ResponseStatus;
    body: T;
}
