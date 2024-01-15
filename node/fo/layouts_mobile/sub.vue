<template>
  <div class="flex flex-col h-full">
    <SubHeader v-model:showSide="showSide" />
    <main class="container !max-w-full bg-white flex flex-col flex-1 pt-[50px]">
      <slot></slot>
    </main>
    <SubFooter v-show="footerVisible"/>
  </div>

  <SubSideMenu
    v-model:showSide="showSide"
    v-model:isLogin="isLogin"
    @openBarcode="handleChangeBarcodeState"
  />
  <SubBarcode v-model:showBarcode="showBarcode" />
</template>
<script lang="ts" setup>
import SubFooter from '@/components/mobile/layouts/subFooter.vue';
import SubHeader from '@/components/mobile/layouts/subHeader.vue';
import SubSideMenu from '@/components/mobile/layouts/subSideMenu.vue';
import SubBarcode from '~/components/mobile/layouts/subBarcode.vue';

const route = useRoute();

// Side Menu Open 여부
const showSide = ref(false);

// Barcode Menu Open 여부
const showBarcode = ref(false);

// Login 여부
const isLogin = ref(false);

const handleChangeBarcodeState = (e) => {
  showBarcode.value = e;
};

const footerVisible = computed(() => {
  return route.meta.footer === "none" ? false : true ;
});

</script>
<style lang="scss"></style>
