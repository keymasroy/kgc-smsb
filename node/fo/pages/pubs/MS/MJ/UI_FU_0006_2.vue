<template>
  <div class="sign">
    <div class="flex items-center h-[200px] bg-[#F9FAFC]">
      <Steps class="w-[340px] mx-auto reverse" v-model:activeStep="active" :model="items" />
    </div>
    <div class="w-[550px] mx-auto pt-[80px] pb-[65px]">
      <p class="text-xl text-center mb-[30px]"><strong>추가 약관동의</strong>를 선택해주세요.</p>

      <div>

        <!-- title -->
        <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">채널 약관 동의</h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="mb-[60px]">
          <li class="flex items-center justify-between py-[20px] border-b border-[#E7E7E7]">
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agreeAll" inputId="agreeAll" name="agreeAll" value="채널 약관" />
              <label for="agreeAll"> [필수] 정관장몰 이용약관 </label>
            </div>
            <Button label="내용보기" text @click="agree1 = true" />
          </li>
        </ul>

        <!-- title -->
        <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">마케팅 정보 수신 동의 <span class="text-base font-normal">(선택)</span></h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="mb-[60px]">
          <li class="py-[20px] border-b border-[#E7E7E7]">
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agreeAll" inputId="agreeAll" name="agreeAll" value="전체동의" />
              <label for="agreeAll"> 전체동의 </label>
            </div>
          </li>
          <li class="pt-[20px]">
            <div class="flex flex-wrap items-center mb-[22px] gap-6">
              <div class="flex items-center">
                <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeEmail" name="agreeEmail" value="이메일" />
                <label for="agreeEmail"> 이메일 </label>
              </div>
              <div class="flex items-center">
                <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeSms" name="agreeSms" value="문자" />
                <label for="agreeSms"> 문자 </label>
              </div>
              <div class="flex items-center">
                <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeTel" name="agreeTel" value="전화" />
                <label for="agreeTel"> 전화 </label>
              </div>
              <div class="flex items-center">
                <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreePost" name="agreePost" value="우편" />
                <label for="agreePost"> 우편 </label>
              </div>
            </div>
            <p class="text-[13px] text-[#5361E7] ml-[8px]">
              <span class="font-bold">&middot;</span> 다양한 혜택 및 이벤트 정보를 받아 보실 수 있습니다.
            </p>
          </li>
        </ul>

        <div class="flex gap-2">
          <Button class="flex-1" label="완료" size="large" @click="modalVisible=true" />
        </div>
      </div>
    </div>

    <!-- 약관 팝업 -->
    <Dialog v-model:visible="agree1" modal header="약관" :style="{ width: '500px' }">
      <div class="dialog-content-inner max-h-[456px]">
        <h2 class="mb-1 font-bold text-[15px] text-black">타이틀</h2>
        <p class="text-sm text-[#666]">약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>
      </div>
      <template #footer>
        <div class="border-t border-[#E7E7E7] pt-[24px] pb-[30px] px-[30px]">
          <Button class="block mx-auto" label="확인" @click="agree1 = false" />
        </div>
      </template>
    </Dialog>


    <!-- 동의 내역 안내 팝업 -->
    <Dialog class="alert" v-model:visible="modalVisible" modal header="" :style="{ width: '400px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2 class="font-bold">정관장 멤버스 광고정보 수신동의 정보가</h2>
        <h2 class="font-bold">정상적으로 변경되었습니다.</h2>
        <div class="flex justify-items-start mt-[18px]">
          <ul>
            <li class="flex items-center mb-[5px]">
              <span class="w-[60px] text-left">변경일자</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span>2024년 01월 10일</span>
            </li>
            <li class="flex items-center mb-[5px]">
              <span class="w-[60px] text-left">동의</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span></span>
            </li>
            <li class="flex items-center">
              <span class="w-[60px] text-left">비동의</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span>이메일, 문자, 전화, 우편</span>
            </li>
          </ul>
        </div>

        <div class="mt-[18px] text-left">
          <p class="text-[13px] text-[#888888] mb-[5px]">
            광고정보 수신거부에 관계없이 회원 및 서비스 정책 변경, 법적 의무사항 등 고객 고지 내용은 정상 발송 됩니다.
          </p>
          <p class="text-[13px] text-[#888888]">광고정보 수집거부 전 예약 발송된 광고 메시지가 있는 경우 약 1~2일 동안 발송될 수 있습니다.</p>
        </div>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="확인" @click="$router.push('/pubs/MS/MJ/UI_FU_0009_2')" />
        </div>
      </template>
    </Dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// steps
// active 0, 1, 2 값으로 active 값 구분
const active = ref(1);
const items = ref([
  {
    label: '정보입력',
  },
  {
    label: '약관동의',
  },
  {
    label: '가입완료',
  },
]);

// checkbox
const agreeAll = ref(false);
const agree = ref();


// 약관 팝업 visible
const agree1 = ref(false);
const modalVisible = ref(false);
</script>

<style lang="scss" scoped></style>
