<script lang="ts" setup>
import { useRouter } from "vue-router";
import {ref} from "vue"
const router = useRouter();
const menuSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath);
}
const defaultIndex = ref('/');

</script>

<template>
  <el-menu :router="true" class="el-menu" mode="horizontal" :ellipsis="false"
                @select="menuSelect"  :default-active="defaultIndex">
    <el-text class="mx-1" type="primary">KEEP++后台管理系统</el-text>
    <div class="flex-grow"/>
    <el-menu-item index="/">概览</el-menu-item>
    <el-menu-item index="/user">用户信息</el-menu-item>
  </el-menu>
</template>


<style scoped>
.flex-grow {
  flex-grow: 1;
}
</style>