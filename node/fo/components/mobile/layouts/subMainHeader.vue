<template>
  <header :class="{ '!bg-[#FFF]': headerActive }" class="header flex-none w-full bg-transparent h-[50px] p-[15px]">
    <div class="flex justify-between h-full">
      <router-link to="/">
        <img v-if="!headerActive" src="@/assets/images/svg/logo-white-mobile.svg" alt="JUNG KWAN JANG Members" />
        <img v-else src="@/assets/images/svg/logo-mobile.svg" alt="JUNG KWAN JANG Members" />
      </router-link>

      <button>
        <img :style="{ filter: !headerActive ? 'invert(1)' : ''}" src="@/assets/images/svg/ico_menu.svg" alt="메뉴 아이콘">
      </button>
    </div>
  </header>
</template>

<script setup>
import { useScroll, watchThrottled } from '@vueuse/core';
import { ref } from 'vue';

const { y: winScoll } = useScroll(document);
const headerActive = ref(false);

watchThrottled(
  () => winScoll.value,
  newValue => {
    if (winScoll.value > 0) {
      headerActive.value = true;
      // document.querySelector('.header').classList.add('active');
    } else {
      headerActive.value = false;
      // document.querySelector('.header').classList.remove('active');
    }
  },
  { throttle: 200 },
);
</script>

<style lang="scss" scoped>
.header {
  z-index: 30;
  position: fixed;
  transition: 0.2s all;
}

.gnb {
  display: flex;
  margin-top: 37px;

  > a {
    width: 160px;
    font-weight: 700;
    font-size: 17px;
    text-align: center;
    color: white;
  }
}

.sign-nav {
  display: flex;
  align-items: center;
  height: 100%;
  > a {
    position: relative;
    color: white;

    &:not(:first-child) {
      margin-left: 8px;
      padding-left: 8px;

      &::before {
        content: '';
        position: absolute;
        top: 50%;
        left: 0;
        transform: translateY(-50%);
        width: 1px;
        height: 10px;
        background-color: #e7e7e7;
      }
    }
  }
}
</style>
