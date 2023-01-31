<template>
  <div id="nav">
    <router-link to="/"> 首頁 </router-link> |
    <router-link to="/insertPage"> 新增頁面 </router-link>
  </div>
  <router-view />
</template>

<script setup>

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
