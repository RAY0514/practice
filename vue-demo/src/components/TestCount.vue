<template>
<!--  <div id="app">-->
<!--    <button onclick="count++">{{ text }}:{{ count }}</button>-->
<!--    <h1>{{x.message}}</h1>-->
<!--  </div>-->
</template>

<script>
export default {
  name: "TestCount"
}
import {createApp} from 'vue'

const app = createApp({
  data() {
    return {
      count: 0,
      text: "sfa"
    }
  }
})

app.mount('#app')

const x = [
  {
    message:"fwefw"
  }
]


</script>

<style scoped>

</style>