<template>
<!--  <HelloWorld msg="Welcome to Your Vue.js App"/>-->
  <HelloWorld/>
<!--  <test/>-->

</template>

<script>
 import HelloWorld from './components/HelloWorld.vue'
//匯入 ToDoItem 元件
//import ToDoItem from './components/ToDoItem.vue'
 import test from './components/test.vue'


 export default {
  name: 'App',
  components: {
    // //在components 註冊 HelloWorld 元件
    // HelloWorld
    // ToDoItem
    HelloWorld
    // test
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
