<template>
  <article class="main">
    <section class="main__visual fade">
      <div class="main__visual-inner">
        <div ref="visual" class="main__visual-text">
          <span class="z-30 font-bold text-[100px] text-white">EARTH</span>
          <span class="z-10 mt-[-34px] font-semibold text-[80px] text-[#B39281] italic">To</span>
          <span class="z-30 font-bold text-[100px] text-white top-[67px]">HEALTH</span>
          <p class="ext-base">정관장은 Healthy Life Style Supporter로서 건강한 삶의 기준을 제공합니다.</p>
          <img
            :src="visualImageSrc"
            alt="배경 이미지"
            class="z-20 main__visual-image"
            :style="{top: `${visualImageTop || 0}px`}"
          />
        </div>
        
      </div>
    </section>
    <div class="main__contents h-full">
      <div class="main__contents-inner h-full">
        <div class="flex flex-col items-center bg-white mt-[120px] py-[20px] z-10">
          <span class="text-[44px] font-[350]">
            쓸수록 쌓이는 <strong>쇼핑의 즐거움!</strong>
          </span>
          <span class="mt-[4px] text-[#222222]">
            회원이 되시면 쿠폰부터 포인트까지 다양한 혜택을 받을 수 있습니다.
          </span>
        </div>
        <div class="cardList mt-[100px] z-10">
          <div
            v-for="(card, index) in cardList"
            :key="index"
            :class="['card', `card${index + 1}` ]"
            :style="{'animation-delay': `${0.2 * index}s`}"
            v-animateonscroll="{ enterClass: 'fadeInBottom', leaveClass: 'none' }"
            @click="$router.push(card.router)"
          >
            <span class="title">{{ card.title }}</span>
            <span class="desc">{{ card.desc }}</span>
            <i class="arrow" />
          </div>
        </div>
      </div>
    </div>
  </article>
</template>

<script lang="ts" setup>
import top1 from '@/assets/images/main/top1.png';
import top2 from '@/assets/images/main/top2.png';
import top3 from '@/assets/images/main/top3.png';
import top4 from '@/assets/images/main/top4.png';

import { useElementBounding, useScroll, watchThrottled } from '@vueuse/core';
import { onMounted, ref } from 'vue';

definePageMeta({
  layout: 'main',
});

const visual = ref(null);
const { y: winScoll } = useScroll(document);
const { height: visualHeight, y: visualY } = useElementBounding(visual);

const org_visualY = ref(0);

const visualImagesType = [top1, top2, top3, top4];
const visualImageSrc = ref(visualImagesType[0]);
const visualImageTop = ref(null);
const max_top = 260;

const cardList = ref([
  { title: '멤버스', desc: '하나의 ID로 주요 서비스를 \n 편리하게 이용', router: '/pubs/MI/ID/UI_FU_0012' },
  { title: '혜택', desc: '회원만을 위한 특별한 서비스와 혜택', router: '/pubs/MI/ID/UI_FU_0012_1' },
  { title: '매장찾기', desc: '가까운 정관장 매장 찾기', router: '/pubs/MI/ID/UI_FU_0012_2' },
  { title: '쓰기', desc: '나누는 행복, 쇼핑하는 즐거움', router: '/pubs/MI/ID/UI_FU_0012_3' },
])

onMounted(() => {
  org_visualY.value = visualY.value;
})

watchThrottled(
  () => winScoll.value,
  newValue => {
    // visualY 을 3등분 해서 포인트 잡아서 이미지 바꿔줄 거임
    // visualHeight - visualY 뺀 값을 100% 로 계산해서 이동시켜 줄거임
    const _top = org_visualY.value - visualY.value;

    // 이미지 top pixel 변경
    visualImageTop.value = handleChangeTopImageTop(_top);

    // 이미지 src 변경
    visualImageSrc.value = visualImagesType[handleChangeImage(_top)];
  },
  { throttle: 100 },
);

const handleChangeTopImageTop = (value) => {
  if ( value < 0 ) {
    return 0;
  } else if ( value > max_top ) {
    return max_top;
  } else return value;
}

const handleChangeImage = (value) => {
  let _index = parseInt((value / (max_top / visualImagesType.length)).toFixed());

  if ( _index <= 0 ) {
    _index = 0;
  } else if ( _index > visualImagesType.length ) {
    _index = visualImagesType.length - 1;
  } else {
    _index -= 1;
  }

  return _index;
}
</script>

<style lang="scss" scoped>
.main {
  margin-top: -70px;
}

.main__visual {
  position: relative;
  width: 100%;
  height: 90vh;
  min-height: 900px;
  background: url('@/assets/images/main/bg.jpg') no-repeat;
  background-size: cover;

  &::before {
    content: "";
    z-index: 1;
    position: absolute;
    left: 50%;
    bottom: 0;
    transform: translateX(-50%);
    width: 7px;
    height: 150px;
    background-color: var(--j-primary01);
  }

  &::after {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: linear-gradient(0deg, rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)), linear-gradient(180deg, rgba(0, 0, 0, 0.2) 0%, rgba(0, 0, 0, 0) 100%);
  }
}

.main__visual-inner {
  z-index: 1;
  position: absolute;
  width: 100%;
  height: 100%;
  left: 50%;
  transform: translateX(-50%);

  &::before {
    content: '';
    position: absolute;
    top: 140px;
    left: 50%;
    transform: translateX(-50%);
    width: 7px;
    height: 70px;
    background-color: var(--j-primary01);;
  }
}

