<template>
  <header class="sub-header">
    <button @click="$router.go(-1)">
      <img src="@/assets/images/svg/ico_back.svg" alt="뒤로가기">
    </button>
    <div class="header-title">
      <h1>{{ title }}</h1>
    </div>
    <button @click="onOpenSideMenu()">
      <img src="@/assets/images/svg/ico_menu.svg" alt="메뉴">
    </button>
  </header>
</template>

<script setup>
const route = useRoute();

const emit = defineEmits(['update:showSide']);

const onOpenSideMenu = () => {
  emit('update:showSide', true);
};

const title = computed(() => {
  return route.meta.title ? route.meta.title : '' ;
})
</script>

<style lang="scss" scoped>
.sub-header {
  width: 100%;
  height: 50px;
  min-height: 50px;
  padding: 10px 20px;
  display: grid;
  grid-template-columns: 24px auto 24px;
  column-gap: 5px;
  align-items: center;
  justify-items: center;
  position: fixed;
  background-color: var(--j-white);
  z-index: 3;
  border-bottom: 1px solid var(--j-gray200);

  .header-title{
    color: var(--j-black);
    font-size: 20px;
    font-weight: 700;
  }
}

</style>
