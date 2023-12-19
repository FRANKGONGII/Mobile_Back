interface video{
    id:number,
    url:string,
    thumb:string,
    title:string,
    type:string,
    tag:string
}

interface record{
    id:number,
    userId:number,
    type:string,
    startTime:string,
    endTime:string,
    distance:number,
    duration:number,
    latitudeList:Array<number>,
    longitudeList:Array<number>,
}

interface user {
    id: number,
    name: string,
    email: string,
    password: string,
    phone: string,
}

export {video, record, user}