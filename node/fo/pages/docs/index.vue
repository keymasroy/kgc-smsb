<template>
  <div class="px-[120px]">
    <h2 class="text-[28px] font-bold mb-[20px] mt-[30px]">
      Documentation
      <span class="text-[20px] text-[#888888]">[GSITM - UI개발팀]</span>
    </h2>

    <span class="p-input-icon-right">
      <span class="text-[15px] font-[600] d-inline-block mt-[9px] mr-[20px]">전체 검색</span>
      <InputText v-model="value" placeholder="Search" />
      <i class="pi pi-search" />
    </span>

    <!-- components 영역 -->
    <h2
      :class="[{ 'open' : isopen.components }]"
      class="text-[20px] font-bold mt-[30px] title"
      @click="isopen.components = !isopen.components"
    >
      Components
    </h2>

    <div class="list">
      <div class="list__header">
        <span class="label">Name</span>
        <span class="content">Content</span>
        <span class="url">Url</span>
      </div>

      <div
        v-for="(item, idx) in searched_components"
        :key="idx"
        class="item"
      >
        <span class="label">{{ item.label }}</span>
        <span class="content">{{ item.content }}</span>
        <router-link class="url" :to="item.url" target="_blank">{{ item.url }}</router-link>
      </div>
    </div>

    <h2
      :class="[{ 'open' : isopen.pages }]"
      class="text-[20px] font-bold mt-[30px] title"
      @click="isopen.pages = !isopen.pages"
    >
      Pages
    </h2>
  
    <div class="list">
      <div class="list__header">
        <span class="label">1 Depth</span>
        <span class="subLabel">2 Depth</span>
        <span class="url">Url</span>
        <span class="content">비고</span>
      </div>

      <div
        v-for="(p, idx) in searched_pages"
        :key="idx"
        :class="[{'main': !p.url}]"
        class="item"
      >
        <span  class="label">{{ p.label || '' }}</span>
        <span class="subLabel">{{ p.subLabel || '-' }}</span>
        <router-link v-if="p.url" class="url" :to="p.url" target="_blank">{{ p.url }}</router-link>
        <p class="content">{{ p.content || '-'}}</p>
      </div>
    </div>
  </div>
</template>

<script setup>

const value = ref('');

const isopen = ref({ components : false, pages: true })
const list = [
  { label: 'Button', content: '버튼', url: '/docs/buttons' },
  { label: 'Form', content: 'Input, Dropdown, Checkox, Radio', url: '/docs/forms' },
  { label: 'Popup', content: 'Popup, Alert', url: '/docs/popup' },
  { label: 'Calendar', content: 'Calendar / Date Picker', url: '/docs/calendar' },
  { label: 'Tab', content: 'Tab', url: '/docs/tab' },
];

