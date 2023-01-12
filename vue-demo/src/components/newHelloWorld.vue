<template>
  <h1>新增功能</h1>
  <div class="input-item">
    <label class="form-label" for="input01">
      <span style="color: red">*</span>
      學號
    </label>
    <input
        id="input01"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="input.num"

    />
    <br>
    <label class="form-label" for="input02">
      姓名
    </label>
    <input
        id="input02"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="input.name"
    />
    <br>
    <label class="form-label" for="input03">
      性別
    </label>
    <input
        id="input03"
        class="form-control"
        type="text"
        name="text"
        required
        v-model="input.gender"
    />
    <br>
    <label class="form-label" for="input01">
      職業
    </label>
    <select
        class="form-select"
        aria-label="select"
        v-model="input.select"
    >
      {{ input.select }}
      <option selected value="teacher">
        老師
      </option>
      <option value="student">
        學生
      </option>
    </select>
    <br>
    <div v-if="input.select== 'teacher'">
      <label class="form-label" for="input04">
        科目
      </label>
      <input
          id="input04"
          class="form-control"
          type="text"
          name="text"
          required
          v-model="input.subject"
      />
      <br>
      <label class="form-label" for="input05">
        職位
      </label>
      <input
          id="input05"
          class="form-control"
          type="text"
          name="text"
          required
          v-model="input.jobTitle"
      />
      <br>
    </div>

    <div v-if="input.select== 'student'">
      <label class="form-label" for="input06">
        班級
      </label>
      <input
          id="input06"
          class="form-control"
          type="text"
          name="text"
          required
          v-model="input.class"
      />
      <br>
      <label class="form-label" for="input07">
        入學年度
      </label>
      <input
          id="input07"
          class="form-control"
          type="text"
          name="text"
          required
          v-model="input.admissionYearMonth"
      />
    </div>
  </div>
  <br>
  <button
      type="button"
      class="btn btn-primary"
      @click="clear()"
  >
    清除
  </button>
  <button
      type="button"
      class="btn btn-primary"
      @click="insert()"
  >
    新增
  </button>
  {{ input.select }}
</template>

<script setup>
// export default {
//   name: 'HelloWorld',
//   props: {
//     msg: String
//   }
// }
import {reactive, ref} from 'vue'

let searchList = ref([])
const input = reactive({
  num: "",
  name: "",
  gender: "",
  subject: "",
  jobTitle: "",
  class: "",
  admissionYearMonth: "",
  select: ""
})

function insert() {
  if (input.num == "") {
    alert("請輸入學號")
  } else {
    searchList.value.push(input.num)
    searchList.value.push(input.name)
    searchList.value.push(input.gender)
    searchList.value.push(input.subject)
    searchList.value.push(input.jobTitle)
    searchList.value.push(input.class)
    searchList.value.push(input.admissionYearMonth)
  }
  console.log(searchList.value)
}

function clear() {
  input.num="",
  input.name="",
  input.gender="",
  input.subject="",
  input.jobTitle="",
  input.class="",
  input.admissionYearMonth=""
}

</script>
