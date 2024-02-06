<template>
  <div class="flex flex-col items-center mt-[20px] mb-[70px]">
    <TabView class="fill_tab industry_custom_tab" @tab-click="onClickTab" v-model:activeIndex="activeTab">
      <TabPanel header="멤버스 소개" />
      <TabPanel header="멤버스 혜택" />
      <TabPanel header="매장찾기" />

      <!-- 포인트 쓰기 -->
      <TabPanel header="포인트 쓰기" class="header">
        <div class="tabInner__title flex flex-col">
          <h2>포인트 쓰기</h2>
          <p>정관장 전국 가맹점 매장과 정관장몰에서 <br /> 포인트를 현금처럼 사용하실 수 있습니다.</p>
        </div>

        <div class="mt-[24px] mx-[20px] flex flex-col gap-[16px]">
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
          <h3 class="title">
            포인트 선물하기를 <br />
            하실 수 있습니다.
          </h3>
          <p class="content">
            차곡차곡 쌓아 둔 포인트 선물이 가능 해졌습니다. <br />
            선물가능 포인트 확인 후 선물 받을 정관장 멤버스<br />
            회원에게 원하는 만큼 포인트 선물을 할 수 있습니다.
          </p>
          <Button label="포인트 선물하기" size="small" class="mt-[24px]" />

          <img src="@/assets/images/intro/present.png" width="200" height="244" class="mt-[40px]" />
        </div>
      </TabPanel>
    </TabView>
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";

const activeTab = ref(3);

const tabs = {
  0: '/pubs/MI/ID/UI_FU_0044',
  1: '/pubs/MI/ID/UI_FU_0044_1',
  2: '/pubs/MI/ID/UI_FU_0044_2',
  3: '/pubs/MI/ID/UI_FU_0044_3'
};

const onClickTab = () => {
  useRouter().push(tabs[activeTab.value]);
};

definePageMeta({
  layout: 'sub',
});

</script>

<style scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;

  &.border-b {
    border-color: #ECF0F8;
    padding-bottom: 24px;
    margin: 0 20px;
  }

  h2 {
    font-weight: 700;
    font-size: 30px;
    line-height: 45px;
  }

  p {
    color: var(--j-gray500);
    margin-top: 8px;
    line-height: 22.4px;
    font-size: 14px;
  }
}

/* == 포인트 쓰기 == */


.card {
  background-color: #FBFBFB;
  border-radius: 16px;
  padding: 30px;
  position: relative;
  display: flex;
  flex-direction: column;
  height: 250px;

  h3 {
    font-weight: 500;
    font-size: 24px;
    line-height: 36px;
  }

  &.store::after {
    content: '';
    height: 130px;
    width: 160px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/store.png');
    background-position: right bottom;
  }

  &.mall::after {
    content: '';
    height: 130px;
    width: 160px;
    position: absolute;
    bottom: 30px;
    right: 30px;
    background-image: url('@/assets/images/intro/mall.png');
    background-position: right bottom;
  }

  &.sapun::after {
    content: '';
    height: 130px;
    width: 160px;
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
  align-self: flex-start;
  font-size: 14px;
  color: var(--j-gray700);
  margin: 20px 0 40px 20px;

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
  width: 100vw;
  background-color: #F9F5EC;
  margin-bottom: -20px;
  display: flex;
  padding: 40px 0;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  .banner__inner {
    display: flex;
    width: 980px;
  }

  .title {
    font-size: 30px;
    font-weight: 700;
    line-height: 45px;
    text-align: center;
  }

  .content {
    font-size: 14px;
    color: var(--j-gray700);
    margin-top: 8px;
    text-align: center;
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
/* ============== */
</style>