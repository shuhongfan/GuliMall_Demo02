<template>
  <div>
    <el-switch v-model="draggable" active-text="开启拖拽" inactive-text="关闭拖拽"/>
    <el-button v-show="draggable==1" @click="batchSave">批量保存</el-button>
    <el-button type="danger" @click="batchDelete">批量删除</el-button>

    <el-tree
        ref="menuTree"
        :draggable="draggable"
        :default-expanded-keys="expandedKey"
        :expand-on-click-node="false"
        :data="dataList"
        show-checkbox
        node-key="id"
        @node-drop="handleDrop"
        :allow-drop="allowDrop"
        :props="defaultProps">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button
              v-if="node.level<=2"
              type="text"
              size="mini"
              @click="() => append(node,data)">
            Append
          </el-button>
          <el-button
              type="text"
              size="mini"
              @click="() => edit(node,data)">
            Edit
          </el-button>
          <el-button
              v-if="node.childNodes.length==0"
              type="text"
              size="mini"
              @click="() => remove(node,data)">
            Delete
          </el-button>
        </span>
      </span>
    </el-tree>

    <el-dialog :title="category.flag==0 ? $t('add') : $t('update')" :visible.sync="dialogFormVisible">
      <el-form :model="category">
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图标">
          <el-input v-model="category.icon" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="计量单位">
          <el-input v-model="category.productUnit" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitData()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import mixinViewModule from "@/mixins/view-module";

