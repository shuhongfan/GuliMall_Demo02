<template>
  <el-dialog :visible.sync="visible" :title="!dataForm.id ? $t('add') : $t('update')" :close-on-click-modal="false"
             :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmitHandle()"
             :label-width="$i18n.locale === 'en-US' ? '120px' : '80px'">
      <el-form-item label="品牌名" prop="name">
        <el-input v-model="dataForm.name" placeholder="品牌名"></el-input>
      </el-form-item>
      <el-form-item label="品牌logo地址" prop="logo">
<!--        <el-input v-model="dataForm.logo" placeholder="品牌logo地址"></el-input>-->
        <single-upload v-model="dataForm.logo" />
      </el-form-item>
      <el-form-item label="介绍" prop="descript">
        <el-input v-model="dataForm.descript" placeholder="介绍"></el-input>
      </el-form-item>
      <el-form-item label="显示状态" prop="showStatus">
        <template slot-scope="scope">
          <el-switch :active-value="1" :inactive-value="0" v-model="dataForm.showStatus"/>
        </template>
        </el-table-column>
      </el-form-item>
      <el-form-item label="检索首字母" prop="firstLetter">
        <el-input v-model="dataForm.firstLetter" placeholder="检索首字母"></el-input>
      </el-form-item>
      <el-form-item label="排序" prop="sort">
        <el-input v-model.number="dataForm.sort" placeholder="排序"></el-input>
      </el-form-item>
    </el-form>
    <template slot="footer">
      <el-button @click="visible = false">{{ $t('cancel') }}</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle()">{{ $t('confirm') }}</el-button>
    </template>
  </el-dialog>
</template>

<script>
import debounce from 'lodash/debounce'
import SingleUpload from "@/components/upload/singleUpload";

export default {
  components: {SingleUpload},
  data() {
    return {
      visible: false,
      dataForm: {
        id: '',
        name: '',
        logo: '',
        descript: '',
        showStatus: 1,
        firstLetter: '',
        sort: 0,
        creator: '',
        createDate: ''
      }
    }
  },
  computed: {
    dataRule() {
      return {
        name: [
          {required: true, message: this.$t('validate.required'), trigger: 'blur'}
        ],
        logo: [
          {required: true, message: this.$t('validate.required'), trigger: 'blur'}
        ],
        descript: [
          {required: true, message: this.$t('validate.required'), trigger: 'blur'}
        ],
        showStatus: [
          {required: true, message: this.$t('validate.required'), trigger: 'blur'}
        ],
        firstLetter: [
          {validator: (rule, value, callback)=>{
              if (value==''){
                callback(new Error("首字母必须填写"))
              } else if (!/^[a-zA-Z]$/.test(value)){
                callback(new Error("首字母必须a-z或者A-Z之间"))
              } else {
                callback()
              }
            }, trigger: 'blur'}
        ],
        sort: [
          {validator: (rule, value, callback)=>{
              if (value==''){
                callback(new Error("排序字段必须填写"))
              } else if (!Number.isInteger(value)||value<0){
                callback(new Error("排序必须是大于等于0的整数"))
              } else {
                callback()
              }
            },  trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    init() {
      this.visible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].resetFields()
        if (this.dataForm.id) {
          this.getInfo()
        }
      })
    },
    // 获取信息
    getInfo() {
      this.$http.get(`/product/brand/${this.dataForm.id}`).then(({data: res}) => {
        if (res.code !== 0) {
          return this.$message.error(res.msg)
        }
        this.dataForm = {
          ...this.dataForm,
          ...res.data
        }
      }).catch(() => {
      })
    },
    // 表单提交
    dataFormSubmitHandle: debounce(function () {
      this.$refs['dataForm'].validate((valid) => {
        if (!valid) {
          return false
        }
        this.$http[!this.dataForm.id ? 'post' : 'put']('/product/brand/', this.dataForm).then(({data: res}) => {
          if (res.code !== 0) {
            return this.$message.error(res.msg)
          }
          this.$message({
            message: this.$t('prompt.success'),
            type: 'success',
            duration: 500,
            onClose: () => {
              this.visible = false
              this.$emit('refreshDataList')
            }
          })
        }).catch(() => {
        })
      })
    }, 1000, {'leading': true, 'trailing': false})
  }
}
</script>
