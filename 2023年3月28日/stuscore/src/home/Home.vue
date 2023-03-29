<template>
    <!-- 前端显示区域：首页 -->
    <div id="main">
        <div class="aside">
            <Aside></Aside>
            <!-- <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @Open="handleOpen" @close="handleOpen" :collapse="isCollapse" @select="handleSelect">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">权限管理</span>
                    </template>
                    <el-menu-item index="/sysUser">用户管理</el-menu-item>
                    <el-menu-item index="/sysUser">角色管理</el-menu-item>
                    <el-menu-item index="/sysUser">菜单管理</el-menu-item>
                    <el-menu-item index="/sysUser">菜单管理</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">基础管理</span>
                    </template>
                    <el-menu-item index="/sysUser">学生管理</el-menu-item>
                    <el-menu-item index="/sysUser">教师管理</el-menu-item>
                    <el-menu-item index="/sysUser">班级管理</el-menu-item>
                    <el-menu-item index="/sysUser">课程管理</el-menu-item>
                    <el-menu-item index="/sysUser">成绩管理</el-menu-item>
                </el-submenu>

                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">统计管理</span>
                    </template>
                    <el-menu-item index="/sysUser">按教师统计</el-menu-item>
                    <el-menu-item index="/sysUser">按班级统计</el-menu-item>
                    <el-menu-item index="/sysUser">按课程统计</el-menu-item>
                </el-submenu>
            </el-menu>  -->
        </div>
        <div class="body">
            <div class="head">张三，您好</div>
            <div class="content">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<!-- 脚本区域 -->
<script>
import Aside from './Aside.vue';
export default{
    name:'Home',
    components:{
        Aside
    }
}
</script>

<!-- 样式区域 -->
<style scoped>
    #main{
        height: 1000%;
        display: flex;
        width: 100%;
    }

    .aside{
        height: 100%;
        flex: 2;
    }

    .body{
        height: 100%;
        flex: 10;
    }

    .head{
        line-height: 60px;
        background-color: #409eff;
        padding: 0 5px;
    }

    .content{
        padding:5px 5px;
    }
</style>