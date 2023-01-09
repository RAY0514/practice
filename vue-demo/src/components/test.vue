<template>
<!--  <h1>123</h1>-->
<!--  <div id="app">-->
<!--    {{ name }} 好棒棒!-->
<!--  </div>-->
  <li v-for="(item, index) in items">
    {{ parentMessage }} - {{ index }} - {{ item.message }}
  </li>
</template>

<script setup>
export default {
  data() {
    return {
      parentMessage: 'parent',
      items: [{message: 'Foo'}, {message: 'Bar'}]

    }
  }
}
// let name = "sada"


// const test = {
//   data() {
//     return {
//       name: 'Hello Vue!!'
//     }
//   }
// }
// // eslint-disable-next-line no-undef
// test.mount('app')
</script>

<style scoped>

</style>