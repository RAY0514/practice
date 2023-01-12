<template>
<!--  <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--  <test-count/>-->
<!--  <test-for/>-->
<new-hello-world></new-hello-world>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import TestCount from './components/TestCount.vue'

// import TestFor from './components/TestFor.vue'
import newHelloWorld from './components/newHelloWorld.vue'



export default {
  name: 'App',
  components: {
    // HelloWorld
    // TestCount
    // TestFor
    newHelloWorld
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
