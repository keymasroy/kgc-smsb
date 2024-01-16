<template>
  <div :class="{ 'sideMenu': true, 'open': !!showSide }">
    <div class="sideMenu__header flex justify-between h-[50px] p-[15px]">
      <router-link to="/">
        <img src="@/assets/images/svg/logo-mobile.svg" alt="JUNG KWAN JANG Members" />
      </router-link>

      <button @click="onClickClose()">
        <img src="@/assets/images/svg/ico_close.svg" alt="메뉴 닫기 아이콘">
      </button>
    </div>

    <div v-if="!isLogin" class="buttons">
      <Button label="로그인" severity="secondary" @click="onClickLogin()" />
      <Button label="회원가입" severity="secondary" @click="$router.push('/pubs/MS/MJ/UI_FU_0040')" />
    </div>

    <div v-if="isLogin" class="barcode">
      <div class="barcode__top">
        <span class="text-[20px] text-white">
          <strong class="text-[28px]">이세계 </strong>님
        </span>

        <div class="settingButtons">
          <i class="alarm" @click="$router.push('/pubs/MI/alarms')" />
          <i class="setting" @click="$router.push('/pubs/MI/settings')" />
        </div>
      </div>

      <div class="barcode__bottom">
        <span class="w-full text-[12px] text-[#F46144]">나의 포인트</span>
        <span class="point">
          <strong class="mr-0.5">10,999</strong>P
        </span>

        <div class="barcodeButton" @click="handleOpenBarcode()">
          <i class="barcodeImg"></i>
        </div>
      </div>
    </div>

    <nav class="sideMenuList">
      <ul
        v-for="(menu, idx) in menuList"
        :key="idx"
        :class="['sideMenu__title', menu.isOpen ? 'open' : '' ]"
      >
        <span @click="menu.isOpen = !menu.isOpen "> {{ menu.title }} </span>

        <li v-if="menu.children" class="sideMenu__subList">
          <ul
            v-for="(child_menu, child_idx) in menu.children"
            :key="'child-' + child_idx"
            class="sideMenu__subTitle"
            @click="onChangeRouter(child_menu.url)"
          >
            <span>{{child_menu.title}}</span>
          </ul>
        </li>
      </ul>
    </nav>
  </div>

  <Dialog v-model:visible="isShowPopup" modal :style="{ width: '320px' }">
    <div class="dialog-content-inner max-h-[456px]">
      <p class="text-center text-[16px] text-black">
        로그인이 필요한 메뉴입니다.
        <br />
        <strong>로그인 하시겠습니까?</strong>
      </p>
    </div>
    <template #footer>
      <div class="flex justify-center pt-[24px] pb-[30px] px-[30px] gap-[10px]">
        <Button label="취소" @click="isShowPopup = false"  outlined />
        <Button label="확인" @click="$router.push('/pubs/MS/LG/UI_FU_0034')" />
      </div>
    </template>
  </Dialog>
</template>

<script setup>
import { ref } from 'vue';

const isShowPopup = ref(false);

const props = defineProps({
  /**
   * Side Menu Open 여부
   */
  showSide: {
    type: Boolean,
    default: true,
  },
  /**
   * Login 여부
   */
  isLogin: {
    type: Boolean,
    default: false
  }
})

const emit = defineEmits(['update:showSide', 'update:isLogin', 'openBarcode']);

const menuList = ref([
  { url: '', title: '소개', isOpen: false, children: [
    { url: '/pubs/MI/ID/UI_FU_0044', title: '멤버스 소개' },
    { url: '', title: '영수증 적립안내' }
  ]},
  { url: '', title: '마이페이지', isOpen: false, children: [
    { url: '/pubs/MP/PI/UI_FU_0051', title: '포인트 조회' },
    { url: '/pubs/MP/CI/UI_FU_0054', title: '쿠폰 조회' },
    { url: '/pubs/MP/PI_2/UI_FU_0052', title: '구매내역 조회' },
    { url: '/pubs/MP/PG/UI_FU_0055', title: '포인트 선물' },
    { url: '/pubs/MP/MI/UI_FU_0058', title: '기념일 관리' },
    { url: '/pubs/MP/MI/UI_FU_0060', title: '단골매장 관리' }
  ]},
  { url: '', title: '고객센터', isOpen: false, children: [
    { url: '/pubs/CS/FQ/UI_FU_0048', title: '자주하는 질문' },
    { url: '/pubs/CS/NT/UI_FU_0046', title: '공지사항' }
  ]},
]);

