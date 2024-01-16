<template>
  <div class="flex flex-col flex-1 gap-[5px] py-[10px] px-[20px]">
    <div class="setting__wraaper">
      <span class="label"> PUSH 알림 동의 </span>
      <div class="flex items-center h-[24px]">
        <InputSwitch v-model="isPushAgree" @change="onChangeAgree" />
        <span :class="[isPushAgree ? 'on': 'off', 'ml-[5px]', 'text-[13px]', 'font-[500]']">
          {{ isPushAgree ? 'ON' : 'OFF' }}
        </span>
      </div>
    </div>

    <div class="setting__wraaper">
      <span class="label"> 내정보 수정 </span>
      <i class="arrow" @click="$router.push('/pubs/MP/MI/UI_FU_0057')" />
    </div>

    <div class="setting__wraaper">
      <span class="label"> 현재버전 v0.1 </span>
      <div class="chip">
        업데이트
      </div>
    </div>

    <div class="setting__wraaper">
      <span class="label"> 현재버전 v0.1 </span>
      <div class="chip is-current">
        최신버전입니다.
      </div>
    </div>

    <div class="setting__wraaper">
      <span class="label"> 로그아웃 </span>
      <i class="arrow" @click="onClickLogout()" />
    </div>
  </div>

  <Dialog v-model:visible="isShowPopup" modal :style="{ width: '320px' }">
    <!-- 알람 동의로 바꿀 경우 -->
    <div v-if="isPushAgree" class="dialog-content-inner max-h-[220px]">
      <p class="text-center text-[14px] text-[#222222]">수신동의 처리가 완료되었습니다.</p>
    </div>

    <!-- 알람 미동의로 바꿀 경우 -->
    <div v-if="!isPushAgree" class="dialog-content-inner is-disagree">
      <div class="flex items-center">
        <span class="label">전송자</span>
        <span class="content">정관장 멤버스</span>
      </div>
      <div class="flex items-center">
        <span class="label">처리일</span>
        <span class="content">2023년 08월 08일</span>
      </div>
      <div class="flex items-center">
        <span class="label">처리내용</span>
        <span class="content">푸시 수신거부</span>
      </div>
      <p class="text-[12px] text-[#D20F27] mt-[5px]">필수 정보는 수신거부와 관계없이 발송됩니다.​</p>
    </div>
    <template #footer>
      <div class="flex justify-center pt-[24px] pb-[30px] px-[30px] gap-[10px]">
        <Button label="확인" @click="isShowPopup = false" />
      </div>
    </template>
  </Dialog>
</template>

<script lang="ts" setup>

const isPushAgree = ref(true);
const isShowPopup = ref(false);

const onChangeAgree = (value) => {
  isShowPopup.value = true;
}

const onClickLogout = () => {
  console.log('onClickLogout');
}
definePageMeta({
  layout: 'sub',
  title: '환경설정',
  footer: 'none'
});
</script>

<style lang="scss" scoped>
.setting__wraaper {
  height: 68px;
  background-color: var(--j-bluegray300);
  border-radius: 8px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;

  .label {
    font-size: 16px;
    line-height: 24px;
  }

  :deep(.p-inputswitch) {
    height: 24px;

    &.p-inputswitch-checked .p-inputswitch-slider {
      border-color: var(--j-primary03);
      background-color: var(--j-primary03);
    }

    & + .on {
      color: var(--j-primary03);
      font-family: 'Montserrat';
    }

    & + .off {
      color: var(--j-gray300);
      font-family: 'Montserrat';
    }
  }

  .arrow {
    width: 24px;
    height: 24px;
    cursor: pointer;
    background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M16.7393 11.2201H16.7438L16.7587 11.2365L16.7677 11.2465C17.1441 11.6605 17.1441 12.3295 16.7678 12.7435L16.7393 11.2201ZM16.7393 11.2201L8.61526 2.26282C8.61525 2.2628 8.61523 2.26278 8.61522 2.26277C8.24076 1.84559 7.6246 1.84596 7.24589 2.26258L7.23226 2.27758C6.85591 2.6916 6.85591 3.36064 7.23226 3.77466L14.691 12L7.23226 20.2303C6.85591 20.6444 6.85591 21.3134 7.23226 21.7274L7.26926 21.6938L7.23226 21.7274L7.24135 21.7374C7.6202 22.1542 8.2362 22.1542 8.61505 21.7374L8.6151 21.7374L16.7677 12.7435L16.7393 11.2201Z' fill='%23222222' stroke='%23222222' stroke-width='0.1'/%3E%3C/svg%3E%0A");
  }
}

.chip {
  padding: 4px 10px;
  color: var(--j-white);
  font-size: 13px;
  font-weight: 500;
  background-color: var(--j-primary03);
  border-radius: 360px;
  cursor: pointer;

  &.is-current {
    background-color: var(--j-bluegray500);
    cursor: default;
  }
}

.dialog-content-inner {
  padding: 16px;

  .label {
    width: 52px;
    display: inline-block;
    font-size: 14px;
    color: var(--j-gray700);
  }

  .content {
    font-size: 14px;
    color: var(--j-gray700);
    display: flex;

    &::before {
      content: '';
      margin: 5px 8px;
      width: 1px;
      height: 12px;
      display: inline-block;
      background-color: var(--j-gray200);
    }
  }

  &.is-disagree {
    padding: 0 30px 8px;
    display: flex;
    flex-direction: column;
    gap: 5px;
  }
}
</style>
