<template>
  <div class="flex flex-col h-full">
    <SubMainHeader v-model:showSide="showSide" />
    <main class="container !max-w-full bg-white flex flex-col flex-1">
      <slot></slot>
    </main>
    <SubFooter />
  </div>

  <SubSideMenu v-model:showSide="showSide" @openBarcode="handleChangeBarcodeState" />
  <SubBarcode v-model:showBarcode="showBarcode" />
</template>
<script lang="ts" setup>
import SubFooter from '@/components/mobile/layouts/subFooter.vue';
import SubMainHeader from '@/components/mobile/layouts/subMainHeader.vue';
import SubSideMenu from '@/components/mobile/layouts/subSideMenu.vue';
import SubBarcode from '~/components/mobile/layouts/subBarcode.vue';

// Side Menu Open 여부
const showSide = ref(false);

// Barcode Menu Open 여부
const showBarcode = ref(false);

const handleChangeBarcodeState = (e) => {
  showBarcode.value = e;
}

</script>
<style lang="scss"></style>