// Barcode 클릭 시 사이드 메뉴 닫은 후 Barcode 화면 Open
const handleOpenBarcode = () => {
  emit('update:showSide', false);
  emit('openBarcode', true);
};

const onClickClose = () => {
  emit('update:showSide', false);
};

const onClickLogin = () => {
  emit('update:isLogin', true);
};

const onChangeRouter = (url) => {
  if(props.isLogin) {
    useRouter().push(url);
    onClickClose();
  } else {
    isShowPopup.value = true;
  }
}

</script>

<style lang="scss" scoped>
.sideMenu {
  width: 0;
  top: 0;
  position: fixed;
  right: -100%;
  transition: right 0.5s ease;
}

.sideMenu.open {
  width: 100%;
  position: fixed;
  top: 0;
  right: 0;
  z-index: 100;
  background-color: var(--j-white);
  transition: right 0.5s ease;
  overflow-y: auto;
  height: 100%;
}

.sideMenu__header {
  display: flex;
  justify-content: space-between;
  padding: 15px;
  position: fixed;
  width: 100%;
  z-index: 1;
  background-color: var(--j-white);

  & + * {
    margin-top: 50px;
    padding-top: 50px;
  }
}

.buttons {
  margin: 20px 20px 0;
  display: flex;
  gap: 10px;

  :deep(.p-button) {
    flex: 1;
    height: 44px;
    border: 1px solid var(--j-bluegray400);

    span {
      color: var(--j-gray700);
      font-size: 15px;
    }

  }
}

