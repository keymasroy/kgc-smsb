<template>
  <div class="subHeader">
    <div
      v-for="(item, idx) in resultList"
      :key="idx"
      :class="[{ 'selected': item.url.includes(route.path) }, 'item']"
    >
      <router-link :to="item.url">
        {{ item.title }}
      </router-link>
    </div>
  </div>
</template>

<script setup lang="ts">

const route = useRoute();


const tabType = ref({
  // 마이페이지
  mp: [
    { id: 1, url: '/pubs/MP/PI/UI_FU_0019/', title: '포인트 조회' },
    { id: 2, url: '/pubs/MP/CI/UI_FU_0018/', title: '쿠폰 조회' },
    { id: 3, url: '/pubs/MP/PI_2/UI_FU_0021/', title: '구매내역 조회' },
    { id: 4, url: '/pubs/MP/PG/UI_FU_0020/', title: '포인트 선물' },
    { id: 5, url: '/pubs/MP/MI/UI_FU_0023/', title: '내정보 수정'}
  ],
  // 마이페이지 > 내 정보 수정
  mp_info: [
    { id:'5-1', url: '/pubs/MP/MI/UI_FU_0023/', title: '회원정보 변경' },
    { id:'5-2', url: '/pubs/MP/MI/UI_FU_0003/', title: '비밀번호 변경' },
    { id:'5-3', url: '/pubs/MP/MI/UI_FU_0024/', title: '기념일 관리' },
    { id:'5-4', url: '/pubs/MP/MI/UI_FU_0026/', title: '단골매장 관리' },
    { id:'5-5', url: '/pubs/MP/MI/UI_FU_0029/', title: '회원 탈퇴' },
  ],
  // 소개
  introduction: [
    { id: 6, url: '/pubs/MI/ID/UI_FU_0012/', title: '멤버스 소개' },
    { id: 7, url: '/pubs/MI/ID/UI_FU_0012_1/', title: '멤버스 혜택' },
    { id: 8, url: '/pubs/MI/ID/UI_FU_0012_2/', title: '매장 찾기' },
    { id: 9, url: '/pubs/MI/ID/UI_FU_0012_3/', title: '포인트 쓰기' },
  ],
  // 고객센터
  cs: [
    { id: 10, url: '/pubs/CS/FQ/UI_FU_0015/', title: '자주찾는 질문' },
    { id: 11, url: '/pubs/CS/NT/UI_FU_0013/', title: '공지사항' },
  ]
});

const resultList = computed(() => {
  let type = '';

  for (const key in tabType.value) {

    const _string = JSON.stringify(tabType.value[key]);
    type = _string.includes(route.path) ?  key : type;
  }

  console.log('type: ',type);

  return tabType.value[type] || [];
});

</script>

<style lang="scss" scoped>
.subHeader {
  background-color: var(--j-primary03);
  padding-top: 36px;
  width: 100%;
  height: 120px;
  position: absolute;
  top: 70px;
  display: flex;
  justify-content: center;

  .item {
    display: flex;
    justify-content: center;
    width: 245px;
    font-size: 16px;
    line-height: 24px;
    padding-top: 34px;
    cursor: pointer;
    position: relative;
    
    a {
      color: #ffffffbf;
      transition: all 0.3s;
    }

    &:hover a {
      color: var(--j-white);
    }

    &.selected {
      font-size: 16px;
      font-weight: 700;
      height: calc(100% + 8px);
      background-color: var(--j-primary03);
      
      a {
        color: var(--j-white);
      }

      &::before {
        content: '';
        background-image: url("data:image/svg+xml,%3Csvg width='1' height='84' viewBox='0 0 1 84' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 84L3.9041e-06 0H1L1 84H0Z' fill='url(%23paint0_linear_124_6961)'/%3E%3Cdefs%3E%3ClinearGradient id='paint0_linear_124_6961' x1='0.500002' y1='0' x2='0.500002' y2='84' gradientUnits='userSpaceOnUse'%3E%3Cstop stop-color='white' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='white' stop-opacity='0.35'/%3E%3C/linearGradient%3E%3C/defs%3E%3C/svg%3E%0A");
        width: 1px;
        height: 84px;
        position: absolute;
        top: 0;
        left: 0;
      }

      &::after {
        content: '';
        background-image: url("data:image/svg+xml,%3Csvg width='1' height='84' viewBox='0 0 1 84' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M0 84L3.9041e-06 0H1L1 84H0Z' fill='url(%23paint0_linear_124_6961)'/%3E%3Cdefs%3E%3ClinearGradient id='paint0_linear_124_6961' x1='0.500002' y1='0' x2='0.500002' y2='84' gradientUnits='userSpaceOnUse'%3E%3Cstop stop-color='white' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='white' stop-opacity='0.35'/%3E%3C/linearGradient%3E%3C/defs%3E%3C/svg%3E%0A");
        width: 1px;
        height: 84px;
        position: absolute;
        top: 0;
        right: 0;
      }
    }
  }
}
</style>