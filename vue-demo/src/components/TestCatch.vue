<template>
  <div id="app" >
    {{ apps.x }}
  </div>

</template>

<script>
export default {
  name: "TestCatch"
}
const apps = reactive({
  x: "dasdaa"
})
</script>

<style scoped>

</style>