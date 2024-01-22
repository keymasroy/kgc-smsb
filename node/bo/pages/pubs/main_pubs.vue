<template>
  <UBox class="main" direction="row">
    <UBox class="columns">
      <UItem class="card is-sub" ratio="1" style="min-height: 370px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원가입 현황</span>
          </h2>
        </UBox>
          
        <div class="breadcrumbs">
          <span>기준</span> > <span>현재</span>
        </div>

        <UBox>
          차트영역
        </UBox>
      </UItem>
      <UItem class="card is-sub bg-transparent" ratio="1">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>승인요청</span>
          </h2>
          <UButton class="ico_plus"/>
        </UBox>
        
        <UBox>
          <ul class="box-list request">
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request1.svg" alt="">
              <p class="title">가입 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request2.svg" alt="">
              <p class="title">변경 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request3.svg" alt="">
              <p class="title">적립 요청</p>
              <p class="data">1,202</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request4.svg" alt="">
              <p class="title">부정적립 회원 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request5.svg" alt="">
              <p class="title">러셀러 회원 요청</p>
              <p class="data">902</p>
            </li>
          </ul>
        </UBox>
      </UItem>

      <UBox class="item-half" direction="row">
        <UItem class="card is-sub" ratio="1" style="min-height: 310px">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>마케팅 동의 현황</span>
            </h2>
            <UButton class="ico_plus"/>
          </UBox>

          <div class="breadcrumbs">
            <span>기준</span> > <span>현재</span>
          </div>
          <UBox>
            차트영역
          </UBox>
        </UItem>
        <UItem class="card is-sub" ratio="1" style="min-height: 310px">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>약관 동의 현황</span>
            </h2>
            <UButton class="ico_plus"/>
          </UBox>

          <UBox>
            차트영역
          </UBox>
        </UItem>
      </UBox>

      <UItem class="card is-sub" ratio="1" style="min-height: 478px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>발송 현황</span>
          </h2>

          <UButton class="ico_plus"/>
        </UBox>

        <div class="breadcrumbs">
          <span>기준</span> > <span>현재</span>
        </div>
        
        <UBox>
          <ul class="box-list">
            <li class="box-content">
              <p class="title">SMS 총 건수</p>
              <p class="data">10</p>
            </li>
            <li class="box-content">
              <p class="title">LMS 총 건수</p>
              <p class="data">2,009</p>
            </li>
            <li class="box-content">
              <p class="title">SMS 총 건수</p>
              <p class="data">7</p>
            </li>
            <li class="box-content">
              <p class="title">SMS 총 건수</p>
              <p class="data">909</p>
            </li>
            <li class="box-content">
              <p class="title">SMS 총 건수</p>
              <p class="data">23,411</p>
            </li>
          </ul>
          차트영역
        </UBox>
      </UItem>

    </UBox>
    <UBox class="columns">
      <UItem class="card is-sub" ratio="1" style="min-height: 479px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원가입 현황</span>
          </h2>
        </UBox>
        
        <div class="breadcrumbs">
            <span>기준</span> > <span>현재</span>
          </div>

        <UBox direction="row" class="item-half">
          <UItem ratio="1">
            <UItem class="box-content is-large">
              <div class="box-left">
                <span class="title">전체 회원수</span>
              </div>
              <div class="box-right">
                <span class="date">2024년 1월 기준</span>
                <span class="data"><strong>184,300</strong>명</span>
              </div>
            </UItem>
            
            <ul class="ranking-list">
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_royal.svg" alt="">
                  <span>로얄 회원 수</span>
                </div>
                <div class="data">
                  <strong>19,554</strong>명 <span>(<strong class="up">+108</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_gold.svg" alt="">
                  <span>골드 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_silver.svg" alt="">
                  <span>실버 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_family.svg" alt="">
                  <span>패밀리 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span class="">(<strong class="down">-43</strong>)</span>
                </div>
              </li>
            </ul>            
          </UItem>
          <UItem ratio="1">
            <UItem class="box-content is-large">
              <div class="box-left">
                <span class="title">신규가입 회원 수</span>
              </div>
              <div class="box-right">
                <span class="date">2024년 1월 기준</span>
                <span class="data"><strong>184,300</strong>명</span>
              </div>
            </UItem>
            
            <ul class="ranking-list">
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_royal.svg" alt="">
                  <span>로얄 회원 수</span>
                </div>
                <div class="data">
                  <strong>19,554</strong>명 <span>(<strong class="up">+108</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_gold.svg" alt="">
                  <span>골드 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_silver.svg" alt="">
                  <span>실버 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_family.svg" alt="">
                  <span>패밀리 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span class="">(<strong class="down">-43</strong>)</span>
                </div>
              </li>
            </ul>
          </UItem>
        </UBox>
      </UItem>
      <UItem class="card is-sub" ratio="1" style="min-height: 395px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원상태 현황</span>
          </h2>
        </UBox>
        
        <div class="breadcrumbs">
          <span>기준</span> > <span>이번달</span>
        </div>

        <UBox>
          차트영역
        </UBox>
      </UItem>
      <UItem class="card is-sub" ratio="1" style="min-height: 478px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>포인트 현황</span>
          </h2>
        </UBox>
      
        <div class="breadcrumbs">
          <span>기준</span> > <span>현재</span>
        </div>

        <UBox>
          차트영역
        </UBox>
      </UItem>
    </UBox>
  </UBox>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'ustra-pub',
  name: 'main',
  auth: {
    required: false,
  },
})
</script>

<style scoped></style>
