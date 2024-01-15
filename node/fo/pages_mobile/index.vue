<template>
  <article ref="main" class="main">
    <section class="main__visual">
      <div class="main__visual-inner w-full">
        <div ref="visual" class="main__visual-text">
          <span class="z-30 font-bold text-[52px] text-white">EARTH</span>
          <span class="z-10 mt-[-34px] font-semibold text-[46px] text-[#B39281] italic top-[15px]">To</span>
          <span class="z-30 font-bold text-[52px] text-white top-[50px]">HEALTH</span>
          <img
            :src="visualImageSrc"
            alt="배경 이미지"
            class="z-20 main__visual-image"
            :style="{top: `${visualImageTop || 0}px`}"
          />
        </div>
        <p class="ext-base text-[13px] text-white px-[36px] mt-[28px]">정관장은 Healthy Life Style Supporter로서건강한 삶의 기준을 제공합니다.</p>
      </div>
    </section>
    <div class="main__contents h-full">
      <div class="main__contents-inner h-full">
        <div class="flex flex-col items-center bg-white mt-[71px] py-[20px] z-10">
          <span class="text-[30px] font-[350] tracking-[-0.03em]">
            쓸수록 쌓이는 <strong>쇼핑의 즐거움!</strong>
          </span>
          <span class="text-[13px] mt-[4px] text-center text-[#222222] pretendard">
            회원이 되시면 쿠폰부터 포인트까지 다양한 <br /> 혜택을 받을 수 있습니다.
          </span>
        </div>

        <div class="cardList mt-[31px] z-10">
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
import { ref } from 'vue';

definePageMeta({
  layout: 'main',
});

const main = ref(null);
const visual = ref(null);
const { y: winScoll } = useScroll(document);
const { height: visualHeight, y: visualY } = useElementBounding(visual);

const visualImagesType = [top1, top2, top3, top4];
const visualImageSrc = ref(visualImagesType[0]);
const visualImageTop = ref(null);
const max_top = 120;

const cardList = ref([
  { title: '멤버십 혜택', desc: '회원에게만 드리는 큰 혜택', router: '/pubs/MI/ID/UI_FU_0044' },
  { title: '통합 포인트', desc: '쇼핑할수록 더 해지는 즐거움', router: '/pubs/MP/PI/UI_FU_0051' },
  { title: '생일쿠폰', desc: '기념일에 맞춰 정쿠폰 발급', router: '/pubs/MP/MI/UI_FU_0059' },
  { title: '포인트 선물', desc: '가족 또는 친구에게 건강한 선물', router: '/pubs/MP/PG/UI_FU_0055' },
])

watchThrottled(
  () => winScoll.value,
  newValue => {
    // visualY 을 3등분 해서 포인트 잡아서 이미지 바꿔줄 거임
    // visualHeight - visualY 뺀 값을 100% 로 계산해서 이동시켜 줄거임
    const offsetTop = visual.value.offsetTop;
    
    const _top = visualHeight.value - visualY.value - offsetTop;

    console.log('visualHeight: ',visualHeight.value);
    console.log('visualY: ',visualY.value);
    console.log('offsetTop: ',offsetTop);
    console.log('_top: ', _top);
    console.log('=================================');

    // 이미지 top pixel 변경
    visualImageTop.value = handleChangeTopImageTop(_top);

    // 이미지 src 변경
    visualImageSrc.value = visualImagesType[handleChangeImage(_top)];
  },
  { throttle: 100 },
);

