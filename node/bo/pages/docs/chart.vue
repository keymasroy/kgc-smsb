<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-2">
      <div class="column is-half">
        <h1 class="mb-4">Line Chart</h1>
        <WjFlexChart
          :itemsSource="lineData"
          bindingX="month"
          chartType="Line"
          header="월별 수치 변화"
          :palette="[
            'rgba(42,159,214,1)',
            'rgba(119,179,0,1)',
            'rgba(153,51,204,1)',
            'rgba(255,136,0,1)',
            'rgba(204,0,0,1)',
            'rgba(0,204,163,1)',
            'rgba(61,109,204,1)',
            'rgba(82,82,82,1)',
            'rgba(0,0,0,1)',
          ]"
        >
          <WjFlexChartLegend position="Bottom"></WjFlexChartLegend>
          <WjFlexChartAxis wjProperty="axisY" title="수치(%)"></WjFlexChartAxis>
          <WjFlexChartSeries binding="low" name="평균 최소값"></WjFlexChartSeries>
          <WjFlexChartSeries binding="high" name="평균 최대값"></WjFlexChartSeries>
          <WjFlexChartSeries binding="mean" name="일일 평균"></WjFlexChartSeries>

          <WjFlexChartAnimation animationMode="Point"></WjFlexChartAnimation>
        </WjFlexChart>
      </div>

      <div class="column is-half">
        <h1 class="mb-4">Donut Chart</h1>
        <WjFlexPie
          bindingName="brand"
          binding="sales"
          :innerRadius="0.5"
          :itemsSource="pieData"
          :palette="[
            'rgba(42,159,214,1)',
            'rgba(119,179,0,1)',
            'rgba(153,51,204,1)',
            'rgba(255,136,0,1)',
            'rgba(204,0,0,1)',
            'rgba(0,204,163,1)',
            'rgba(61,109,204,1)',
            'rgba(82,82,82,1)',
            'rgba(0,0,0,1)',
          ]"
        >
          <WjFlexPieDataLabel position="Inside" :offset="15" :content="getPieLabelContent" />
          <WjFlexChartLegend position="Right" />
        </WjFlexPie>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mt-10 mb-4">막대차트 가로</h1>
        <WjFlexChart chartType="Bar" bindingX="title" stacking="Stacked" :itemsSource="colBarChartData" :palette="['rgba(95, 0, 0, 1)']">
          <WjFlexChartAxis wjProperty="axisY" />
          <WjFlexChartLegend position="None" />
          <WjFlexChartSeries binding="value" />
          <WjFlexChartAnimation />
        </WjFlexChart>
      </div>

      <div class="column is-half">
        <h1 class="mt-10 mb-4">막대차트 세로</h1>
        <WjFlexChart
          stacking="Stacked"
          bindingX="date"
          :itemsSource="rowBarChartData"
          :palette="['rgba(244, 122, 53, 1)', 'rgba(255, 212, 61, 1)', 'rgba(0, 115, 122, 1)', 'rgba(21, 81, 131, 1)']"
        >
          <WjFlexChartLegend position="None" />
          <WjFlexChartSeries binding="정관장몰" />
          <WjFlexChartSeries binding="pos" />
          <WjFlexChartSeries binding="케어나우" />
          <WjFlexChartSeries binding="사푼사푼" />
          <WjFlexChartAnimation />
        </WjFlexChart>
      </div>
    </div>
  </div>
</template>

<script setup>
import {
  WjFlexChart,
  WjFlexChartLegend,
  WjFlexChartAxis,
  WjFlexChartSeries,
  WjFlexChartAnimation,
  WjFlexPie,
  WjFlexPieDataLabel,
} from '#ustra/nuxt-wijmo/components'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import * as wjCore from '@grapecity/wijmo'

const wijmo = useWijmo()

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const lineData = reactive([
  { month: 'Jan', mean: -5.2, high: -0.8, low: -9.7 },
  { month: 'Feb', mean: -3.4, high: 1.4, low: -8.2 },
  { month: 'Mar', mean: 1.7, high: 6.9, low: -3.5 },
  { month: 'Apr', mean: 8.8, high: 14.6, low: 2.9 },
  { month: 'May', mean: 14.6, high: 20.8, low: 8.4 },
  { month: 'Jun', mean: 19.6, high: 25.5, low: 13.6 },
  { month: 'Jul', mean: 22.1, high: 27.9, low: 16.3 },
  { month: 'Aug', mean: 21.2, high: 26.9, low: 15.5 },
  { month: 'Sep', mean: 16.6, high: 22.3, low: 10.9 },
  { month: 'Oct', mean: 9.8, high: 15.4, low: 4.2 },
  { month: 'Nov', mean: 4.3, high: 8.8, low: -0.3 },
  { month: 'Dec', mean: -1.9, high: 2.1, low: -6 },
])

const pieData = reactive([
  { brand: 'Samsung', sales: 321 },
  { brand: 'Apple', sales: 215 },
  { brand: 'Huawei', sales: 160 },
  { brand: 'OPPO', sales: 112 },
  { brand: 'Vivo', sales: 100 },
  { brand: 'Others', sales: 638 },
])

function getPieLabelContent(ht) {
  return wijmo.format('{name}', { name: ht.name })
}

const colBarChartData = reactive([
  { title: '가망', value: 18 },
  { title: '입문', value: 5.0 },
  { title: '활성화', value: 24.3 },
  { title: '휴먼', value: 3.7 },
])
;[
  ({ year: '2014', US: 17348075, China: 10356508, Japan: 4602367, Germany: 3874437, UK: 2950039, France: 2833687, India: 2051228, Italy: 2147744 },
  { year: '2015', US: 18036650, China: 11181556, Japan: 4124211, Germany: 3365293, UK: 2858482, France: 2420163, India: 2073002, Italy: 1815759 },
  { year: '2016', US: 18624450, China: 11232110, Japan: 4936540, Germany: 3479230, UK: 2629190, France: 2466470, India: 2263790, Italy: 1850740 }),
]

const rowBarChartData = reactive([
  { date: '1월', 정관장몰: 300, pos: 150, 케어나우: 150, 사푼사푼: 50 },
  { date: '2월', 정관장몰: 500, pos: 100, 케어나우: 200, 사푼사푼: 50 },
  { date: '3월', 정관장몰: 200, pos: 100, 케어나우: 150, 사푼사푼: 50 },
  { date: '4월', 정관장몰: 100, pos: 50, 케어나우: 50, 사푼사푼: 30 },
  { date: '5월', 정관장몰: 200, pos: 150, 케어나우: 150, 사푼사푼: 50 },
])
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>
