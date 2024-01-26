<template>
  <div>
    <UBox class="columns" direction="row" height="735">
      <!-- 좌측 영역 -->
      <UItem class="card is-sub" ratio="4">
        <UBox class="table-title-wrap" direction="row">
          <UItem itemDirection="row" :ratio="1">
            <h2 class="table-title">
              <span>Sub title</span>
              <span class="data-count">총<span>24</span>건</span>
            </h2>
          </UItem>
        </UBox>

        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="채널" binding="col1" width="*" />
          <WjFlexGridColumn header="신청대상" binding="col1" width="*" />
          <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
          <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <!-- 우측 영역 -->
      <UItem class="cards" ratio="8">
        <UItem class="card is-sub">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>회원등급 마스터</span>
            </h2>
            <UButtonBox class="table-buttons">
              <UButton text="신규" type="is-outline" />
              <UButton text="저장" type="is-filled" />
            </UButtonBox>
          </UBox>

          <UFieldSet>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow :ratio="[1, 1]">
              <UField required label="채널"><UWjComboBox :itemsSource="members" displayMemberPath="text" /></UField>
              <UField required label="신청대상"><UWjComboBox :itemsSource="members" displayMemberPath="text" /></UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow :ratio="[1]">
              <UField required label="적용기간"> <UDatePeriodBox v-model="dateArr1" /></UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow :ratio="[1]">
              <UField required label="작업구분"><UWjComboBox :itemsSource="members" displayMemberPath="text" /></UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow :ratio="[1]">
              <UField label="신청개월">
                <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
                  <WjFlexGridColumn header="등급 신청일" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn binding="대상 개월수" header="기념일" width="*" format="yyyy-MM-dd">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <WjInputDate v-model="cell.item.date" />
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>
                </WjFlexGrid>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>

        <UItem class="card is-sub">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>설정정보</span>
            </h2>
            <UButtonBox class="table-buttons">
              <UButton text="추가" type="is-outline" />
              <UButton text="삭제" type="is-outline" />
              <UButton text="저장" type="is-filled" />
            </UButtonBox>
          </UBox>

          <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
            <WjTab>
              <a>기준내역</a>
              <div class="tab-grid">
                <WjFlexGrid :itemsSource="itemsSourceGrid">
                  <WjFlexGridColumn header="No" binding="col1" width="*" />
                  <WjFlexGridColumn header="포인트 지급일" binding="col1" width="*" />
                  <WjFlexGridColumn header="포인트 유형" binding="col1" width="*" />
                  <WjFlexGridColumn header="포인트" binding="col1" width="*" />
                  <WjFlexGridColumn header="내용" binding="col1" width="*" />
                  <WjFlexGridColumn header="소멸 예정일" binding="col1" width="*" />
                </WjFlexGrid>
              </div>
            </WjTab>

            <WjTab>
              <a>예외관리</a>
              <div class="tab-grid">
                <WjFlexGrid :itemsSource="itemsSourceGrid">
                  <WjFlexGridColumn header="No" binding="col1" width="*" />
                  <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                  <WjFlexGridColumn header="채널" binding="col1" width="*" />
                  <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                  <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
                  <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
                  <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
                  <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
                  <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
                  <WjFlexGridColumn header="수정자" binding="col1" width="*" />
                  <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
                </WjFlexGrid>
              </div>
            </WjTab>
          </WjTabPanel>
        </UItem>
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})

const tabPanel = useWijmoTabPanel()

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub',
})
const { collectionView, loadPageData, pageSize, totalRecords, currentPageNo } = usePaginationCollectionView((pageNo, orders) => {
  return useOnError(
    async () => {
      const service = useUstraInterfaceService()
      const result = await service.getIntefaceHistories({
        header: {
          currentPage: pageNo,
          pageSize: pageSize.value,
          orders,
        },
        searchValue: {},
      })
      return {
        data: result.body,
        totalRecords: result.header.totalRecords,
      }
    },
    { message: '데이터 조회 중 오류가 발생하였습니다.' },
  )()
})

const itemsSourceGrid = ref([{ col1: '텍스트' }, { col1: '텍스트2' }, { col1: '텍스트3' }])
</script>
<style lang="scss" scoped>
.columns {
  margin: 10px 0;
  > .card {
    margin: 0 5px;
  }
}

.card.is-sub {
  padding: 10px 20px 15px;
  &.is-search {
    padding: 10px 20px;
    .u-field-set {
      margin-bottom: 0;
    }
  }
}

.u-item {
  &.cards {
    margin: 0 5px;

    .card {
      &:not(:first-child) {
        margin-top: 10px;
      }
    }
  }
}
</style>
