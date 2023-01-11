<template>
  <h1>查詢功能</h1>
  <div class="input-item">
    <label class="form-label" for="input01">
      學號
    </label>
    <input
        id="input01"
        class="form-control"
        type="text"
        name="text"
        required
        v-model.number="state.txt"
    />
    <br>
    <label class="form-label" for="input01">
      職位{{ select.value }}
    </label>
    <!--  v-model  選單裡面選甚麼 selected 的值就是什麼 -->
    <select
        class="form-select"
        aria-label="select"
        v-model="select"
        @change="selectData()"
    >
      <option selected>
        無
      </option>
      <option value="teacher">
        老師
      </option>
      <option value="student">
        學生
      </option>
    </select>
  </div>
  <br>
  <button
      type="button"
      class="btn btn-primary"
      @click="clearButt()"
  >
    清除
  </button>
  <button
      type="button"
      class="btn btn-primary"
      @click="search()"
  >
    查詢
  </button>
  <br><br><br><br><br>
  <table style="margin-left: auto;margin-right: auto;">
    <thead>
    <tr>
      <th class="white-space-nowrap">
        學號
      </th>
      <th class="white-space-nowrap">
        姓名
      </th>
      <th class="white-space-nowrap">
        性別
      </th>
      <th class="white-space-nowrap">
        科目
      </th>
      <th class="white-space-nowrap">
        職位
      </th>
      <th class="white-space-nowrap">
        班級
      </th>
      <th class="white-space-nowrap">
        入學年度
      </th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>
        1
      </td>
      <td>
        jacky
      </td>
      <td>
        男
      </td>
      <td>
        無
      </td>
      <td>
        無
      </td>
      <td>
        301
      </td>
      <td>
        201910
      </td>
    </tr>
    </tbody>
    <tbody>
    <tr v-for="member in searchList"
        v-bind:key="member"
        v-bind:todo="member">
      <td>
        {{ member.id }}
      </td>
      <td>
        {{ member.name }}
      </td>
      <td>
        {{ member.gender }}
      </td>
      <td>
        {{ member.subject }}
      </td>
      <td>
        {{ member.jobTitle }}
      </td>
      <td>
        {{ member.classes }}
      </td>
      <td>
        {{ member.admissionYearMonth }}
      </td>
    </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>

</template>

<script setup>
//https://book.vue.tw/CH1/1-2-instance.html

import {reactive, ref} from 'vue'
//
// export default {
//   name: 'HelloWorld',
//   props: {
//     msg: String
//   },
//

const members = reactive({
  actionList: [
    {
      id: "1",
      name: "Billy",
      gender: "male",
      subject: "數學",
      jobTitle: "教務主任",
      classes: "無",
      admissionYearMonth: "無"
    },
    {
      id: "2",
      name: "Heidi",
      gender: "female",
      subject: "英文",
      jobTitle: "教師",
      classes: "無",
      admissionYearMonth: "無"
    },
    {
      id: "3",
      name: "jacky",
      gender: "male",
      subject: "無",
      jobTitle: "無",
      classes: "301",
      admissionYearMonth: "201910"
    },
    {
      id: "4",
      name: "Lawrence",
      gender: "male",
      subject: "無",
      jobTitle: "無",
      classes: "801",
      admissionYearMonth: "201812"
    },

  ]
})

var state = reactive({txt: ""})

function clearButt() {
  state.txt = ""
  this.searchList = []
}

const searchList = ref([])

function search() {
  console.log(state.txt)
  let dataIndex = state.txt
  if (dataIndex-1 < members.actionList.length) {
    console.log(members.actionList[dataIndex])
    searchList.value.push(members.actionList[dataIndex -1])
  } else {
    alert("無此資料")
  }
}


let select = ref("")

function selectData() {
  let options = select.value
  if (options == "teacher") {//是老師
    console.log("全部老師")
  } else if (options == "student") {
    console.log("全部學生")
  }else {
    console.log("全部資料")
  }

}
</script>
