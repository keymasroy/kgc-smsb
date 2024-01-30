<template>
  <UBox class="main" direction="row">
    <UBox class="columns" style="margin-top: 0px">
      <UItem class="card is-sub" ratio="1" style="min-height: 370px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원가입 현황</span>
          </h2>
        </UBox>

        <div class="breadcrumbs" style="margin-bottom: 10px"><span>기준</span> > <span>현재</span></div>

        <div class="totalMember-titleWrap">
          <span>총 회원가입 수 {{ curDate }} 기준</span>
          <h3>7,159</h3>
          <strong>명</strong>
        </div>

        <UBox>
          <WjFlexChart
            class="totalMemberChart"
            style="height: 210px"
            :itemsSource="lineData"
            bindingX="month"
            chartType="LineSymbols"
            :palette="linePalette1"
          >
            <WjFlexChartLegend position="Bottom" />
            <WjFlexChartAxis wjProperty="axisY" />
            <WjFlexChartSeries binding="curYear" name="당해년" :symbolStyle="lineSymbolStyle" />
            <WjFlexChartSeries binding="preYear" name="전년도" :symbolStyle="lineSymbolStyle" />
            <WjFlexChartAnimation animationMode="Point"></WjFlexChartAnimation>
          </WjFlexChart>
        </UBox>
      </UItem>
      <UItem class="card is-sub bg-transparent" ratio="1">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>승인요청</span>
          </h2>
          <UButton class="ico_plus" />
        </UBox>

        <UBox>
          <ul class="box-list request">
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request1.svg" alt="" />
              <p class="title" style="color: #000">가입 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request2.svg" alt="" />
              <p class="title" style="color: #000">변경 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request3.svg" alt="" />
              <p class="title" style="color: #000">적립 요청</p>
              <p class="data">1,202</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request4.svg" alt="" />
              <p class="title">부정적립 회원 요청</p>
              <p class="data">902</p>
            </li>
            <li class="box-content">
              <img src="@/assets/images/svg/ico_request5.svg" alt="" />
              <p class="title">러셀러 회원 요청</p>
              <p class="data">902</p>
            </li>
          </ul>
        </UBox>
      </UItem>

      <UBox class="item-half" direction="row">
        <UItem class="card is-sub" ratio="1" style="min-height: 310px; padding-bottom: 0">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>마케팅 동의 현황</span>
            </h2>
            <UButton class="ico_plus" />
          </UBox>

          <div class="breadcrumbs"><span>기준</span> > <span>전체회원</span></div>
          <UBox class="pieChart-box">
            <!-- 마케팅 동의 pie chart -->
            <WjFlexPie
              class="main-pieChart"
              bindingName="title"
              binding="value"
              :innerRadius="pieInnerRadius"
              :itemsSource="pieData1"
              :palette="piechartPalette1"
            >
              <WjFlexPieDataLabel position="Inside" :offset="6" :content="getPieLabelContent" />
              <WjFlexChartLegend position="Right" />
            </WjFlexPie>
          </UBox>
        </UItem>
        <UItem class="card is-sub" ratio="1" style="min-height: 310px; padding-bottom: 0">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>약관 동의 현황</span>
            </h2>
            <UButton class="ico_plus" />
          </UBox>
          <div class="breadcrumbs"><span>기준</span> > <span>전체회원</span></div>

          <UBox class="pieChart-box">
            <!-- 마케팅 동의 pie chart -->
            <WjFlexPie
              class="main-pieChart"
              bindingName="service"
              binding="value"
              :innerRadius="pieInnerRadius"
              :itemsSource="pieData2"
              :palette="piechartPalette2"
            >
              <WjFlexPieDataLabel position="Inside" :offset="10" :content="getPieLabelContent" />
              <WjFlexChartLegend position="Right" />
            </WjFlexPie>
          </UBox>
        </UItem>
      </UBox>

      <UItem class="card is-sub" ratio="1" style="min-height: 478px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>발송 현황</span>
          </h2>

          <UButton class="ico_plus" />
        </UBox>

        <div class="breadcrumbs"><span>기준</span> > <span>현재</span></div>

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
        </UBox>
        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid" :isReadOnly="true" style="width: 692px; height: 235px; margin-top: 25px">
            <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
            <WjFlexGridColumn header="발송년월" binding="col1" width="*" />
            <WjFlexGridColumn header="등급별" binding="col1" width="*" />
            <WjFlexGridColumn header="발송명" binding="col1" width="*" />
            <WjFlexGridColumn header="대상건수" binding="col1" width="*" />
            <WjFlexGridColumn header="성공건수" binding="col1" width="*" />
            <WjFlexGridColumn header="실패건수" binding="col1" width="*" />
            <WjFlexGridColumn header="대기건수" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
    <UBox class="columns" style="margin-top: 0px">
      <UItem class="card is-sub" ratio="1" style="min-height: 479px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원가입 현황</span>
          </h2>
        </UBox>

        <div class="breadcrumbs"><span>기준</span> > <span>현재</span></div>

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
                  <img src="@/assets/images/svg/img_royal.svg" alt="" />
                  <span>로얄 회원 수</span>
                </div>
                <div class="data">
                  <strong>19,554</strong>명 <span>(<strong class="up">+108</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_gold.svg" alt="" />
                  <span>골드 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_silver.svg" alt="" />
                  <span>실버 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_family.svg" alt="" />
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
                  <img src="@/assets/images/svg/img_royal.svg" alt="" />
                  <span>로얄 회원 수</span>
                </div>
                <div class="data">
                  <strong>19,554</strong>명 <span>(<strong class="up">+108</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_gold.svg" alt="" />
                  <span>골드 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_silver.svg" alt="" />
                  <span>실버 회원 수</span>
                </div>
                <div class="data">
                  <strong>33,001</strong>명 <span>(<strong class="down">-43</strong>)</span>
                </div>
              </li>
              <li>
                <div class="title">
                  <img src="@/assets/images/svg/img_family.svg" alt="" />
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

        <div class="breadcrumbs"><span>기준</span> > <span>이번달</span></div>

        <UBox>
          <WjFlexChart
            style="height: 270px"
            chartType="Bar"
            bindingX="title"
            stacking="Stacked"
            :itemsSource="memberStateChartData"
            :palette="['rgba(95, 0, 0, 1)']"
          >
            <WjFlexChartAxis wjProperty="axisY" :reversed="true" />
            <WjFlexChartLegend position="None" />
            <WjFlexChartSeries binding="value" />
            <WjFlexChartDataLabel content="{value}" position="Top" :offset="13" :border="true" />
            <WjFlexChartAnimation />
          </WjFlexChart>
        </UBox>
      </UItem>
      <UItem class="card is-sub" ratio="1" style="min-height: 478px">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>포인트 현황</span>
          </h2>
        </UBox>

        <div class="breadcrumbs"><span>기준</span> > <span>현재</span></div>

        <UBox>
          <WjTabPanel :initialized="tabPanel.initialize" class="mt-5 main-chart-tab">
            <WjTab>
              <a>
                <span>적립 포인트</span>
                <strong>10,000</strong>
              </a>
              <div class="chart-tab-inner">
                <WjFlexChart
                  class="tab-chart"
                  stacking="Stacked"
                  bindingX="date"
                  :itemsSource="rowBarChartData"
                  :palette="['rgba(244, 122, 53, 1)', 'rgba(255, 212, 61, 1)', 'rgba(0, 115, 122, 1)', 'rgba(21, 81, 131, 1)']"
                  :itemFormatter="rowChartItemFormatter"
                >
                  <WjFlexChartLegend position="Top" titleAlign="right" />
                  <WjFlexChartSeries binding="jungMall" name="정관장몰" />
                  <WjFlexChartSeries binding="pos" name="POS" />
                  <WjFlexChartSeries binding="carenow" name="케어나우" />
                  <WjFlexChartSeries binding="sapun" name="사푼사푼" />
                </WjFlexChart>
              </div>
            </WjTab>
            <WjTab>
              <a>
                <span>회원변경</span>
                <strong>34,000</strong>
              </a>
              <div>회원변경</div>
            </WjTab>

            <WjTab>
              <a>
                <span>소멸 포인트</span>
                <strong>232</strong>
              </a>
              <div>소멸 포인트</div>
            </WjTab>

            <WjTab>
              <a>
                <span>추가 적립 포인트</span>
                <strong>800</strong>
              </a>
              <div>추가 적립 포인트</div>
            </WjTab>

            <WjTab>
              <a>
                <span>선 포인트</span>
                <strong>5,500</strong>
              </a>
              <div>선 포인트</div>
            </WjTab>
          </WjTabPanel>
        </UBox>
      </UItem>
    </UBox>
  </UBox>
</template>

<script setup lang="ts">
import {
  WjFlexChart,
  WjFlexChartLegend,
  WjFlexChartAxis,
  WjFlexChartSeries,
  WjFlexChartAnimation,
  WjFlexPie,
  WjFlexPieDataLabel,
  WjTabPanel,
  WjTab,
  WjFlexChartDataLabel,
  WjFlexGrid,
  WjFlexGridColumn,
} from '#ustra/nuxt-wijmo/components'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import * as wjCore from '@grapecity/wijmo'
import { useDateFormat, useNow } from '@vueuse/core'

const wijmo = useWijmo()

definePageMeta({
  layout: 'ustra-pub',
  name: 'main_pubs',
  auth: {
    required: false,
  },
})

const lineData = reactive([
  { month: '1월', curYear: 180, preYear: 170 },
  { month: '2월', curYear: 800, preYear: 750 },
  { month: '3월', curYear: -200, preYear: 0 },
  { month: '4월', curYear: -200, preYear: -180 },
  { month: '5월', curYear: -120, preYear: -150 },
  { month: '6월', curYear: 0, preYear: 0 },
  { month: '7월', curYear: 200, preYear: -180 },
  { month: '8월', curYear: 150, preYear: -150 },
  { month: '9월', curYear: 700, preYear: 550 },
  { month: '10월', curYear: 400, preYear: 540 },
  { month: '11월', curYear: -150, preYear: 300 },
  { month: '12월', curYear: 0, preYear: 200 },
])

const linePalette1 = reactive(['rgba(255, 82, 92, 1)', 'rgba(21, 81, 131, 1)'])
const lineSymbolStyle = { symbolWidth: 1, rx: 2, ry: 2 }

const formatter = ref('YYYY-MM-DD')
const curDate = useDateFormat(useNow(), formatter)

const pieData1 = reactive([
  { title: 'SMS(문자)', value: 600 },
  { title: 'TN(전화)', value: 300 },
  { title: 'DM(우편물)', value: 400 },
  { title: 'EM(이메일)', value: 1000 },
])

const pieData2 = reactive([
  { service: '정관장몰', value: 1500 },
  { service: '케어나우', value: 800 },
  { service: '통합멤버스', value: 2400 },
])

function getPieLabelContent(ht) {
  return wijmo.format('{value}', { value: ht.value })
}

const piechartPalette1 = reactive(['rgba(21, 81, 131, 1)', 'rgba(134, 196, 255, 1)', 'rgba(158, 95, 255, 1)', 'rgba(244, 122, 53, 1)'])
const piechartPalette2 = reactive(['rgba(63, 117, 241, 1)', 'rgba(251, 208, 135, 1)', 'rgba(21, 81, 131, 1)'])
const pieInnerRadius = ref(0.45)

const tabPanel = useWijmoTabPanel()

const rowBarChartData = reactive([
  { date: '1월', jungMall: 300, pos: 150, carenow: 150, sapun: 50 },
  { date: '2월', jungMall: 500, pos: 100, carenow: 200, sapun: 50 },
  { date: '3월', jungMall: 200, pos: 100, carenow: 150, sapun: 50 },
  { date: '4월', jungMall: 100, pos: 50, carenow: 50, sapun: 30 },
  { date: '5월', jungMall: 200, pos: 150, carenow: 150, sapun: 50 },
  { date: '6월', jungMall: 300, pos: 150, carenow: 150, sapun: 50 },
  { date: '7월', jungMall: 500, pos: 100, 케어나우: 200, sapun: 50 },
  { date: '8월', jungMall: 200, pos: 100, carenow: 150, sapun: 50 },
  { date: '9월', jungMall: 100, pos: 50, carenow: 50, sapun: 30 },
  { date: '10월', jungMall: 200, pos: 150, carenow: 150, sapun: 50 },
  { date: '11월', jungMall: 200, pos: 150, carenow: 150, sapun: 50 },
  { date: '12월', jungMall: 200, pos: 150, carenow: 150, sapun: 50 },
])

const rowChartItemFormatter = function (engine) {
  //console.log(engine)
}

const memberStateChartData = reactive([
  { title: '가망', value: 18 },
  { title: '입문', value: 5.0 },
  { title: '활성화', value: 24.3 },
  { title: '휴먼', value: 3.7 },
  { title: '이탈1', value: 1.0 },
  { title: '이탈2', value: 4.2 },
  { title: '이탈3', value: 0.9 },
])

const itemsSourceGrid = ref([
  { col1: '텍스트' },
  { col1: '텍스트2' },
  { col1: '텍스트3' },
  { col1: '텍스트' },
  { col1: '텍스트2' },
  { col1: '텍스트3' },
  { col1: '텍스트' },
  { col1: '텍스트2' },
  { col1: '텍스트3' },
  { col1: '텍스트' },
  { col1: '텍스트2' },
  { col1: '텍스트3' },
])
</script>

<style scoped>
.main {
  .breadcrumbs {
    span {
      display: block;

      &:first-child {
        margin-right: 2px;
      }

      &:last-child {
        margin-left: 2px;
      }
    }
  }

  .totalMember-titleWrap {
    display: flex;
    align-items: center;
    justify-content: flex-end;
    margin-bottom: 10px;

    span {
      font-size: 13px;
      font-weight: 500;
      color: #9a9a9a;
      line-height: 18px;
    }

    h3 {
      font-size: 28px;
      font-weight: 700;
      color: #000;
      line-height: 30px;
      margin-left: 12px;
      margin-right: 5px;
    }

    strong {
      font-weight: 600;
      font-size: 17px;
      line-height: 20px;
    }
  }
}

.pieChart-box {
  height: 184px !important;
}
.main-pieChart {
  height: 100%;
}

.chart-tab-inner {
  height: 240px !important;
  .tab-chart {
    height: 230px;
  }
}
</style>

<style>
.totalMemberChart {
  svg {
    .wj-legend {
      fill: #000;
      g {
        line {
          stroke-width: 0;
        }
        ellipse {
          rx: 3.5;
          ry: 3.5;
        }
      }
    }
  }
}

.tab-chart {
  svg {
    .wj-legend {
      fill: #000;
      g {
        rect {
          rx: 10;
          ry: 10;
        }
        .wj-label {
          fill: #9a9a9a;
        }
      }
    }
  }
}
</style>
