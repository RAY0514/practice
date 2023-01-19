<template>
<!--  <search-member></search-member>-->
<!--  <insert-page></insert-page>-->

  <div id="nav">
    <router-link to="/"> 首頁 </router-link> |
    <router-link to="/insertPage"> 新增頁面 </router-link>
  </div>
  <router-view />

</template>

<script setup>
// import searchMember from './components/searchMember.vue'
// import insertPage from './components/insertPage.vue'
//
// export default {
//   name: 'App',
//   components: {
//     searchMember, // eslint-disable-line no-unused-vars
//
//     insertPage// eslint-disable-line no-unused-vars
//
//
//
//   }
// }
import {provide, ref, nextTick} from 'vue'
const isRouterAlive = ref(true)

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
