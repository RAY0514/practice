<template>
  <HelloWorld msg="Welcome to Your Vue.js App"/>
<!--  <test-count/>-->
<!--  <test-for/>-->
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
// import TestCount from './components/TestCount.vue'

// import TestFor from './components/TestFor.vue'



export default {
  name: 'App',
  components: {
    HelloWorld
    // TestCount
    // TestFor
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
