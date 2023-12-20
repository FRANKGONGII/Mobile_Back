<script lang="ts" setup>
import {h, onMounted, reactive, ref} from "vue";
import {request} from "@/config";
import {ElNotification} from "element-plus";
import {userInfo, recordInfo} from "@/utils/interfaces.ts";

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

let records = [] as recordInfo[]
let record_len = ref(-1)
let recordFilter = reactive({
  data: [] as recordInfo[]
})

const getRecords = (id:number) =>{
    request({
      url : `recordByUser/${id}`,
      method : "GET"
    }).then((res)=>{
      records = res.data.data
      record_len.value = records.length
      recordFilter.data = records
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
              <el-button type="primary" @click="showRecord = true; getRecords(user.id)">
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



            <el-drawer v-model="showRecord" draggable @close="showRecord = false; records=[];
                                                                 record_len=-1;recordFilter.data=[]">
              <el-collapse style="display: flex;flex-direction: column;">
                <el-empty v-if="records.length === 0"
                          description="当前用户暂无运动记录"/>
                <el-collapse-item v-for="record in recordFilter.data" :title="record.id.toString()">
                  <el-form label-width="30%" class="demo-ruleForm" label-position="right"
                           hide-required-asterisk size="large">
                    <el-form-item label="用户ID">
                      <el-input v-model="record.userId"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="ID">
                      <el-input v-model="record.id"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="运动类型">
                      <el-input v-model="record.recordType"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="开始时间">
                      <el-input v-model="record.startTime"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="结束时间">
                      <el-input v-model="record.endTime"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="运动时间">
                      <el-input v-model="record.duration"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>
                    <el-form-item label="运动距离">
                      <el-input v-model="record.distance"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>

                    <el-form-item v-for="(latitude, index)in record.latitudeList" label="经度{{index.toString()}}">
                      <el-input v-model="latitude"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>

                    <el-form-item v-for="(longitude, index)in record.longitudeList" label="纬度{{index.toString()}}">
                      <el-input v-model="longitude"  style="width: 25vh" :disabled="true"/>
                    </el-form-item>

                  </el-form>
                </el-collapse-item>
              </el-collapse>
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