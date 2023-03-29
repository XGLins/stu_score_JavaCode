<!-- 论语 大学 中庸 大学 -->
<!-- 多线程 数据结构 重构 -->

<template>
    <div>

        <el-form :inline="true" ref="vForm" :model="searchFormData" label-position="right" label-width="80px"
            class="demo-form-inline">
            <el-form-item label="姓名" prop="name">
                <el-input v-model="searchFormData.name" placeholder=""></el-input>
            </el-form-item>
            <el-form-item label="手机号" prop="phone">
                <el-input v-model="searchFormData.phone" placeholder=""></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="searchSubmit">查询</el-button>
                <el-button type="primary" @click="searchResetForm">重置</el-button>
            </el-form-item>
        </el-form>

        <hr />
        <!-- 新增模块 -->
        <div style="background-color:gray">
            <el-button type="primary" @click="openAddWindow">新增</el-button>
        </div>
        <el-dialog :title="dialogTitle" :visible.sync="dialogVisible" :close-on-click-modal="false"
            :destroy-on-close="true">
            <div>
                <el-form :model="formData" ref="formData" :rules="formRules">
                    <el-form-item label="id" :label-width="formLabelWidth">
                        <el-input v-model="formData.id" autocomplete="off" :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
                        <el-input v-model="formData.name" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
                        <el-input v-model="formData.phone" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="头像" :label-width="formLabelWidth">
                        <Upload :uploadObj="uploadObj" />
                    </el-form-item>
                </el-form>

            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveFormData">确 定</el-button>
            </span>
        </el-dialog>


        <el-table :data="tableData" style="width:100%">
            <el-table-column prop="name" label="姓名" width="">
            </el-table-column>
            <el-table-column prop="phone" label="手机号" width="">
            </el-table-column>
            <el-table-column prop="avatar" label="头像" width="">
                <template slot-scope="scope">
                    <span>{{ scope.row.avatar }}</span>
                    <el-avatar v-if="scope.row.avatar" :src="'/api/file/download/' + scope.row.avatar"></el-avatar>
                    <el-avatar v-else src=""></el-avatar>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="openEditWindow(scope.row.id)" type="text" size="small">编辑</el-button>
                    <el-button @click="deleteById(scope.row.id)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <br />
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
            :current-page="pageObj.currentPage" :page-sizes="[5, 10, 20, 30, 40]" :page-size="pageObj.pageSize"
            layout="total, sizes, prev, pager, next" :total="pageObj.total">
        </el-pagination>



    </div>
</template>