const pages = [
  { label: 'Main' },
  { label: '', subLabel: '홈', url: '/' },
  // 회원가입
  { label: '회원가입' },
  { label: '일반회원', subLabel: '인증 선택', url: '/pubs/MS/MJ/UI_FU_0007'  },
  { label: '', subLabel: '온라인 신규회원 > 본인인증 (약관동의)', url: '/pubs/MS/MJ/UI_FU_0006'  },
  { label: '', subLabel: '온라인 신규회원 > 본인인증 (약관동의 팝업)', url: '/pubs/MS/MJ/UI_FU_0006', content: '통합회원약관 내용보기 클릭' },
  { label: '', subLabel: '온라인 신규회원 > 본인인증 (정보입력)', url: '/pubs/MS/MJ/UI_FU_0008'  },
  { label: '', subLabel: '온라인 신규회원 > 본인인증 (가입완료)', url: '/pubs/MS/MJ/UI_FU_0009'  },
  { label: '', subLabel: '이미 가입된 회원', url: '/pubs/MS/MJ/UI_FU_0000'  },
  { label: '', subLabel: '탈퇴 회원', url: '/pubs/MS/MJ/UI_FU_0000_1'  },
  { label: '통합 ONE-ID 전환', subLabel: '온라인 기존회원 > 로그인 > 안내페이지', url: '/pubs/MS/MJ/UI_FU_0005'  },
  { label: '', subLabel: '온라인 기존회원 > 본인인증 (약관동의)', url: '/pubs/MS/MJ/UI_FU_0006_1'  },
  { label: '', subLabel: '온라인 기존회원 > 본인인증 (약관동의 팝업)', url: '/pubs/MS/MJ/UI_FU_0006_1', content: '통합회원약관 내용보기 클릭'  },
  { label: '', subLabel: '온라인 기존회원 > 본인인증 (ID선택)', url: '/pubs/MS/MJ/UI_FU_0005_1'  },
  { label: '', subLabel: '온라인 기존회원 > 본인인증 (전환완료)', url: '/pubs/MS/MJ/UI_FU_0005_2'  },
  // 로그인
  { label: '로그인' },
  { label: '일반 회원 로그인', subLabel: '로그인', url: '/pubs/MS/LG/UI_FU_0001' },
  { label: '', subLabel: '로그인 > 아이디 찾기', url: '/pubs/MS/IS/UI_FU_0002' },
  { label: '', subLabel: '로그인 > 아이디 찾기 결과 (일부)', url: '/pubs/MS/IS/UI_FU_0002_1' },
  { label: '', subLabel: '로그인 > 아이디 찾기 결과 (전체)', url: '/pubs/MS/IS/UI_FU_0002_2' },
  { label: '', subLabel: '로그인 > 비밀번호 재설정 (아이디 입력 : 본인인증 후3분이내)', url: '/pubs/MS/PS/UI_FU_0003' },
  { label: '', subLabel: '로그인 > 비밀번호 재설정 (아이디 입력 : 본인인증 전)', url: '/pubs/MS/PS/UI_FU_0003_1' },
  { label: '', subLabel: '로그인 > 비밀번호 재설정 (비밀번호 재설정)', url: '/pubs/MS/PS/UI_FU_0003_2' },
  { label: '', subLabel: '로그인 > 비밀번호 3개월 변경 안내', url: '/pubs/MS/PS/UI_FU_0004' },
  { label: '', subLabel: '로그인 > 비밀번호 3개월 변경 안내 (입력)', url: '/pubs/MS/PS/UI_FU_0004_1' },
  { label: '', subLabel: '로그인 > SNS 계정 연결 팝업', url: '/pubs/MS/LG/UI_PC_LG_001', content: '카카오톡, 네이버 아이콘 버튼 클릭' },
  // 마이페이지
  { label: '마이페이지' },
  { label: '', subLabel: '메인', url: '/pubs/MP/UI_FU_0016' },
  { label: '', subLabel: '메인 팝업', url: '/pubs/MP/UI_FU_0017', content: '메인페이지에서 ‘등급 혜택 안내’ 클릭 시  출력' },
  { label: '내정보수정', subLabel: '내정보수정 > 비밀번호 입력', url: '/pubs/MP/MI/UI_FU_0022' },
  { label: '', subLabel: '내정보수정 > 본인 인증', url: '/pubs/MP/MI/UI_FU_0022_1' },
  { label: '', subLabel: '내정보수정 > 회원정보 변경', url: '/pubs/MP/MI/UI_FU_0023' },
  { label: '', subLabel: '내정보수정 > 비밀번호 변경', url: '/pubs/MP/MI/UI_FU_0003' },
  { label: '', subLabel: '내정보수정 > 기념일 관리 (미등록 상태)', url: '/pubs/MP/MI/UI_FU_0024' },
  { label: '', subLabel: '내정보수정 > 기념일 관리 (등록 상태)', url: '/pubs/MP/MI/UI_FU_0024_1' },
  { label: '', subLabel: '내정보수정 > 기념일 관리 > 기념일 추가', url: '/pubs/MP/MI/UI_FU_0025' },
  { label: '', subLabel: '내정보수정 > 기념일 관리 > 기념일 수정', url: '/pubs/MP/MI/UI_FU_0025?id=1', content: '내정보수정 > 기념일 관리 (등록 상태) 화면에서 수정버튼 클릭 시 확인 가능' },
  { label: '', subLabel: '내정보수정 > 단골매장 관리', url: '/pubs/MP/MI/UI_FU_0026' },
  { label: '', subLabel: '내정보수정 > 단골매장 관리 (단골매장 변경 팝업)', url: '/pubs/MP/MI/UI_FU_0027',
    content: `내정보수정 > 단골매장 관리  ‘매장변경’ 버튼 클릭시에도 확인 가능 \n\n - ’인증요청’ 버튼 클릭시 입력 칸 생성 \n - 인증번호 입력 안한 후 ‘인증번호 확인’ 버튼 클릭 시 Error 메세지 생성\n - 인증번호 입력 후 ‘인증번호 확인 버튼’ 클릭 시 ‘인증완료’ 메세지 생성'` },
  { label: '', subLabel: '내정보수정 > 단골매장 관리 (검색)', url: '/pubs/MP/MI/UI_FU_0028' },
  { label: '', subLabel: '내정보수정 > 회원탈퇴 (입력)', url: '/pubs/MP/MI/UI_FU_0029' },
  { label: '', subLabel: '내정보수정 > 회원탈퇴 (완료)', url: '/pubs/MP/MI/UI_FU_0030' },
  { label: '포인트 조회', subLabel: '포인트 조회', url: '/pubs/MP/PI/UI_FU_0019' },
  { label: '', subLabel: '소멸 예정  포인트', url: '/pubs/MP/PI/UI_FU_0019_1' },
  { label: '쿠폰 조회', subLabel: '쿠폰 조회 > 사용가능 쿠폰', url: '/pubs/MP/CI/UI_FU_0018' },
  { label: '', subLabel: '쿠폰 조회 > 사용완료/기간만료 쿠폰', url: '/pubs/MP/CI/UI_FU_0018' },
  { label: '구매내역 조회', subLabel: '', url: '/pubs/MP/PI_2/UI_FU_0021' },
  { label: '포인트 선물', subLabel: '', url: '/pubs/MP/PG/UI_FU_0020', content: `- 이름 입력 후 ‘조회하기’ 버튼 클릭 시 하단 영역(선물 할 포인트) 생성 \n - 하단 영역의 ‘선물하기’ 버튼 클릭 시 완료 팝업` },
  { label: '고객센터', subLabel: '자주하는질문', url: '/pubs/CS/FQ/UI_FU_0015' },
  { label: '', subLabel: '공지사항', url: '/pubs/CS/NT/UI_FU_0013' },
  { label: '소개' },
  { label: '', subLabel: '멤버스 소개', url: '/pubs/MI/ID/UI_FU_0012' },
  { label: '', subLabel: '멤버스 혜택', url: '/pubs/MI/ID/UI_FU_0012_1' },
  { label: '', subLabel: '매장 찾기', url: '/pubs/MI/ID/UI_FU_0012_2' },
  { label: '', subLabel: '포인트 쓰기', url: '/pubs/MI/ID/UI_FU_0012_3' },
  { label: '이용약관' },
  { label: '', subLabel: '이용약관', url: '/pubs/MI/ID/UI_FU_0033' },
  { label: '', subLabel: '개인정보처리방침', url: '/pubs/MI/ID/UI_FU_0033_1' },
  { label: '기타' },
  { label: '', subLabel: '404 페이지', url: '/pubs/MI/UI_FU_0088' },
];

