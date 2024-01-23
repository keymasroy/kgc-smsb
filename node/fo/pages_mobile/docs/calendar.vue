<template>
  <div class="my-[30px] px-[50px]">
    <div>
      <h2 class="text-lg font-bold mb-[20px]">Date Picker Single</h2>

      <span class="d-block text-[#60738A] mb-[5px]"> enabled </span>
      <Calendar v-model="date" placeholder="2023-01-01" />

      <span class="d-block text-[#60738A] mt-[15px] mb-[5px]"> Hover </span>
      <Calendar class="is-focus" :ref="focusCalendar" tabIndex="0" focus v-model="date" placeholder="2023-01-01" />

      <span class="d-block text-[#60738A] mt-[15px] mb-[5px]"> disabled </span>
      <Calendar v-model="date" placeholder="2023-01-01" disabled="" />
    </div>

    <div class="mt-[40px]">
      <h2 class="text-lg font-bold mb-[20px]">Date Picker Group</h2>

      <span class="d-block text-[#60738A] mb-[5px]"> enabled </span>
      <div class="p-calendar-group w-full">
        <Calendar v-model="startDate" placeholder="2023-01-01" />
        <span class="range">~</span>
        <Calendar v-model="endDate" placeholder="2023-01-01" />
      </div>

      <span class="d-block text-[#60738A] mt-[15px] mb-[5px]"> disabled </span>
      <div class="p-calendar-group w-full">
        <Calendar v-model="startDate" placeholder="2023-01-01" disabled />
        <span class="range">~</span>
        <Calendar v-model="endDate" placeholder="2023-01-01" disabled />
      </div>
    </div>
  </div>
</template>

<script setup>
import { defaultOptions } from 'primevue/config';
import { onMounted, ref } from 'vue';

const date = ref(null);

const startDate = ref(null);
const endDate = ref(null);

const i18n = {
  dateFormat: 'yy-mm-dd',
  dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  showMonthAfterYear: true,
};

onMounted(() => {
  // Prime Vue Calendar 한국어 변경
  Object.assign(defaultOptions.locale, i18n);
});
</script>

<style lang="scss" scoped></style>
