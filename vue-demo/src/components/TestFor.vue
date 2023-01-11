<template>
  <h1>123</h1>
  <div v-for=" (item,index) in a.items "  v-bind:key="item" v-bind:todo="item">
    {{ item }}
    {{index}}
  </div>

</template>

<script setup>
import {reactive} from "vue";


const s = reactive({// eslint-disable-line no-unused-vars
  actionList: [
    {
      id: "1",
      name: "Billy",
      gender: "male"
    }
  ]
})

const a = reactive({// eslint-disable-line no-unused-vars
  items:[
    {
      id: "1",
      name: "Billy",
      gender: "male"
    },
    {
      id: "2",
      name: "dasad",
      gender: "female"
    }
  ]
})


</script>
<style scoped>

</style>