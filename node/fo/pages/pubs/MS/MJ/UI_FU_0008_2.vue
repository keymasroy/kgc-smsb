<template>
  <!-- 카카오 간편가입 정보입력 -->
  <div class="sign">
    <div class="flex items-center h-[200px] bg-[#F9FAFC]">
      <Steps class="w-[340px] mx-auto reverse" v-model:activeStep="active" :model="items" />
    </div>

    <div class="w-[550px] mx-auto pt-[80px] pb-[110px]">
      <form action="">
        <!-- title -->
        <div class="flex items-end justify-between pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">기본정보</h2>
          <p class="text-[13px] text-[#666]"><span class="text-[#F46144]">*</span> 표시는 필수입력</p>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="pt-[20px] mb-[60px]">
          <li class="flex items-center mb-[24px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="signName">이름</label>
            <InputText disabled v-model="signName" id="signName" class="w-full" type="text" size="large" placeholder="이름을 입력해주세요." />
          </li>
          <li class="flex items-center mb-[24px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="birth">생년월일</label>
            <InputText disabled v-model="birth" id="birth" class="w-full" type="text" size="large" />
          </li>
          <li class="flex items-center mb-[24px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="phone">성별 <span class="text-[#F46144]">*</span></label>
            <div class="flex gap-[8px] w-full h-[50px]">
              <SelectButton
                v-model="selectedGenderValue"
                :options="selectGenderOptions"
                optionLabel="label"
                optionValue="value"
                class="flex-[2] is-box"
              />
            </div>
          </li>

          <li class="flex items-center mb-[24px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="phone">내/외국인 <span class="text-[#F46144]">*</span></label>
            <div class="flex gap-[8px] w-full h-[50px]">
              <SelectButton
                v-model="selectedValue"
                :options="selectOptions"
                optionLabel="label"
                optionValue="value"
                class="flex-[2] is-box"
              />
              <Dropdown :disabled="selectedValue === '내국인'" placeholder="국적 선택" inputClass="p-inputtext-lg" v-model="country" :options="countryList" optionLabel="label" class="flex-[1]" />
            </div>
          </li>

          <li class="flex items-center mb-[24px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="phone">통신사</label>
            <Dropdown placeholder="통신사 선택" inputClass="p-inputtext-lg" v-model="agency" :options="agencyList" optionLabel="label" class="w-full" />
          </li>

          <li class="flex items-center mb-[24px]">
            <label class="flex-none self-start leading-[50px] w-[150px] text-[14px] text-[#222]" for="phone">휴대폰 번호</label>
            <div class="flex flex-col w-full gap-2">
              <div class="flex gap-2">
                <InputText disabled v-model="phone" id="phone" class="flex-1" type="text" size="large" />
                <Button label="인증하기" size="large" severity="secondary" class="w-[120px] pa-0" @click="ㄹ()" />
              </div>
              <div class="flex gap-2 flex-wrap w-full">
                <span class="timer__input flex-1">
                  <InputText
                    v-model="certification"
                    id="certification"
                    class="w-full"
                    type="text"
                    size="large"
                    placeholder="인증번호를 입력해주세요."
                    :class="[{'p-invalid': type === 'error'}]"
                  />
                  <span v-if="type !== 'confirm'" class="timer">{{ timer }}</span>
                </span>
                <Button label="인증번호 확인" @click="onClickCertConfirm()" size="large" severity="secondary" class="w-[120px] pa-0" />

                <p class="desc__content" :class="[type]">
                  {{ desc_content[type] }}
                </p>
              </div>
            </div>
          </li>
        </ul>
        <!-- //contents -->

        <!-- //contents -->
        <div class="flex gap-2">
          <Button class="flex-1" label="다음" size="large" @click="$router.push('/pubs/MS/MJ/UI_FU_0006_2')" />
        </div>
      </form>
    </div>

    <Dialog class="alert" v-model:visible="modalVisible" modal header="" :style="{ width: '410px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2>입력하신 내용이 모두 삭제됩니다.</h2>
        <h2 class="font-bold">회원가입을 취소 하시겠습니까?</h2>
      </div>
      <template #footer>
        <div class="alert-footer-inner flex-col">
          <Button label="예. 회원가입을 취소할래요." @click="modalVisible = false" />
          <Button label="아니오. 계속 할게요" @click="modalVisible = false" class="mt-[10px]" outlined />
        </div>
      </template>
    </Dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// steps
// active 0, 1, 2 값으로 active 값 구분
const active = ref(0);
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

// input
const signName = ref('홍길동');
const gender = ref('남자');
const birth = ref('2000-10-10');
const phone = ref('010-1234-5678');
const certification = ref('');
const userId = ref('');
const userPassword1 = ref('');
const userPassword2 = ref('');
const userEmail = ref('');
const userAddress = ref('');

// radio
const birthInfo = ref('');
const native = ref('');

// dropdown
const year = ref();
const month = ref();
const day = ref();

const years = ref([
  { name: '2022', code: '2022' },
  { name: '2023', code: '2023' },
]);
const months = ref([
  { name: '01', code: 'january' },
  { name: '02', code: 'february' },
]);
const days = ref([
  { name: '01', code: '01' },
  { name: '02', code: '01' },
]);

const domein = ref('');
const domeins = ref([
  { name: '직접입력', code: '직접입력' },
  { name: '@naver.com', code: 'naver' },
  { name: '@hanmail.net', code: 'daum' },
  { name: '@gmail.com', code: 'google' },
]);

// checkbox
const agreeAll = ref();
const agree = ref();

// modal visible
const modalVisible = ref(false);

const onClickCancel = () => {
  modalVisible.value = true;
};

const selectedValue = ref('내국인');
const selectOptions = ref([
  { label: '내국인' , value: '내국인' },
  { label: '외국인' , value: '외국인' }
]);

const selectedGenderValue = ref('남성');
const selectGenderOptions = ref([
  { label: '남성' , value: '남성' },
  { label: '여성' , value: '여성' }
]);

const country = ref(null);
const countryList = ref([
  { label: '미국' , value: '미국' },
  { label: '일본' , value: '일본' },
  { label: '중국' , value: '중국' },
  { label: '기타' , value: '기타' }
]);

const agency = ref(null);
const agencyList = ref([
  { label: 'SKT' , value: 'skt' },
  { label: 'KT' , value: 'kt' },
  { label: 'LGU+' , value: 'lg' },
  { label: 'SK 알뜰폰' , value: 'sk_virtual' },
  { label: 'KT 알뜰폰' , value: 'kt_virtual' },
  { label: 'LG U+ 알뜰폰' , value: 'lg_virtual' },
]);

const timer = ref('2:37');
const type = ref('normal');
const desc_content = {
  normal: `3분 이내에 인증번호(6자리)를 입력해주세요. \n입력 시간 초과 시 ‘다시요청’ 버튼을 클릭해주세요.`,
  confirm: '인증이 완료되었습니다.',
  error: '입력하신 인증번호가 올바르지 않습니다. 다시 확인해주세요.'
};


// 인증하기 버튼 클릭 시
const onClickCert = () => {
  return type.value = 'normal';
}

// 인증번호 확인 버튼 클릭 시
const onClickCertConfirm = () => {
  if(!certification.value) {
    type.value = 'error';
  } else if(certification.value) {
    type.value = 'confirm';
  }
}

</script>

<style lang="scss" scoped>
.timer__input {
  display: flex;
  align-items: center;
  justify-content: flex-end;

  .timer {
    position: absolute;
    color: var(--j-primary02);
    font-weight: 700;
    margin-right: 14px;
  }
}

.desc__content {
  font-size: 13px;
  white-space: break-spaces;
  width: 100%;
  line-height: 16px;
  
  &.normal {
    color: #888888;
  }

  &.confirm {
    color: #5361E7;
  }

  &.error {
    color:#c32727;;
  }
}
</style>