.main__visual-text {
  font-family: "Montserrat";
  width: 100%;
  height: fit-content;
  position: absolute;
  top: calc(100% - 10vh - 70px - 50%);
  > span {
    display: block;
    position: relative;
    text-align: center;
    line-height: 1.2;
  }
  .ext-base {
    color: white;
    text-align: center;
    position: relative;
    top: 60px;
    margin-top: 30px;
  }
}

.main__visual-image {
  position: absolute;
  top: 13px; /* max top 160px */
  left: 50%;
  width: 280px;
  height: 170px;
  margin-left: -140px;
  transition: all 0.1s;
  margin-top: -110px;
}

.main__contents {
  position: relative;
  height: fit-content;
  
  .main__contents-inner {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 150px;
    position: relative;
    
    &::before {
      content: '';
      width: 1px;
      background-color: var(--j-primary01);
      height: 100%;
      position: absolute;
      left: calc(50% - 1px);
      display: inline-block;
    }
  }

  .cardList {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    position: relative;
    left: -1px;

    .card {
      position: relative;
      padding: 50px;
      border: 1px solid var(--j-gray200);
      display: flex;
      flex-direction: column;
      flex-basis: 50%;
      height: 280px;
      cursor: pointer;
      transition: all 0.25s;
      max-width: 590px;
      font-family: 'Pretendard';

      &:nth-child(n+3) {
        margin-top: 60px;
      }

      &:not(:first-child, :last-child) {
        background-color: var(--j-primary03);
        border: 1px solid var(--j-primary03);
        color: white;

        .title {
          color: var(--j-white);
        }

        .desc {
          color: #ffffffbf;
        }
      }

      .title {
        font-size: 32px;
        line-height: 48px;
        color: var(--j-gray700);
      }

      .desc {
        font-size: 18px;
        color: var(--j-gray400);
        line-height: 28.8px;
        white-space: pre-line;
      }

      &:hover {
        transform: translateY(-10px);
        transition: 0.15s ease-in-out;
        .arrow {
          background-image: url("data:image/svg+xml,%3Csvg width='38' height='38' viewBox='0 0 38 38' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='19' cy='19' r='19' fill='%23F46144'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M23.0092 13.2188L28.7827 18.9719C29.0724 19.2636 29.0724 19.7364 28.7827 20.0281L23.0092 25.7812C22.7195 26.0729 22.2498 26.0729 21.9601 25.7812C21.6704 25.4896 21.6704 25.0167 21.9601 24.725L26.4674 20.2469H10.7418C10.3321 20.2469 10 19.9125 10 19.5C10 19.0875 10.3321 18.7531 10.7418 18.7531H26.4674L21.9601 14.275C21.6704 13.9833 21.6704 13.5104 21.9601 13.2188C22.2498 12.9271 22.7195 12.9271 23.0092 13.2188Z' fill='white'/%3E%3C/svg%3E%0A");
        }
      }

      .arrow {
        width: 38px;
        height: 38px;
        margin-top: 15px;
        cursor: pointer;
        background-image: url("data:image/svg+xml,%3Csvg width='38' height='38' viewBox='0 0 38 38' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='19' cy='19' r='18.5' stroke='%23CBCBCB'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M23.0092 13.2188L28.7827 18.9719C29.0724 19.2636 29.0724 19.7364 28.7827 20.0281L23.0092 25.7812C22.7195 26.0729 22.2498 26.0729 21.9601 25.7812C21.6704 25.4896 21.6704 25.0167 21.9601 24.725L26.4674 20.2469H10.7418C10.3321 20.2469 10 19.9125 10 19.5C10 19.0875 10.3321 18.7531 10.7418 18.7531H26.4674L21.9601 14.275C21.6704 13.9833 21.6704 13.5104 21.9601 13.2188C22.2498 12.9271 22.7195 12.9271 23.0092 13.2188Z' fill='%23CBCBCB'/%3E%3C/svg%3E%0A");
      }
    }
  }
}

// === Card 배경 이미지 ===
.card::after {
  content: '';
  position: absolute;
  right: 0;
}
.card1::after {
  width: 186.9px;
  height: 171.19px;
  top: 66px;
  right: 48.1px;
  background-image: url('@/assets/images/main/card1.svg');
}

.card2::after {
  width: 166.4px;
  height: 172.81px;
  right: 54.6px;
  top: 60px;
  background-image: url('@/assets/images/main/card2.svg');
}

.card3::after {
  width: 144px;
  height: 188px;
  right: 70px;
  top: 46px;
  background-image: url('@/assets/images/main/card3.svg');
}

.card4::after {
  width: 174px;
  height: 153px;
  right: 57px;
  top: 77px;
  background-image: url('@/assets/images/main/card4.svg');
}
// =====================

// == Animation ==
.fadeInBottom {
  animation-name: fadeInBottom;
  animation-duration: 0.5s;
  animation-fill-mode: both;
}

@keyframes fadeInBottom {
  0% {
    opacity: 0;
    transform: translateY(100%);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}

.fade {
  animation-name: fade;
  animation-duration: 3s;
  animation-fill-mode: both;
}

@keyframes fade {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
// ===============
</style>