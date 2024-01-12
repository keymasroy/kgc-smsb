<template>
  <div class="flex flex-col h-full">
    <subMainHeader />
    <main class="container !max-w-full bg-white flex flex-col flex-1">
      <slot></slot>
    </main>
    <SubFooter />
  </div>
</template>
<script lang="ts" setup>
import SubFooter from '@/components/mobile/layouts/subFooter.vue';
import subMainHeader from '@/components/mobile/layouts/subMainHeader.vue';

</script>
<style lang="scss"></style>
