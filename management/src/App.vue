<script setup>
  import NavigationMenu from '@/components/NavigationMenu.vue'
</script>

<template>
  <div>
    <el-container>
      <el-header >
        <NavigationMenu></NavigationMenu>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>

</template>

<style scoped>
</style>
