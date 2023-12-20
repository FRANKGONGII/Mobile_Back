interface video{
    id:number,
    url:string,
    thumb:string,
    title:string,
    type:string,
    tag:string
}

interface recordInfo {
    id:number,
    userId:number,
    recordType:string,
    startTime:string,
    endTime:string,
    distance:number,
    duration:number,
    latitudeList:Array<number>,
    longitudeList:Array<number>,
}

interface userInfo {
    id: number,
    username: string,
    email: string,
    password: string,
    phone: string,
}

export {video, recordInfo, userInfo}