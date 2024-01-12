<template>
  <div class="w-[684px] m-auto py-[60px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="text-center text-[38px] font-bold">정관장 멤버스 통합회원 ONE ID 통합</h2>
    <div class="w-[200px] h-[146px] my-[40px] mx-auto">
      <img src="@/assets/images/sign/one-id.png" alt="통합회원 ONE ID 아이콘" />
    </div>

    <p class="text-base text-center">
      <strong>이미 정관장 회원이십니다.</strong><br />
      <strong>ONE ID 통합 회원이 되시면 더 다양한 서비스를 이용하실 수 있습니다.</strong>
    </p>

    <p class="text-base text-center mt-[16px]">
      ONE ID는 정관장 멤버스, 정관장몰, 케어나우 서비스를 하나로 이용하실 수 있습니다.<br />
      ONE ID로 사용해도 이전에 이용하신 서비스 이력 정보를 확인하실 수 있습니다.
    </p>
    <Button class="block w-[270px] mx-auto mt-[40px]" label="ONE ID 만들기" size="large" />
  </div>
</template>

<script setup>
import { ref } from 'vue';

// input
const userName = ref('');
const userPhone = ref('');

// dropdown
const firstNumber = ref();
const lastNumbers = ref([
  { name: '010', code: 'skt' },
  { name: '019', code: 'lg' },
]);
</script>

<style lang="scss" scoped></style>