// useResizeObserver(main, (entries) => {
//   const [entry] = entries;
//   const { width, height } = entry.contentRect;
//   visualScale.value = (width / 360) -1;
// })

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
.main__visual {
  position: relative;
  width: 100%;
  height: 100vh;
  background: url('@/assets/images/main/bg-mobile.png') no-repeat;
  background-size: cover;
  background-position: center;

  &::before {
    content: '';
    z-index: 1;
    position: absolute;
    left: 50%;
    bottom: 0;
    transform: translateX(-50%);
    width: 5px;
    height: 100px;
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
  top: 92px;
  left: 50%;
  transform: translateX(-50%);
  padding-top: 70px;

  height: calc(100% - 300px);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  &::before {
    content: '';
    position: absolute;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    width: 5px;
    height: 50px;
    background-color: var(--j-primary01);;
  }
}

.main__visual-text {
  font-family: 'Montserrat';
  position: relative;
  padding-top: 20px;
  padding-bottom: 30px;
  > span {
    display: block;
    position: relative;
    text-align: center;
    line-height: 1.2;
  }
}

.main__visual-image {
  position: absolute;
  left: 85%;
  width: 146.51px;
  height: 76.75px;
  margin-left: -140px;
  transition: all 0.1s;
}

.main__contents {
  position: relative;
  height: fit-content;
  
  .main__contents-inner {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 50px;
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
    flex-direction: column;
    position: relative;
    left: -1px;

    .card {
      position: relative;
      padding: 20px;
      border: 1px solid #F0F0F0;
      display: flex;
      flex-direction: column;
      width: 320px;
      height: 150px;
      cursor: pointer;
      transition: all 0.25s;
      background-color: var(--j-white);

      &:nth-child(3) {
        margin-top: 30px;
      }

      &:not(:nth-child(odd)) {
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
        font-size: 22px;
        line-height: 33px;
        color: var(--j-gray700);
      }

      .desc {
        font-size: 13px;
        line-height: 20.8px;
        color: #8B8B8B;
      }

      &:hover {
        transform: translateY(-10px);
        transition: 0.15s ease-in-out;
        .arrow {
          background-image: url("data:image/svg+xml,%3Csvg width='38' height='38' viewBox='0 0 38 38' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='19' cy='19' r='19' fill='%23F46144'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M23.0092 13.2188L28.7827 18.9719C29.0724 19.2636 29.0724 19.7364 28.7827 20.0281L23.0092 25.7812C22.7195 26.0729 22.2498 26.0729 21.9601 25.7812C21.6704 25.4896 21.6704 25.0167 21.9601 24.725L26.4674 20.2469H10.7418C10.3321 20.2469 10 19.9125 10 19.5C10 19.0875 10.3321 18.7531 10.7418 18.7531H26.4674L21.9601 14.275C21.6704 13.9833 21.6704 13.5104 21.9601 13.2188C22.2498 12.9271 22.7195 12.9271 23.0092 13.2188Z' fill='white'/%3E%3C/svg%3E%0A");
        }
      }

      .arrow {
        width: 24px;
        height: 24px;
        margin-top: 10px;
        cursor: pointer;
        background-image: url("data:image/svg+xml,%3Csvg width='38' height='38' viewBox='0 0 38 38' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Ccircle cx='19' cy='19' r='18.5' stroke='%23CBCBCB'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M23.0092 13.2188L28.7827 18.9719C29.0724 19.2636 29.0724 19.7364 28.7827 20.0281L23.0092 25.7812C22.7195 26.0729 22.2498 26.0729 21.9601 25.7812C21.6704 25.4896 21.6704 25.0167 21.9601 24.725L26.4674 20.2469H10.7418C10.3321 20.2469 10 19.9125 10 19.5C10 19.0875 10.3321 18.7531 10.7418 18.7531H26.4674L21.9601 14.275C21.6704 13.9833 21.6704 13.5104 21.9601 13.2188C22.2498 12.9271 22.7195 12.9271 23.0092 13.2188Z' fill='%23CBCBCB'/%3E%3C/svg%3E%0A");
        background-size: contain;
      }
    }
  }
}

// === Card 배경 이미지 ===
.card::after {
  content: '';
  position: absolute;
  right: 0;
  bottom: -1px;
  background-position: right bottom;
  pointer-events: none;
}
.card1::after {
  width: 218.58px;
  height: 139.29px;
  background-image: url('@/assets/images/main/card1-mobile.png');
}

.card2::after {
  width: 261px;
  height: 254px;
  background-image: url('@/assets/images/main/card2-mobile.png');
}

.card3::after {
  width: 179px;
  height: 125px;
  background-image: url('@/assets/images/main/card3-mobile.png');
  background-position: center;
}

.card4::after {
  width: 157.97px;
  height: 148.93px;
  background-image: url('@/assets/images/main/card4-mobile.png');
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
// ===============

.pretendard {
  font-family: 'Pretendard';
}
</style>