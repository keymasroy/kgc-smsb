<template>
  <!-- 쿠폰 조회 -->
  <div class="flex flex-col items-center m-[20px] ma-auto">
    <i class="warning mb-[24px]"></i>
    <h2 class="text-[38px] mb-[16px]">페이지를 찾을 수 없습니다.​</h2>
    <p class="text-[18px] text-[#222222] text-center">
      요청하신 페이지를 찾을 수 없습니다.​ <br/>
      잘못된 경로로 접근 하셨거나, 사용할 수 없는 주소입니다.<br/>
      이용에 불편을 드려 대단히 죄송합니다.​<br/>
    </p>

    <Button class="homeBtn" label="홈으로 가기" size="large" />
  </div>
</template>

<script setup lang="ts">
</script>

<style lang="scss" scoped>
.warning {
  background-image: url("data:image/svg+xml,%3Csvg width='52' height='53' viewBox='0 0 52 53' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_2532_14891)'%3E%3Ccircle cx='26' cy='26.5' r='26' fill='%23D20F27'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M26 13.5C24.8954 13.5 24 14.3954 24 15.5V29.5C24 30.6046 24.8954 31.5 26 31.5C27.1046 31.5 28 30.6046 28 29.5V15.5C28 14.3954 27.1046 13.5 26 13.5ZM26 34C24.6193 34 23.5 35.1193 23.5 36.5C23.5 37.8807 24.6193 39 26 39C27.3807 39 28.5 37.8807 28.5 36.5C28.5 35.1193 27.3807 34 26 34Z' fill='white'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_2532_14891'%3E%3Crect width='52' height='52' fill='white' transform='translate(0 0.5)'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
  width: 52px;
  height: 52px;
}

.homeBtn {
  margin-top: 60px;
  width: 270px;
  height: 53px;
}
</style>
