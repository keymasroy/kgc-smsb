<template>
  <div class="flex flex-col items-center w-full mt-[88px] mb-[50px] mx-auto">
    <div class="tabInner__title ">
      <h2>멤버스 소개</h2>
      <p>
        정관장 멤버스는 정관장몰, 케어나우, 사푼사푼의 혜택을 누릴 수 있는 정관장 통합 서비스입니다.
        <br />
        정관장 멤버스 회원이 되면 KGC인삼공사에서 진행하는 각종 혜택도 누릴 수 있습니다.
      </p>
    </div>

    <div class="flex gap-[16px] mt-[80px] w-full justify-center">
      <div class="card level">
        <h3>등급별 혜택</h3>
        <p> {{ `멤버스 회원에게 제공하는\n차별화된 혜택` }}</p>
      </div>
      <div class="card point1">
        <h3>포인트 적립</h3>
        <p> {{ `전국 정관장 매장, 정관장몰,\n 케어나우, 사푼사푼 카페` }}</p>
      </div>
      <div class="card point2">
        <h3>포인트 사용</h3>
        <p> {{ `전국 정관장 매장, 정관장몰, \n 케어나우, 사푼사푼 카페` }}</p>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">

definePageMeta({
  layout: 'side'
});

</script>

<style scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;

  &.border-b {
    border-color: #ECF0F8;
    padding: 0 16.5px 40px;
    margin: auto;
  }

  h2 {
    font-weight: 700;
    font-size: 40px;
    line-height: 60px;
  }

  p {
    color: var(--j-gray500);
    margin-top: 8px;
    font-size: 16px;
    line-height: 24px;
  }
}

/* == 멤버스 소개 == */
.card {
  background-color: #FBFBFB;
  border-radius: 16px;
  padding: 30px 30px;
  position: relative;
  display: flex;
  flex-direction: column;
  height: 300px;
  width: 316px;

  h3 {
    font-weight: 500;
    font-size: 24px;
    line-height: 36px;
  }

  p {
    margin-top: 4px;
    color: var(--j-gray500);
    font-size: 15px;
    white-space: pre-line;
    line-height: 22.4px;
  }
  
  &.level::after {
    content: '';
    height: 120px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/level-benefit.svg');
    background-position: right bottom;
  }

  &.point1::after {
    content: '';
    height: 120px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/point-acml.svg');
    background-position: right bottom;
  }

  &.point2::after {
    content: '';
    height: 120px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/point-use.svg');
    background-position: right bottom;
  }
}
/* ============== */
</style>