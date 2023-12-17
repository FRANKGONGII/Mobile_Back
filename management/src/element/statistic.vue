<template>
  <el-row>

    <el-col :span="6">
      <el-statistic title="当前用户总数" :value="user_len" >
      </el-statistic>
    </el-col>

    <el-col :span="6">
    </el-col>

    <el-col :span="6">
      <el-statistic title="当前运动记录总数" :value="record_len">
      </el-statistic>

    </el-col>
    <el-col :span="6">
    </el-col>

    <el-col :span="6">
      <el-statistic title="当前课程总数" :value="video_len">
      </el-statistic>
    </el-col>

  </el-row>
</template>

<script lang="ts" setup>
import {h, onMounted, reactive} from "vue";
import {request} from "@/config";
import {ElNotification} from "element-plus";
import {video, user, record} from "@/utils/interfaces.ts"


let users = [] as user[]
let user_len = -1
let userFilter = reactive({
  data: [] as user[]
})
const getUserInfo = () =>{
  request({
    url : "/users",
    method : "GET"
  }).then((res)=>{
    users = res.data.data
    userFilter.data = [...users]
    user_len = users.length
    console.log(users)
  }).catch((err)=>{
    console.log(err)
    ElNotification({
      offset: 70,
      title: "getUsers错误",
      message: h('error', { style: 'color: teal' }, err.response?.data.msg),
    })
  })
}


let videos = [] as video[]
let video_len = -1
let videoFilter = reactive({
  data: [] as video[]
})
const getVideoInfo = () =>{
  request({
    url : "/videos",
    method : "GET"
  }).then((res)=>{
    videos = res.data.data
    videoFilter.data = [...videos]
    video_len = videos.length
    console.log(videos)
  }).catch((err)=>{
    console.log(err)
    ElNotification({
      offset: 70,
      title: "getVideos错误",
      message: h('error', { style: 'color: teal' }, err.response?.data.msg),
    })
  })
}

let records = [] as record[]
let record_len = -1
let recordFilter = reactive({
  data: [] as record[]
})

const getRecordInfo = () =>{
  request({
    url : "/allRecords",
    method : "GET"
  }).then((res)=>{
    records = res.data.data
    recordFilter.data = [...records]
    record_len = records.length
    console.log(records)
  }).catch((err)=>{
    console.log(err)
    ElNotification({
      offset: 70,
      title: "getRecords错误",
      message: h('error', { style: 'color: teal' }, err.response?.data.msg),
    })
  })
}

onMounted(() =>{
  getVideoInfo()
  getUserInfo()
  getRecordInfo()
})


</script>

<style scoped>
</style>
