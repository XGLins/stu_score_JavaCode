<template>
<div>
    <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @Open="handleOpen" @close="handleOpen" :collapse="isCollapse" @select="handleSelect">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">权限管理</span>
                    </template>
                    <el-menu-item index="/sysUser">用户管理</el-menu-item>
                    <el-menu-item index="/sysRole">角色管理</el-menu-item>
                    <el-menu-item index="/sysMenu">菜单管理</el-menu-item>
                    <el-menu-item index="/sysMenu">菜单管理</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">基础管理</span>
                    </template>
                    <el-menu-item index="/student">学生管理</el-menu-item>
                    <el-menu-item index="/teacher">教师管理</el-menu-item>
                    <el-menu-item index="/classes">班级管理</el-menu-item>
                    <el-menu-item index="/course">课程管理</el-menu-item>
                    <el-menu-item index="/score">成绩管理</el-menu-item>
                </el-submenu>

                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">统计管理</span>
                    </template>
                    <el-menu-item index="/statisticsTeacher">按教师统计</el-menu-item>
                    <el-menu-item index="/statisticsClasses">按班级统计</el-menu-item>
                    <el-menu-item index="/statisticsCourse">按课程统计</el-menu-item>
                </el-submenu>
            </el-menu> 
</div>
</template>

<script>
export default{
    name:"Aside",
    methods:{
        handleSelect(key,keyPath){
            if(key!=this.$route.path){
                this.$router.push(key)
            }
        },

    }
}

</script>

<style scoped>

</style>