<script lang="ts" setup>
import {h, onMounted, reactive, ref} from "vue";
import {request} from "@/config";
import {ElNotification} from "element-plus";
import {userInfo} from "@/utils/interfaces.ts";

let users = [] as userInfo[]
let user_len = ref(-1)
let userFilter = reactive({
  data: [] as userInfo[]
})
const getUserInfo = () =>{
  request({
    url : "/users",
    method : "GET"
  }).then((res)=>{
    users = res.data.data
    user_len.value = users.length
    userFilter.data = users
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

let showDetail = ref(false)
let showRecord = ref(false)

</script>

<template>
  <el-container>
    <el-main>
      <div style="display: flex; justify-content: center">
        <el-collapse style="width: 80vh; display: flex;flex-direction: column;">
          <el-empty v-if="users.length === 0"
                    description="当前数据库中没有用户"/>

          <el-collapse-item v-for="user in userFilter.data" :title="user.username">
            <div style="margin-bottom: 5%">
              <el-button @click="showDetail = true">
                查看用户详细信息
              </el-button>
              <el-button type="primary" @click="showDetail = true">
                查看用户运动记录
              </el-button>
            </div>


            <el-drawer v-model="showDetail" draggable @close="showDetail = false">
              <el-form label-width="30%" class="demo-ruleForm" label-position="right"
              hide-required-asterisk size="large">
                <el-form-item label="ID">
                  <el-input v-model="user.id"  style="width: 25vh" :disabled="true"/>
                </el-form-item>
                <el-form-item label="用户名">
                  <el-input v-model="user.username"  style="width: 25vh" :disabled="true"/>
                </el-form-item>
                <el-form-item label="手机号">
                  <el-input v-model="user.phone"  style="width: 25vh" :disabled="true"/>
                </el-form-item>
                <el-form-item label="邮箱地址">
                  <el-input v-model="user.email"  style="width: 25vh" :disabled="true"/>
                </el-form-item>
              </el-form>
            </el-drawer>

            <el-drawer v-model="showRecord" draggable @close="showRecord = false">

            </el-drawer>

          </el-collapse-item>
        </el-collapse>
      </div>
    </el-main>
  </el-container>
</template>



<style scoped>
.flex-grow {
  flex-grow: 1;
}
</style>