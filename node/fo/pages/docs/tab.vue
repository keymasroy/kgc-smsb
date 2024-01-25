<template>
  <div class="my-[30px] px-[120px] w-[500px]">
    <h2 class="text-lg font-bold mb-[20px]">1 Depth Tab</h2>

    <TabView class="default_tab">
      <TabPanel header="1 Tab" />
      <TabPanel header="2 Tab" />
    </TabView>

    <h2 class="text-lg font-bold mt-[100px] mb-[20px]">2 Depth Tab</h2>

    <div class="search__tab">
      <span
        v-for="(type, i) in selectType"
        :key="i"
        @click.prevent="selected = type.value"
        :class="{ selected: selected == type.value }"
      >
        {{ type.label }}
      </span>
    </div>

    <h2 class="text-lg font-bold mt-[100px] mb-[20px]">소개 탭</h2>

    <TabView class="fill_tab w-[500px]" v-model:activeIndex="activeTab">
      <TabPanel header="Label 1" />
      <TabPanel header="Label 2" />
    </TabView>

  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const activeTab = ref(0);
const selected = ref('all');
const selectType = ref([
  { label: '전체', value: 'all' },
  { label: '온라인', value: 'online' },
  { label: '오프라인', value: 'offline' },
]);
</script>

<style lang="scss" scoped>
.search__tab {
  span {
    cursor: pointer;
    font-size: 15px;
    &.selected {
      font-weight: 700;
    }

    & + span::before {
      content: '';
      background-image: url("data:image/svg+xml,%3Csvg width='1' height='15' viewBox='0 0 1 15' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Crect y='0.5' width='1' height='14' fill='%23D9D9D9'/%3E%3C/svg%3E%0A");
      background-repeat: no-repeat;
      width: 1px;
      height: 14px;
      display: inline-block;
      margin: 0 12px;
    }
  }
}

</style>
