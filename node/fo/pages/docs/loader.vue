<template>
  <div class="my-[30px] px-[120px] w-full">
    <h2 class="text-[30px] font-bold mb-[20px]">Loader</h2>
    
    <div class="center">
      <Loader />
    </div>

  </div>
</template>

<script setup>

import Loader from '@/components/Loader.vue';

</script>

<style lang="scss" scoped>
.center {
  position: absolute;
  right: 45%;
  top: 38%;
}
</style>
