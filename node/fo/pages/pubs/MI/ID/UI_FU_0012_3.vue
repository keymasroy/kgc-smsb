<template>
  <div class="flex flex-col items-center my-[80px] w-[980px]">
    <div class="tabInner__title">
      <h2>포인트 쓰기</h2>
      <p>정관장 전국 가맹점 매장과 정관장몰에서 포인트를 현금처럼 사용하실 수 있습니다.</p>
    </div>

    <div class="mt-[60px] flex gap-[16px]">
      <div class="card store">
        <h3>가맹점</h3>
      </div>
      <div class="card mall">
        <h3>정관장몰</h3>
      </div>
      <div class="card sapun">
        <h3>사푼사푼</h3>
      </div>
    </div>

    <span class="desc">
      면세점에서는 포인트 사용 제외
    </span>

    <div class="banner">
      <div class="banner__inner">
        <div class="banner__left">
          <h3 class="title">
            포인트 선물하기를 <br />
            하실 수 있습니다.
          </h3>
          <p class="content">
            차곡차곡 쌓아 둔 포인트 선물이 가능 해졌습니다. <br />
            선물가능 포인트 확인 후 선물 받을 정관장 멤버스 회원에게 <br />
            원하는 만큼 포인트 선물을 할 수 있습니다.
          </p>
          <Button label="포인트 선물하기" size="small" class="mt-[40px]" />
        </div>

        <img src="@/assets/images/intro/present.png" width="250" height="305" class="ml-[150px]" />
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">

definePageMeta({
  layout: 'side'
});
</script>

<style lang="scss" scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;

  h2 {
    font-weight: 700;
    font-size: 40px;
    line-height: 60px;
  }

  p {
    color: const(--j-gray500);
    margin-top: 8px;
    line-height: 24px;
  }
}

.card {
  background-color: #FBFBFB;
  border-radius: 16px;
  padding: 30px;
  position: relative;
  display: flex;
  flex-direction: column;
  height: 250px;
  width: 316px;

  h3 {
    font-weight: 500;
    font-size: 24px;
    line-height: 36px;
  }

  &.store::after {
    content: '';
    height: 130px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/store.png');
    background-position: right bottom;
  }

  &.mall::after {
    content: '';
    height: 130px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/mall.png');
    background-position: right bottom;
  }

  &.sapun::after {
    content: '';
    height: 130px;
    width: 180px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/sapun.png');
    background-position: right bottom;
  }
}

.desc {
  display: flex;
  align-items: center;
  font-size: 14px;
  color: var(--j-gray700);
  margin: 30px 0 80px;
  align-self: flex-start;

  &::before {
    content: '';
    height: 16px;
    width: 16px;
    display: inline-block;
    margin-right: 3px;
    background-image: url("data:image/svg+xml,%3Csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Crect x='0.5' y='0.5' width='15' height='15' rx='7.5' fill='white'/%3E%3Crect x='0.5' y='0.5' width='15' height='15' rx='7.5' stroke='%23BDBDBD'/%3E%3Crect x='7.25' y='7' width='1.5' height='5' rx='0.75' fill='%23BDBDBD'/%3E%3Crect x='7' y='4' width='2' height='2' rx='1' fill='%23BDBDBD'/%3E%3C/svg%3E%0A");
  }
}

.banner {
  height: 486px;
  width: 100vw;
  background-color: #F9F5EC;
  margin-bottom: -180px;
  padding: 80px 0;
  display: flex;
  justify-content: center;

  .banner__inner {
    display: flex;
    width: 980px;
  }

  .title {
    font-size: 38px;
    font-weight: 700;
    line-height: 57px;
  }

  .content {
    font-size: 18px;
    color: var(--j-gray700);
    margin-top: 16px;
  }

  ::v-deep(.p-button) {
    height: 53px;
    width: 270px;
    
    span {
      font-size: 15px;
      font-weight: 700;
    }
  }
}
</style>
