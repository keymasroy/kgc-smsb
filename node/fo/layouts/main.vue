<template>
  <div class="flex flex-col min-w-[1280px] h-full">
    <Header />
    <main class="container !max-w-full flex flex-col !flex-1 pt-[70px]">
      <slot></slot>
    </main>
    <Footer />
  </div>
</template>
<script lang="ts" setup>
import Footer from '@/components/layouts/footer.vue';
import Header from '@/components/layouts/main-header.vue';
</script>
<style lang="scss"></style>
