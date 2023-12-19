<script lang="ts" setup>
import {h, onMounted,ref} from "vue";
import {request} from "@/config";
import {ElNotification} from "element-plus";
import {user} from "@/utils/interfaces";

let users = [] as user[]
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


onMounted(()=>{
  getUserInfo()
  console.log(users)
})

</script>

<template>
  <el-container>
    <el-main>
      <div style="display: flex; justify-content: center">
        <el-empty v-if="users.length === 0"
                  description="当前数据库中没有用户"/>
        <el-collapse style="width: 80vh; display: flex;flex-direction: column;">
          <el-collapse-item v-for="user in users" :title="user.name">
            <div style="margin-bottom: 5%">
              <el-button>
                更改
              </el-button>
              <el-button type="danger">
                删除
              </el-button>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
    </el-main>
  </el-container>
</template>


<style scoped>
</style>