<script>
import axios from 'axios'
export default {
    name: 'Teacher',
    components: {

    },
    data() {
        return {
            formData: {
                name: '',
                phone: '',
            },
            formRules: {//表单规则
                name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' },
                    { min: 2, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                phone: [
                    { required: true, message: '请输入手机号', trigger: 'blur' },
                    { min: 5, max: 11, message: '长度在 5 到 11 个字符', trigger: 'blur' },


                ],
            },
            formLabelWidth: '120px',
            dialogTitle: null,
            dialogVisible: false,//是否显示
            searchFormData: {},
            tableData: [
                // { name: "张三", phone: "131321513213", avatar: "toutou" }
            ],
            pageObj: {
                pageSize: 10,
                total: 0,
                currentPage: 1
            },
            pageObj: {
                pageSize: 10,
                total: 0,
                currentPage: 1
            },

        }
    },
    methods: {

        openAddWindow() {
            this.formData = {}
            this.dialogVisible = true
            this.dialogTitle = "新增"
            // alert(1)
        },
        //新增 或者 编辑调用该函数
        saveFormData() {
            this.$refs['formData'].validate(valid => {
                console.log(valid)
                if (!valid) {
                    return
                }
                //提交前，重新设置头像地址
                //this.formData.avatar = this.uploadObj.fileName
                //console.log("提交对象", this.formData, this.uploadObj.fileName)

                console.log("提交对象", this.formData)
                if (this.formData.id || this.formData.id == 0) {//修改一条教师数据
                    axios.put('/api/score/scTeacher/update', this.formData).then((resp) => {
                        //操作成功
                        this.$message({
                            message: resp.data.description,
                            type: 'success'
                        });

                    })
                } else {//新增一条教师数据
                    axios.post('/api/score/scTeacher/insert', this.formData).then((resp) => {
                        //操作成功
                        this.$message({
                            message: resp.data.description,
                            type: 'success'
                        });

                    })

                }

            })
            // this.dialogVisible = false
        },
        searchSubmit() {
            console.log('searchSubmit')
            let that = this
            this.$refs['vForm'].validate(valid => {
                if (!valid) {
                    return
                }
                console.log(that.searchFormData)
                // let params = Object.assign(that.searchFormData,{ current:that.pageObj.currentPage,size:that.pageObj.pageSize})
                let params = Object.assign(that.searchFormData, { current: 1, size: 10 })
                axios.get('/api/score/scTeacher/list', {
                    params: params
                }).then((resp) => {
                    console.log(resp.data)
                    if (resp.data.code == '200') {
                        that.tableData = resp.data.data.records //设置表格数据
                        that.pageObj.total = resp.data.data.total
                    }
                }).catch((err) => {
                    console.log(err)
                })

            })

            return false;
        },

        handleSizeChange(pageSize) {//每页条数发生改变时
            this.pageObj.currentPage = 1
            this.pageObj.pageSize = pageSize
            let that = this
            this.$refs['vForm'].validate(valid => {
                if (!valid) return
                console.log(that.searchFormData)
                let params = Object.assign(that.searchFormData, { current: that.pageObj.currentPage, size: that.pageObj.pageSize })
                // let params = Object.assign(that.searchFormData, { current: 1, size: 10 })
                axios.get('/api/score/scTeacher/list', {
                    params: params
                }).then((resp) => {
                    console.log(resp.data)
                    if (resp.data.code == '200') {
                        that.tableData = resp.data.data.records //设置表格数据
                        that.pageObj.total = resp.data.data.total
                    }
                }).catch((err) => {
                    console.log(err)
                })
            })

        },
        searchResetForm() {
            // this.$refs['vForm'].resetFields();
            this.$refs['vForm'].resetFields();

        },
        handleCurrentChange(currentPageNo) {
            this.pageObj.currentPage = currentPageNo;
            let that = this
            //需要点击重置为null  而不是 空字符串 ''
            this.$refs['vForm'].validate(valid => {
                if (!valid) return

                let params = Object.assign(that.searchFormData, { current: that.pageObj.currentPage, size: that.pageObj.pageSize })
                console.log("请求参数", params)
                axios.get('/api/score/scTeacher/list', {
                    params: params
                }).then((resp) => {
                    console.log(resp.data)
                    if (resp.data.code == '200') {
                        that.tableData = resp.data.data.records //设置表格数据
                        that.pageObj.total = resp.data.data.total
                    }
                }).catch((err) => {
                    console.log(err)
                })
            })
        },
        //删除
        deleteById(id) {
            // alert(id)
            axios.delete(`/api/score/scTeacher/delete/${id}`).then((resp) => {
                //操作成功
                this.$message({
                    message: resp.data.description,
                    type: 'success'
                });
            })

        },
        openEditWindow(id) {//点击编辑按钮
            // alert(id)
            this.dialogVisible = true
            //this.dialogVisible = ture
            //this.formData.id = id
            this.dialogTitle = "编辑"

            let that = this
            axios.get(`/api/score/scTeacher/${id}`).then((resp) => {
                console.log(id)
                console.log(resp.data);
                that.formData = resp.data.data
                //that.uploadObj.fileName = that.formData.avatar
            })
        },



    }
}
</script>

<style scoped></style>