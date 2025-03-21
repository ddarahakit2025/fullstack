<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
const feeds = ref([]);
    const loading = ref(true);
    const error = ref(null);

const fetchFeeds = async () => {
  try {
    const response = await axios.get('/feed/list');
    feeds.value = response.data;
  } catch (err) {
    error.value = '데이터를 불러오는 중 오류가 발생했습니다.';
    console.error(err);
  } finally {
    loading.value = false;
  }
};

onMounted(fetchFeeds);
</script>

<template>
  <main>
    <TheWelcome />
  </main>
</template>
