<template>
  <div class="flex flex-col min-w-[1280px] h-full">
    <Header />

    <SideSubHeader />
    
    <main class="container !max-w-full flex flex-1 justify-center my-[100px] pt-[90px]">
      <div class="flex flex-col px-[103px]">
        <slot></slot>
      </div>
    </main>
    <Footer />
  </div>
</template>
<script lang="ts" setup>
import Footer from '@/components/layouts/footer.vue';
import Header from '@/components/layouts/header.vue';
import SideSubHeader from '@/components/layouts/subHeader.vue';
</script>
<style lang="scss"></style>
