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
import {h, onMounted, reactive, ref} from "vue";
import {request} from "@/config";
import {ElNotification} from "element-plus";
import {video, userInfo, record} from "@/utils/interfaces.ts"


let users = [] as userInfo[]
let user_len = ref(-1)

const getUserInfo = () =>{
  request({
    url : "/users",
    method : "GET"
  }).then((res)=>{
    users = res.data.data
    user_len.value = users.length
    console.log(users)
    ElNotification({
      offset: 70,
      title: "getUsers成功",
      message: h('success', { style: 'color: teal' }, "获取成功"),
    })
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
let video_len = ref(-1)
const getVideoInfo = () =>{
  request({
    url : "/videos",
    method : "GET"
  }).then((res)=>{
    videos = res.data.data
    video_len.value = videos.length
    console.log(videos)
    ElNotification({
      offset: 70,
      title: "getVideos成功",
      message: h('success', { style: 'color: teal' }, "获取成功"),
    })
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
let record_len = ref(-1)

const getRecordInfo = () =>{
  request({
    url : "/allRecords",
    method : "GET"
  }).then((res)=>{
    records = res.data.data
    record_len.value = records.length
    console.log(records)
    ElNotification({
      offset: 70,
      title: "getRecords成功",
      message: h('success', { style: 'color: teal' }, "获取成功"),
    })
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
