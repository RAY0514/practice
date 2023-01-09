<template>
  <div>
    <!--    為了連結<label>和<input> for 和 id 的值必須相同-->
    <input type="checkbox" id="todo-item" checked="false"/>
    <label for="todo-item">{{label}}</label>
  </div>
</template>

<script>
export default {

  name: "ToDoItem",
  props:{
    label :{ required :true ,type:String},
    done:{default : false, type:Boolean}
  },
  data(){
    return{
      isDon:this.done
    };
  }

}
</script>

<style scoped>

</style>