export default {
  mixins: [mixinViewModule],
  name: "category",
  data() {
    return {
      pCid: [],
      maxLevel: '',
      expandedKey: [],
      updateNodes: [],
      draggable: false,
      mixinViewModuleOptions: {
        getDataListURL: '/product/category/list/tree',
        activatedIsNeed: true,
        deleteURL: '/product/category',
        deleteIsBatch: true,
        deleteIsBatchKey: 'ids',
      },
      defaultProps: {
        children: 'children',
        label: 'name'
      },
      dialogFormVisible: false,
      category: {
        flag: 0,
        name: "",
        parentCid: 0,
        catLevel: 0,
        showStatus: 1,
        sort: 0,
        id: null,
        icon: '',
        productUnit: ''
      }
    };
  },
  methods: {
    append(node, data) {
      // console.log(node, data)
      this.category.flag = 0;
      this.dialogFormVisible = true;
      this.category.parentCid = data.id;
      this.category.catLevel = data.catLevel * 1 + 1;
      this.category.id = null;
      this.category.icon = "";
      this.category.productUnit = "";
      this.category.sort = 0;
      this.category.showStatus = 1;
    },
    edit(node, data) {
      // console.log(node, data)
      this.category.flag = 1;
      this.dialogFormVisible = true;
      this.category.id = data.id;
      // 发送请求获取当前节点的最新数据
      this.$http['get']('/product/category/' + this.category.id, this.category).then(({data: res}) => {
        if (res.code !== 0) {
          return this.$message.error(res.msg)
        }
        console.log(data)
        this.category.name = data.name;
        this.category.id = data.id;
        this.category.icon = data.icon;
        this.category.productUnit = data.productUnit;
        this.category.parentCid = data.parentCid;
        this.category.catLevel = data.catLevel;
        this.category.sort = data.sort;
        this.category.showStatus = data.showStatus;
      }).catch(() => {
      })

    },
    remove(node, data) {
      // console.log(node, data)
      this.deleteHandle(data.id);
      this.expandedKey = [node.parent.data.id];
    },
    // 添加/修改 三级分类
    submitData() {
      console.log(this.category)

      if (this.category.flag == 0) { // 添加
        this.$http['post']('/product/category', this.category).then(({data: res}) => {
          if (res.code !== 0) {
            return this.$message.error(res.msg)
          }
          this.$message({
            message: this.$t('prompt.success'),
            type: 'success',
            duration: 500,
            onClose: () => {
              this.dialogFormVisible = false
              this.expandedKey = [this.category.parentCid];
              this.category.name = "";
              this.query()
            }
          })
        }).catch(() => {
        })
      } else {  // 修改
        this.$http['put']('/product/category', this.category).then(({data: res}) => {
          if (res.code !== 0) {
            return this.$message.error(res.msg)
          }
          this.$message({
            message: this.$t('prompt.success'),
            type: 'success',
            duration: 500,
            onClose: () => {
              this.dialogFormVisible = false
              this.expandedKey = [this.category.parentCid];
              this.category.name = "";
              this.query()
            }
          })
        }).catch(() => {
        })
      }

    },
    allowDrop(draggingNode, dropNode, type) {
      // console.log(draggingNode, dropNode, type)
      // 1.被拖动的当前节点，以及所在的父节点的总层数不能大于3

      // 2.被拖动的当前节点的总层数
      this.countNodeLevel(draggingNode)
      // 当前正在 拖动的节点+父节点所在的深度 不大于3即可
      let deep = Math.abs(this.maxLevel - draggingNode.level) + 1;

      if (type == "inner") {
        return (deep + dropNode.level) <= 3
      } else {
        return (deep + dropNode.parent.level) <= 3;
      }
    },
    countNodeLevel(node) {
      // 找到所有子节点，求出最大深度
      if (node.childNodes != null && node.childNodes.length > 0) { // 当前节点有子节点
        for (let i = 0; i < node.childNodes.length; i++) {
          if (node.childNodes[i].level > this.maxLevel) {
            this.maxLevel = node.childNodes[i].level;
          }
          // 递归调用
          this.countNodeLevel(node.childNodes[i])
        }
      }
    },
    handleDrop(draggingNode, dropNode, dropType, ev) {
      // console.log(draggingNode, dropNode, dropType)
      // 1.当前节点最新的父节点id
      let pCid = 0;
      let siblings = null
      if (dropType == "before" || dropType == "after") {
        pCid = dropNode.parent.data.id == undefined ? 0 : dropNode.parent.data.id;
        siblings = dropNode.parent.childNodes
      } else {
        pCid = dropNode.data.id
        siblings = dropNode.childNodes
      }
      this.pCid.push(pCid);

      // 2.当前拖拽节点的最新顺序
      for (let i = 0; i < siblings.length; i++) {
        if (siblings[i].data.id == draggingNode.data.id) {
          // 如果遍历的是当前正在拖拽的节点
          let catLevel = draggingNode.level;
          if (siblings[i].level != draggingNode.level) { // 判断层级是否发生变化
            // 当前节点的层级发生变化
            catLevel = siblings[i].level;
            // 继续修改子节点层级 递归修改
            this.updateChildNodeLevel(siblings[i])
          }
          this.updateNodes.push({id: siblings[i].data.id, sort: i, parentCid: pCid, catLevel: catLevel})
        } else {
          this.updateNodes.push({id: siblings[i].data.id, sort: i})
        }
      }
      // 3.当前拖拽节点的最新层级
      // console.log(this.updateNodes)


    },
    updateChildNodeLevel(node) {
      if (node.childNodes.length > 0) {
        for (let i = 0; i < node.childNodes.length; i++) {
          let cNode = node.childNodes[i].data;
          this.updateNodes.push({id: cNode.id, catLevel: node.childNodes[i].level})
          this.updateChildNodeLevel(node.childNodes[i])
        }
      }
    },
    batchSave(){
      this.$http['put']('/product/category', this.updateNodes).then(({data: res}) => {
        if (res.code !== 0) {
          return this.$message.error(res.msg)
        }
        this.$message({
          message: this.$t('prompt.success'),
          type: 'success',
          duration: 500,
          onClose: () => {
            this.query()
            this.expandedKey = this.pCid
            this.updateNodes = []
            this.maxLevel = 0;
            // this.pCid = 0;
          }
        })
      }).catch(() => {
      })
    },
    batchDelete () {
      let catIds=[]
      let checkedNodes = this.$refs.menuTree.getCheckedNodes();
      // console.log("被选中的元素:",checkedNodes);

      for (let i = 0; i < checkedNodes.length; i++) {
        catIds.push(checkedNodes[i].id)
      }


      this.$confirm(`是否批量删除【${catIds}】菜单?`,"提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$http['delete']('/product/category', {data:catIds}).then(({data: res}) => {
          if (res.code !== 0) {
            return this.$message.error(res.msg)
          }
          this.$message({
            message: this.$t('prompt.success'),
            type: 'success',
            duration: 500,
            onClose: () => {
              this.query()
            }
          })
        }).catch(() => {
        }).catch(()=>{})
      })
    }
  }
}
</script>

<style scoped>

</style>