.barcode {
  background-color: #5F0000;
  padding: 30px;

  .barcode__top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 19px;
    border-bottom: 1px solid #ffffff26;
    
    .settingButtons {
      display: flex;
      align-items: center;

      > * {
        width: 24px;
        height: 24px;
        display: inline-block;
        background-position: center;
        cursor: pointer;
      }
      .alarm {
        background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M5 18.3846V16.8846H6.8077V10.423C6.8077 9.07818 7.22276 7.88908 8.05287 6.85575C8.88301 5.82242 9.94872 5.16153 11.25 4.87308V4.25C11.25 3.90278 11.3714 3.60765 11.6143 3.3646C11.8571 3.12153 12.1519 3 12.4988 3C12.8457 3 13.141 3.12153 13.3846 3.3646C13.6282 3.60765 13.75 3.90278 13.75 4.25V4.87308C15.0512 5.16153 16.1169 5.82242 16.9471 6.85575C17.7772 7.88908 18.1922 9.07818 18.1922 10.423V16.8846H20V18.3846H5ZM12.4983 21.1923C12.0007 21.1923 11.5753 21.0153 11.2221 20.6613C10.8689 20.3073 10.6923 19.8817 10.6923 19.3846H14.3077C14.3077 19.8833 14.1305 20.3093 13.7761 20.6625C13.4218 21.0157 12.9959 21.1923 12.4983 21.1923ZM8.30765 16.8846H16.6923V10.423C16.6923 9.26535 16.283 8.27721 15.4644 7.45863C14.6458 6.64003 13.6577 6.23073 12.5 6.23073C11.3423 6.23073 10.3541 6.64003 9.53555 7.45863C8.71695 8.27721 8.30765 9.26535 8.30765 10.423V16.8846Z' fill='white'/%3E%3C/svg%3E%0A");
        margin-right: 10px;
      }
      .setting {
        background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M10.0884 21.5L9.70768 18.4538C9.43973 18.3641 9.16504 18.2384 8.88363 18.0769C8.60221 17.9153 8.3506 17.7422 8.1288 17.5576L5.30765 18.7499L3 14.75L5.44038 12.9058C5.41729 12.757 5.40094 12.6077 5.39133 12.4577C5.38171 12.3077 5.3769 12.1583 5.3769 12.0096C5.3769 11.8673 5.38171 11.7227 5.39133 11.5759C5.40094 11.4291 5.41729 11.2686 5.44038 11.0942L3 9.24998L5.30765 5.26925L8.11917 6.45195C8.36021 6.26092 8.61758 6.08623 8.8913 5.9279C9.16503 5.76955 9.43395 5.6423 9.69805 5.54615L10.0884 2.5H14.7038L15.0845 5.55578C15.3845 5.66474 15.656 5.79198 15.899 5.9375C16.1419 6.08302 16.3871 6.2545 16.6346 6.45195L19.4846 5.26925L21.7922 9.24998L19.3134 11.123C19.3493 11.2846 19.3688 11.4355 19.372 11.5759C19.3752 11.7163 19.3768 11.8577 19.3768 12C19.3768 12.1359 19.3736 12.274 19.3672 12.4144C19.3608 12.5548 19.3377 12.7154 19.298 12.8962L21.7576 14.75L19.4499 18.7499L16.6346 17.548C16.3871 17.7455 16.1345 17.9201 15.8768 18.0721C15.6191 18.224 15.355 18.348 15.0845 18.4442L14.7038 21.5H10.0884ZM11.3961 20H13.3615L13.7211 17.3211C14.2313 17.1878 14.6977 16.9984 15.1201 16.7529C15.5426 16.5074 15.9499 16.1917 16.3422 15.8058L18.8269 16.85L19.8115 15.15L17.6423 13.5154C17.7256 13.2564 17.7823 13.0025 17.8124 12.7538C17.8426 12.5051 17.8576 12.2538 17.8576 12C17.8576 11.7397 17.8426 11.4884 17.8124 11.2461C17.7823 11.0038 17.7256 10.7564 17.6423 10.5038L19.8307 8.84998L18.8461 7.14998L16.3326 8.2096C15.998 7.8519 15.5971 7.53588 15.1298 7.26153C14.6624 6.98716 14.1897 6.79293 13.7115 6.67883L13.3961 3.99998H11.4115L11.0807 6.6692C10.5705 6.78972 10.0993 6.97433 9.66725 7.22305C9.2352 7.47177 8.82303 7.79228 8.43073 8.1846L5.9461 7.14998L4.96148 8.84998L7.1211 10.4596C7.03777 10.6968 6.97943 10.9436 6.9461 11.2C6.91277 11.4564 6.8961 11.7263 6.8961 12.0096C6.8961 12.2699 6.91277 12.525 6.9461 12.775C6.97943 13.025 7.03456 13.2718 7.11147 13.5154L4.96148 15.15L5.9461 16.85L8.4211 15.8C8.80058 16.1897 9.20635 16.509 9.6384 16.7577C10.0704 17.0064 10.548 17.1974 11.0711 17.3308L11.3961 20ZM12.4076 15C13.2397 15 13.9477 14.708 14.5316 14.124C15.1156 13.54 15.4076 12.832 15.4076 12C15.4076 11.1679 15.1156 10.4599 14.5316 9.87595C13.9477 9.29198 13.2397 9 12.4076 9C11.5653 9 10.8548 9.29198 10.2759 9.87595C9.69709 10.4599 9.40768 11.1679 9.40768 12C9.40768 12.832 9.69709 13.54 10.2759 14.124C10.8548 14.708 11.5653 15 12.4076 15Z' fill='white'/%3E%3C/svg%3E%0A");
      }
    }

  }

  .barcode__bottom {
    padding-top: 10px;
    display: flex;
    flex-wrap: wrap;
    align-items: center;

    .point {
      font-family: 'Montserrat';
      font-size: 25px;
      color: var(--j-primary02);
    }

    .barcodeButton {
      width: 80px;
      height: 38px;
      background-color: #00000080;
      border-radius: 360px;
      margin-left: 15px;
      display: flex;
      position: relative;

      .barcodeImg {
        width: 100%;
        background-position: 15px center;
        background-image: url("data:image/svg+xml,%3Csvg width='30' height='16' viewBox='0 0 30 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M21.6533 1.28C21.6533 0.573076 22.3458 0 23.2 0C24.0542 0 24.7467 0.573075 24.7467 1.28L24.7467 14.72C24.7467 15.4269 24.0542 16 23.2 16C22.3458 16 21.6533 15.4269 21.6533 14.72L21.6533 1.28Z' fill='white'/%3E%3Cpath d='M6.18667 0.959999C6.18667 0.429806 6.70602 0 7.34667 0C7.98732 0 8.50667 0.429807 8.50667 0.96L8.50667 15.04C8.50667 15.5702 7.98732 16 7.34667 16C6.70602 16 6.18667 15.5702 6.18667 15.04L6.18667 0.959999Z' fill='white'/%3E%3Cpath d='M27.84 0.639999C27.84 0.286537 28.1862 0 28.6133 0C29.0404 0 29.3867 0.286538 29.3867 0.64L29.3867 15.36C29.3867 15.7135 29.0404 16 28.6133 16C28.1862 16 27.84 15.7135 27.84 15.36L27.84 0.639999Z' fill='white'/%3E%3Cpath d='M10.8267 0.448C10.8267 0.200576 11.069 0 11.368 0C11.667 0 11.9093 0.200576 11.9093 0.448L11.9093 15.552C11.9093 15.7994 11.667 16 11.368 16C11.069 16 10.8267 15.7994 10.8267 15.552L10.8267 0.448Z' fill='white'/%3E%3Cpath d='M13.92 0.448C13.92 0.200576 14.1624 0 14.4613 0C14.7603 0 15.0027 0.200576 15.0027 0.448L15.0027 15.552C15.0027 15.7994 14.7603 16 14.4613 16C14.1624 16 13.92 15.7994 13.92 15.552L13.92 0.448Z' fill='white'/%3E%3Cpath d='M4.37114e-07 1.6C4.37114e-07 0.716345 0.865583 0 1.93333 0C3.00108 0 3.86667 0.716344 3.86667 1.6L3.86667 14.4C3.86667 15.2837 3.00108 16 1.93333 16C0.865583 16 0 15.2837 0 14.4L4.37114e-07 1.6Z' fill='white'/%3E%3Cpath d='M16.748 1.92C16.748 0.859613 16.5054 0 17.7867 0C19.068 0 18.8253 0.859613 18.8253 1.92L18.8253 14.08C18.8253 15.1404 19.068 16 17.7867 16C16.5054 16 16.748 15.1404 16.748 14.08L16.748 1.92Z' fill='white'/%3E%3C/svg%3E%0A");
      }

      &::after {
        content: '';
        background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M6.67949 18.0448L5.49683 16.8621L12.359 9.99993L5.49683 3.13775L6.67949 1.95508L14.7243 9.99993L6.67949 18.0448Z' fill='%23FDFDFD'/%3E%3C/svg%3E%0A");
        width: 20px;
        height: 100%;
        position: absolute;
        background-position: center;
        right: 4px;
      }
    }
  }
}

