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
        @change="selectChange"
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
</template>

<script setup>
import {reactive} from 'vue'
import axios from "axios";
import {useRouter} from "vue-router";

const input = reactive({
  num: null,
  name: null,
  gender: null,
  subject: null,
  jobTitle: null,
  class: null,
  admissionYearMonth: null,
  select: null
})

let memberList = reactive([])
const backData = axios  // eslint-disable-line no-unused-vars
    .get("http://localhost:8081/rest/getAllMember")
    .then(({data}) => {
      console.log(data)
      memberList = data
    })

const router = useRouter()

function insert() {
  if (input.num == "") {
    alert("請輸入學號")
  } else if (input.num != "") {
    for (let i = 0; i < memberList.length; i++) {
      console.log(memberList[i].id)
      if (memberList[i].id == input.num) {
        alert("此筆資料已存在")
        return;
      }
    }
    axios
        .post("http://localhost:8081/rest/insert",
            {
              id: input.num,
              name: input.name,
              gender: input.gender,
              subject: input.subject,
              jobTitle: input.jobTitle,
              admissionYearMonth: input.admissionYearMonth,
              classes: input.class
            }
        )
        .then(response => {
          console.log(response.status)
          console.log(response.data)
          router.go(0)
          if (response.status == 200) {
            alert("新增成功")
          } else {
            alert("新增失敗")
          }
        })
    router.push({path: "/"})
  }
}

function clear() {
  input.num = null,
      input.name = null,
      input.gender = null,
      input.subject = null,
      input.jobTitle = null,
      input.class = null,
      input.admissionYearMonth = null
}

function selectChange() {
  input.subject = null,
      input.jobTitle = null,
      input.class = null,
      input.admissionYearMonth = null
}

</script>