const searched_components = computed(() => {
  const _search = value.value.toLocaleLowerCase();

  return list.filter(item => JSON.stringify(item).toLocaleLowerCase().includes(_search));
})

const searched_pages = computed(() => {
  const _search = value.value.toLocaleLowerCase();
  
  return pages.filter(item => JSON.stringify(item).toLocaleLowerCase().includes(_search));
})
</script>


<style lang="scss" scoped>
.title {
  display: flex;
  align-items: center;
  cursor: pointer;

  &:not(.open) {
    & + .list {
      border: none;
      height: 0;
      max-height: 0;
      overflow: hidden;
    }
  }

  

  &::after {
    content: '';
    background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M15.25 7.75C15.25 7.95313 15.1804 8.12891 15.0413 8.27734L10.1194 13.5273C9.98022 13.6758 9.81543 13.75 9.625 13.75C9.43457 13.75 9.26978 13.6758 9.13062 13.5273L4.20874 8.27734C4.06958 8.12891 4 7.95313 4 7.75C4 7.54688 4.06958 7.37109 4.20874 7.22266C4.3479 7.07422 4.5127 7 4.70312 7H14.5469C14.7373 7 14.9021 7.07422 15.0413 7.22266C15.1804 7.37109 15.25 7.54688 15.25 7.75Z' fill='%23C4C4C4'/%3E%3C/svg%3E%0A");
    background-position: center;
    width: 20px;
    height: 16px;
    margin-left: 10px;
    margin-top: 4px;
    transition: all 0.3s;
    display: inline-block;
  }

  &.open {
    &::after {
      transform: rotate(-180deg);
    }

    & + .list {
      height: auto;
      max-height: 100%;
      transition: max-height 1s ease-in-out;
    }
  }
}

.list {
  display: flex;
  flex-direction: column;
  border: 1px solid #e7e7e7;
  border-radius: 8px;
  margin-top: 10px;
  transition: max-height 0.5s cubic-bezier(0, 1, 0, 1);
  overflow: hidden;

  .list__header {
    display: flex;
    font-size: 18px;
    font-weight: 700;
    padding: 15px 30px;
    border-bottom: 1px solid #e7e7e7;
    background-color: #F9FAFC;
  }

  .item {
    display: flex;
    padding: 20px 30px;
    font-size: 15px;
    color: var(--j-gray400);

    &:not(:last-child) {
      border-bottom: 1px solid #e7e7e7;
    }

    &.main {
      color: var(--j-black);
      .label {
        font-weight: 700;
      }
    }

    .label {
      font-weight: 500;
    }

    .url {
      text-decoration: underline;
    }
  }

  .label {
    width: 150px;
  }

  .subLabel,
  .content {
    width: 320px;
    white-space: pre-line;
  }

  .url {
    width: 250px;
  }
}
</style>