.sideMenuList {
  margin: 0 30px 70px;

  .sideMenu__title {
    font-size: 20px;
    font-weight: 700;
    margin-top: 30px;
    display: flex;
    flex-direction: column;
    gap: 15px;
    height: 30px;


    > span {
      display: flex;
      justify-content: space-between;
      align-items: center;

      &::after {
        content: '';
        background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M15.25 7.75C15.25 7.95313 15.1804 8.12891 15.0413 8.27734L10.1194 13.5273C9.98022 13.6758 9.81543 13.75 9.625 13.75C9.43457 13.75 9.26978 13.6758 9.13062 13.5273L4.20874 8.27734C4.06958 8.12891 4 7.95313 4 7.75C4 7.54688 4.06958 7.37109 4.20874 7.22266C4.3479 7.07422 4.5127 7 4.70312 7H14.5469C14.7373 7 14.9021 7.07422 15.0413 7.22266C15.1804 7.37109 15.25 7.54688 15.25 7.75Z' fill='%23C4C4C4'/%3E%3C/svg%3E%0A");
        width: 20px;
        height: 20px;
        transition: all 0.3s;
      }
    }

    &.open {
      height: auto;

      > span::after {
        transform: rotate(180deg);
      }

      .sideMenu__subList {
        pointer-events: unset;
        max-height: 500px;
        transition: max-height 0.25s ease-in;

        .sideMenu__subTitle {
          display: flex;
          align-items: center;
          height: 44px;
          color: var(--j-black);
        }
      }
    }
  }

  .sideMenu__subList {
    padding-left: 20px;
    font-size: 18px;
    font-weight: 400;
    line-height: 27px;
    display: flex;
    flex-direction: column;
    gap: 15px;
    pointer-events: none;
    max-height: 0;
    transition: max-height 0.15s ease-out;

    .sideMenu__subTitle {
      display: none;
    }
  }
}

.dialog-content-inner {
  padding: 10px;
}
</style>
