const SERVER_ADDR = "http://localhost:8081";

import axios, { AxiosRequestConfig } from "axios";

// 封装一下发起请求的部分, 便于本地测试时调用
function request(args: AxiosRequestConfig<any>) {
    args.baseURL = SERVER_ADDR + '/v1'
    args.timeout = 5000
    args.withCredentials = true
    return axios.request(args)
}

export { request }