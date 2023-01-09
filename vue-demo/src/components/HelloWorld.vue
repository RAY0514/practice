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
    />
    <br>
    <label class="form-label" for="input01">
      職位
    </label>
    <select
        class="form-select"
        aria-label="select"
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
  >
    清除
  </button>
  <button
      type="button"
      class="btn btn-primary"
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
    <tr>
      <td>
        {{ test.id }}
      </td>
      <td>
        {{ name }}
      </td>
      <td>
        {{ gender }}
      </td>
      <td>
        {{ subject }}
      </td>
      <td>
        {{ jobTitle }}
      </td>
      <td>
        {{ classes }}
      </td>
      <td>
        {{ admissionYearMonth }}
      </td>
    </tr>
    </tbody>
  </table>

</template>

<script setup>
import { reactive } from 'vue'



// export default {
//   name: 'HelloWorld',
//   props: {
//     msg: String
//   }
// }

const test = reactive({
  actionList: [
    {
      id: "1",
      name: "Billy",
      gender: "male",
      subject: "數學",
      jobTitle: "教務主任",
      classes: "無",
      admissionYearMonth: "無"
    }
  ]
})

</script>
