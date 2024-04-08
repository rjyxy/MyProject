<script setup>
import { ref } from "vue";
import axios from "axios";

const user = ref({
  username: "yxy",
  password: "123456",
  age: 23,
  phone: "18851683576",
  sdCard:"555111000888222333"
});

const visible = ref(false);

const submit = () => {
  axios
    .post("http://localhost:8080/user/add",user.value)
    .then((res) => {
      console.log(res);
      if (res.data.code === 200 ) {
        user.value = res.data.data;
        visible.value = true;
      } else {
        alert(res.data.msg);
      }
    })
    .catch((error) => {
      console.log(error);
    });
}
</script>

<template>
  <div>
    <input type="text" placeholder="username" v-model="user.username" />
    <input type="text" placeholder="password" v-model="user.password" />
    <input type="text" placeholder="age" v-model="user.age" />
    <input type="text" placeholder="phone" v-model="user.phone" />
    <input type="text" placeholder="sdCard" v-model="user.sdCard">
    <button @click="submit">提交</button>

    <div v-if="visible">
      <h3>{{ user.username }}</h3>
      <p>{{ user.phone }}</p>
    </div>
    <h3 v-else>还未注册</h3>
  </div>
</template>

<style scoped>
</style>
