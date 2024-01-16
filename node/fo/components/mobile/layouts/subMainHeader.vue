<template>
  <header :class="['header', { '!bg-[#FFF]': headerActive }]">
    <router-link to="/">
      <img v-if="!headerActive" src="@/assets/images/svg/logo-white-mobile.svg" alt="JUNG KWAN JANG Members" />
      <img v-else src="@/assets/images/svg/logo-mobile.svg" alt="JUNG KWAN JANG Members" />
    </router-link>

    <button @click="onOpenSideMenu()">
      <img :style="{ filter: !headerActive ? 'invert(1)' : '' }" src="@/assets/images/svg/ico_menu.svg" alt="메뉴">
    </button>
  </header>

  <header v-if="isLogin" class="userInfo">
    <span>홍길동님 안녕하세요.</span>

    <div class="userInfo__right">
      <span>
        <strong class="mr-[5px]">10,999</strong>P
      </span>
      <i class="barcode"></i>
      <i class="arrow" @click="handleOpenBarcode()"></i>
    </div>
  </header>
</template>

<script setup>
import { useScroll, watchThrottled } from '@vueuse/core';
import { ref } from 'vue';

const { y: winScoll } = useScroll(document);
const headerActive = ref(false);

const props = defineProps({
  /**
   * Side Menu Open 여부
   */
  showSide: {
    type: Boolean,
    default: true,
  },
  /**
   * Login 여부
   */
  isLogin: {
    type: Boolean,
    default: false
  }
})

const emit = defineEmits(['update:showSide', 'openBarcode']);

const onOpenSideMenu = () => {
  emit('update:showSide', true);
}

// Barcode 클릭 시 Barcode 화면 Open
const handleOpenBarcode = () => {
  emit('openBarcode', true);
};

watchThrottled(
  () => winScoll.value,
  newValue => {
    headerActive.value = winScoll.value > 0 ? true : false;
  },
  { throttle: 200 },
);
</script>

<style lang="scss" scoped>
header {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.header {
  z-index: 30;
  position: fixed;
  transition: 0.2s all;
  height: 50px;
  padding: 15px;
  background-color: transparent;
}

header.userInfo {
  height: 60px;
  position: absolute;
  top: 50px;
  background-color: var(--j-black);
  color: var(--j-white);
  font-size: 16px;
  z-index: 2;
  padding: 18px 20px;

  .userInfo__right {
    color: var(--j-primary02);
    display: flex;
    align-items: center;
    gap: 10px;
  }

  .barcode {
    height: 16px;
    width: 23.39px;
    background-image: url("data:image/svg+xml,%3Csvg width='30' height='16' viewBox='0 0 30 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M22.2667 1.28C22.2667 0.573076 22.9591 0 23.8133 0C24.6675 0 25.36 0.573075 25.36 1.28L25.36 14.72C25.36 15.4269 24.6675 16 23.8133 16C22.9591 16 22.2667 15.4269 22.2667 14.72L22.2667 1.28Z' fill='%23F46144'/%3E%3Cpath d='M6.80001 0.959999C6.80001 0.429806 7.31936 0 7.96001 0C8.60066 0 9.12001 0.429807 9.12001 0.96L9.12001 15.04C9.12001 15.5702 8.60066 16 7.96001 16C7.31936 16 6.80001 15.5702 6.80001 15.04L6.80001 0.959999Z' fill='%23F46144'/%3E%3Cpath d='M28.4533 0.639999C28.4533 0.286537 28.7996 0 29.2267 0C29.6538 0 30 0.286538 30 0.64L30 15.36C30 15.7135 29.6538 16 29.2267 16C28.7996 16 28.4533 15.7135 28.4533 15.36L28.4533 0.639999Z' fill='%23F46144'/%3E%3Cpath d='M11.44 0.448C11.44 0.200576 11.6824 0 11.9813 0C12.2803 0 12.5227 0.200576 12.5227 0.448L12.5227 15.552C12.5227 15.7994 12.2803 16 11.9813 16C11.6824 16 11.44 15.7994 11.44 15.552L11.44 0.448Z' fill='%23F46144'/%3E%3Cpath d='M14.5333 0.448C14.5333 0.200576 14.7757 0 15.0747 0C15.3736 0 15.616 0.200576 15.616 0.448L15.616 15.552C15.616 15.7994 15.3736 16 15.0747 16C14.7757 16 14.5333 15.7994 14.5333 15.552L14.5333 0.448Z' fill='%23F46144'/%3E%3Cpath d='M0.613343 1.6C0.613343 0.716345 1.47893 0 2.54668 0C3.61443 0 4.48001 0.716344 4.48001 1.6L4.48001 14.4C4.48001 15.2837 3.61443 16 2.54668 16C1.47893 16 0.613342 15.2837 0.613342 14.4L0.613343 1.6Z' fill='%23F46144'/%3E%3Cpath d='M17.3614 1.92C17.3614 0.859613 17.1187 0 18.4 0C19.6813 0 19.4387 0.859613 19.4387 1.92L19.4387 14.08C19.4387 15.1404 19.6813 16 18.4 16C17.1187 16 17.3614 15.1404 17.3614 14.08L17.3614 1.92Z' fill='%23F46144'/%3E%3C/svg%3E%0A");
  }

  .arrow {
    width: 20px;
    height: 20px;
    cursor: pointer;
    background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M6.67949 18.0448L5.49683 16.8621L12.359 9.99993L5.49683 3.13775L6.67949 1.95508L14.7243 9.99993L6.67949 18.0448Z' fill='%23F46144'/%3E%3C/svg%3E%0A");
  }
}
</style>
