import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createRouter, createWebHistory } from 'vue-router'

import index from "@/page/index.vue";
import userList from "@/page/userList.vue";

const routes = [
    {path: '/', component: index},
    {path: '/user', component: userList}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.mount('#app')
