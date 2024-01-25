<template>
  <header :class="['header', { '!bg-[#FFF] active': headerActive }]">
    <router-link class="mt-[37px] z-[2] ml-[120px]" to="/">
      <img class="whiteLogo" src="@/assets/images/svg/logo-white.svg" alt="JUNG KWAN JANG Members" />
      <img class="defaultLogo" src="@/assets/images/svg/logo.svg" alt="JUNG KWAN JANG Members" />
    </router-link>

    <nav class="gnb" aria-label="Gnb Menu List">
      <ul v-for="(menu, idx) in menuList" :key="idx" class="gnb__link">
        <span class="gnb__title">{{ menu.title }}</span>

        <li v-if="menu.children?.length > 0" className="gnb__subList">
          <ul v-for="(child_menu, child_idx) in menu.children" :key="'child-' + child_idx">
            <router-link class="gnb__subTitle" :to="child_menu.url">{{ child_menu.title }}</router-link>
          </ul>
        </li>
      </ul>
    </nav>

    <nav class="sign-nav mr-[120px]">
      <router-link class="gnb__link" to="/pubs/MS/LG/UI_FU_0001">로그인</router-link>
      <router-link class="gnb__link" to="/pubs/MS/MJ/UI_FU_0007">회원가입</router-link>
    </nav>
  </header>
</template>

<script setup>
import { useScroll, watchThrottled } from '@vueuse/core';
import { ref } from 'vue';

const menuList = ref([
  { url: '', title: '소개', children: [
    { url: '/pubs/MI/ID/UI_FU_0012', title: '멤버스 소개' },
    { url: '', title: '영수증 적립안내' }
  ]},
  { url: '', title: '마이페이지', children: [
    { url: '/pubs/MP/PI/UI_FU_0019', title: '포인트 조회' },
    { url: '/pubs/MP/CI/UI_FU_0018', title: '쿠폰 조회' },
    { url: '/pubs/MP/PI_2/UI_FU_0021', title: '구매내역 조회' },
    { url: '/pubs/MP/PG/UI_FU_0020', title: '포인트 선물' },
    { url: '/pubs/MP/MI/UI_FU_0024', title: '기념일 관리' },
    { url: '/pubs/MP/MI/UI_FU_0026', title: '단골매장 관리' }
  ]},
  { url: '', title: '고객센터', children: [
    { url: '/pubs/CS/FQ/UI_FU_0015', title: '자주하는 질문' },
    { url: '/pubs/CS/NT/UI_FU_0013', title: '공지사항' }
  ]},
]);

const { y: winScoll } = useScroll(document);
const headerActive = ref(false);

watchThrottled(
  () => winScoll.value,
  newValue => {
    headerActive.value = winScoll.value > 0 ? true : false;
  },
  { throttle: 200 },
);
</script>

<style lang="scss" scoped>
/* 로고 변경 */
.header {
  &:not(.active) {
    .defaultLogo {
      display: none;
    }
  }

  &.active {
    .whiteLogo {
      display: none;
    }
  }

  &:hover {
    background-color: white;
    .whiteLogo {
      display: none;
    }

    .defaultLogo {
      display: unset;
    }
  }
}

.header {
  z-index: 30;
  position: fixed;
  width: 100%;
  min-width: 1280px;
  background-color: transparent;
  height: 100px;
  display: flex;
  justify-content: space-between;
  transition: background-color 0s 0.3s;

  &:not(.active) {
    .sign-nav > a {
      transition: color 0.2s 0.3s;
    }
  }

  &.active {
    transition: background-color 0s;
    .gnb > .gnb__link {
      color: var(--j-black);
    }

    .sign-nav > a {
      transition: 0.2s all;
      color: #030303;
    }
  }

  &:hover {
    &:not(.active) {
      .sign-nav > a {
        transition: all 0.2s;
      }
    }
    .gnb {
      background-color: var(--j-white);
      border-bottom: 1px solid var(--j-gray100);

      .gnb__link {
        color: var(--j-black);
        height: auto;
        max-height: 1000px;
        background-color: white;
        transition: max-height 0.3s ease-in;
        
        &:hover {
          .gnb__title {
            color: var(--j-primary01);
          }
        }
      }

      .gnb__subList {
        display: flex;
        flex-direction: column;
        gap: 10px;
        margin-bottom: 30px;
      }
    }

    .sign-nav > a {
      color: #030303;
    }
  }
}

.gnb {
  display: flex;
  justify-content: center;
  position: absolute;
  width: 100%;

  > .gnb__link {
    width: 160px;
    font-weight: 700;
    font-size: 17px;
    text-align: center;
    color: var(--j-white);
    max-height: 100px;
    overflow: hidden;
    transition: max-height 0.3s ease-out, color 0.1s;

    .gnb__title {
      line-height: 100px;
      cursor: default;
      transition: all 0.3s;
    }
  }

  &:before {
    content: "";
    top: 100px;
    left: -120px;
    position: absolute;
    overflow: hidden;
    width: calc(100% + 120px);
    height: calc(100% - 100px);
    max-height: calc(100% - 100px);
    background-color: var(--j-white);
  }

  .gnb__subList {
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin-bottom: 30px;
    ul {
      height: 41px;
    }
  }

  .gnb__subTitle {
    color: var(--j-black);
    font-size: 16px;
    font-weight: 400;
    position: relative;
    height: 41px;
    cursor: pointer;

    &:hover {
      background-color: var(--j-primary01);
      border-radius: 360px;
      color: var(--j-white);
      font-weight: 500;
      padding: 8px 20px 9px 20px;
    }
  }
}

.sign-nav {
  display: flex;
  align-items: center;

  > a {
    position: relative;
    color: var(--j-white);

    &:not(:first-child) {
      margin-left: 8px;
      padding-left: 8px;

      &::before {
        content: '';
        position: absolute;
        top: 50%;
        left: 0;
        transform: translateY(-50%);
        width: 1px;
        height: 10px;
        background-color: var(--j-gray200);
      }
    }
  }
}
</style>
