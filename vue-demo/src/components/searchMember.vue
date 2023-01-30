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
    >
      <option value="">
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
    <thead v-if="showTitle">
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
      <th>
        功能
      </th>
    </tr>
    </thead>

    <tbody>
    <tr v-for="(member) in searchList"
        v-bind:key="member"
        v-bind:todo="member"
    >
      <td>
        {{ member.id }}
      </td>
      <td>
        {{ member.name }}
      </td>
      <td>
        {{ member.gender }}
      </td>

      <td v-if="member.subject !=null">
        {{ member.subject }}
      </td>
      <td v-else>無</td>

      <td v-if="member.jobTitle !=null">
        {{ member.jobTitle }}
      </td>
      <td v-else>無</td>

      <td v-if="member.classes !=null">
        {{ member.classes }}
      </td>
      <td v-else>無</td>

      <td v-if="member.admissionYearMonth !=null">
        {{ member.admissionYearMonth }}
      </td>
      <td v-else>無</td>

      <td>
        <button @click="deleteMember(member.id)">
          刪除
        </button>

        <router-link :to="{path:'/editPage',query:{
          id:member.id,
          name:member.name,
          gender:member.gender,
          subject:member.subject,
          jobTitle:member.jobTitle,
          class:member.classes,
          admissionYearMonth:member.admissionYearMonth,
        }}">
          <!--        <router-link to="/editPage">-->
          <button>
            編輯
          </button>
        </router-link>
      </td>
    </tr>
    </tbody>
  </table>

</template>


<script setup>
import {reactive, ref} from 'vue'
import axios from 'axios'
import {useRouter} from "vue-router";

//https://book.vue.tw/CH1/1-2-instance.html
//路由https://cn.vuejs.org/guide/scaling-up/routing.html#simple-routing-from-scratch
//http://localhost:8081/rest/getAllMember

//全部資料
let memberList = reactive([])
const backData = axios  // eslint-disable-line no-unused-vars
    .get("http://localhost:8081/rest/getAllMember")
    .then(({data}) => {
      console.log(data)
      memberList = data
    })

//全部老師
let teacherList = reactive([])
const backDataAllTeacher = axios  // eslint-disable-line no-unused-vars
    .get("http://localhost:8081/rest/all-teacher")
    .then(({data}) => {
      console.log(data)
      teacherList = data
    })

//全部學生
let studentList = reactive([])
const backDataAllStudent = axios  // eslint-disable-line no-unused-vars
    .get("http://localhost:8081/rest/all-student")
    .then(({data}) => {
      // console.log(data)
      studentList = data

    })

let showTitle = ref(false)

// const members = reactive({ // eslint-disable-line no-unused-vars
//   actionList: [
//     {
//       id: "1",
//       name: "Billy",
//       gender: "male",
//       subject: "數學",
//       jobTitle: "教務主任",
//       classes: "無",
//       admissionYearMonth: "無"
//     },
//     {
//       id: "2",
//       name: "Heidi",
//       gender: "female",
//       subject: "英文",
//       jobTitle: "教師",
//       classes: "無",
//       admissionYearMonth: "無"
//     },
//     {
//       id: "3",
//       name: "jacky",
//       gender: "male",
//       subject: "無",
//       jobTitle: "無",
//       classes: "301",
//       admissionYearMonth: "201910"
//     },
//     {
//       id: "4",
//       name: "Lawrence",
//       gender: "male",
//       subject: "無",
//       jobTitle: "無",
//       classes: "801",
//       admissionYearMonth: "201812"
//     },
//
//   ]
// })

var state = reactive({txt: ""})


const searchList = ref([])

function search() {
  this.showTitle = true
  this.searchList = []//資料渲染list
  let options = select.value//選擇框
  let dataIndex = state.txt//輸入框

  if (options == "teacher" && dataIndex == "") {//選老師 && 無輸入
    console.log("全部老師")
    for (let i = 0; i < teacherList.length; i++) {
      searchList.value.push(teacherList[i])
    }
    console.log(searchList.value)
  } else if (options == "student" && dataIndex == "") {//選學生 && 無輸入
    console.log("全部學生")
    for (let i = 0; i < studentList.length; i++) {
      searchList.value.push(studentList[i])
    }
  } else if (options == "" && (dataIndex == "")) {//都沒輸入
    console.log("全部資料")
    for (let i = 0; i < memberList.length; i++) {
      searchList.value.push(memberList[i])
    }
  } else {
    if (dataIndex - 1 < memberList.length) {
      searchList.value.push(memberList[dataIndex - 1])
    } else {
      alert("無此資料")
    }
  }
}


let select = ref("")
const router = useRouter()

function deleteMember(index) {
  console.log(searchList.value[index])
  this.showTitle = false
  this.searchList = []
  console.log(index)
  axios.delete("http://localhost:8081/rest/delete?id=" + index)
      .then(res => {
        console.log(res.data);
        router.go(0)
        alert("刪除成功")
      });
}

function clearButt() {
  state.txt = ""
  this.searchList = []
  showTitle = false
}

</script>
