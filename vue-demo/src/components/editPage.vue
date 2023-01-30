<template>
  <h1>編輯功能</h1>
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
        disabled
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
  <router-link to="/">
    <button
        type="button"
        class="btn btn-primary"
    >
      返回
    </button>
  </router-link>
  <router-link to="/">
    <button
        type="button"
        class="btn btn-primary"
        @click="updata()"
    >
      更新
    </button>
  </router-link>

</template>

<script setup>

// export default {
//   name: 'insertPage.vue',
//   props: {
//     msg: String
//   }
// }
import {reactive, ref} from 'vue'
import axios from "axios";
import {useRoute} from "vue-router";
import router from "@/router";

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

//取url的值
const route = useRoute()
console.log(route.query.name)
input.num = route.query.id,
    input.name = route.query.name,
    input.gender = route.query.gender,
    input.subject = route.query.subject,
    input.jobTitle = route.query.jobTitle,
    input.class = route.query.class,
    input.admissionYearMonth = route.query.admissionYearMonth

if (input.subject != null) {
  input.select = "teacher"
} else {
  input.select = "student"
}

function updata() {
  axios
      .put("http://localhost:8081/rest/update",
          {
            id: input.num,
            name: input.name,
            gender: input.gender,
            subject: input.subject,
            jobTitle: input.jobTitle,
            admissionYearMonth: input.admissionYearMonth,
            classes: input.class
          })
      .then(response => {
        console.log(response.status)
        router.go(0)
        if (response.status == 200) {
          alert("成功")
        }
      })
}
</script>
