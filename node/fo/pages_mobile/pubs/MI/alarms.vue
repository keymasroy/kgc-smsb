<template>
  <div class="flex flex-col flex-1 gap-[10px] py-[10px] px-[20px] mb-[67px]">
    <template v-if="!isPushAgree">
      <div class="alarm">
        <span class="title"> 기기의 알림 설정이 꺼져있어요. </span>
        <p class="content text-[#888888]">
          정관장 멤버스에서 드리는 알림들을 받아 보시려면 기기의 알림 설정에서 알림을 켜주세요.​
        </p>
        <Button
          class="mt-[20px]"
          label="알림 설정하기"
          severity="secondary"
          @click="isPushAgree = true"
        />
      </div>
    </template>

    <template v-if="isPushAgree">
      <div
        class="alarm"
        v-for="(alarm, idx) in alarmList"
        :key="idx"
      >
        <div class="top">
          <span class="type">{{ alarm.type }}</span>
          <span class="date">{{ alarm.date }}</span>
        </div>
        <span class="title"> {{ alarm.title }} </span>
        <p class="content">
          {{ alarm.content }}
        </p>
      </div>

      <Button
        class="w-full mt-[10px]"
        icon="pi pi-plus"
        iconPos="right"
        severity="secondary"
        @click="onClickMoreButton()"
      >
        <span class="mr-[4px] text-[#758EBC]">더보기</span>
        <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path
            d="M10.2278 4.71875C10.2278 4.25276 9.85006 3.875 9.38407 3.875C8.91808 3.875 8.54032 4.25276 8.54032 4.71875V9.04032H4.21875C3.75276 9.04032 3.375 9.41808 3.375 9.88407C3.375 10.3501 3.75276 10.7278 4.21875 10.7278H8.54032V15.0492C8.54032 15.5152 8.91808 15.8929 9.38407 15.8929C9.85006 15.8929 10.2278 15.5152 10.2278 15.0492V10.7278H14.5492C15.0152 10.7278 15.3929 10.3501 15.3929 9.88407C15.3929 9.41808 15.0152 9.04032 14.5492 9.04032H10.2278V4.71875Z"
            fill="#758EBC"
          />
        </svg>
      </Button>
    </template>

  </div>
</template>

<script lang="ts" setup>

const isPushAgree = ref(false);

const alarmList = ref([
  { type: '공지', date: '2023.09.12', title: '서비스 일시 중단 안내',
    content: `해외에 계신 분들은 서비스 별 중단 시간을 확인하신 후 이용해 주시기 바랍니다. 정관장 멤버스에서 드리는 알림들을 받아  보시려면 기기의 알림 설정에서 알림을 켜주세요.​ \n
      오전 0시 ~ 오후 18시(한국표준시)\n APP을 연계한 거래중단(트래블로그 카드 해외결제 설정 등)`
  },
  { type: '공지', date: '2023.09.12', title: '서비스 일시 중단 안내', content: `오전 0시 ~ 오후 18시(한국표준시)\n APP을 연계한 거래중단(트래블로그 카드 해외결제 설정 등)` },
  { type: '공지', date: '2023.09.12', title: '보유하고 계신 쿠폰이 곧 만료될 예정', content: `앱 쿠폰함에서 확인해보세요!` },
  { type: '공지', date: '2023.09.12', title: '앱 업그레이드 시간', content: `오전 0시 ~ 오후 18시(한국표준시)\n APP을 연계한 거래중단(트래블로그 카드 해외결제 설정 등)` },

  { type: '공지', date: '2023.09.12', title: '서비스 일시 중단 안내',
    content: `해외에 계신 분들은 서비스 별 중단 시간을 확인하신 후 이용해 주시기 바랍니다. 정관장 멤버스에서 드리는 알림들을 받아 보시려면 기기의 알림 설정에서 알림을 켜주세요.​
      \n 오전 0시 ~ 오후 18시(한국표준시)\n APP을 연계한 거래중단(트래블로그 카드 해외결제 설정 등)`
  }
]);

const onClickMoreButton = () => {
  console.log('onClickMoreButton');
}

definePageMeta({
  layout: 'sub',
  title: '알림',
  footer: 'none'
});

</script>

<style lang="scss" scoped>
.alarm {
  border: 1px solid var(--j-gray200);
  border-radius: 8px;
  padding: 20px;

  .top {
    display: flex;
    align-items: center;
    gap: 10px;
    font-size: 13px;
    font-weight: 500;
    margin-bottom: 15px;

    .type {
      color: var(--j-bluegray700);
    }

    .date {
      color: var(--j-gray400);
    }
  }

  .title {
    font-size: 16px;
    font-weight: 700;
    line-height: 24px;
  }

  .content {
    font-size: 15px;
    line-height: 22.5px;
    color: var(--j-gray500);
    margin-top: 10px;
    word-break: keep-all;
    white-space: pre-line;
  }
}
</style>
