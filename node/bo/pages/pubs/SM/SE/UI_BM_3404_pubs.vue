<template>
  <div>
    <UBox class="columns" direction="row" height="1230">
      <!-- 좌측 영역 -->
      <!-- 카톡미리보기 
      <UItem class="card is-sub preview" ratio="4">
        <div class="img">
          <img src="@/assets/images/preview.png" alt="">
        </div>
        <div class="img_desc">
          <span>기기에 따라 다르게 보일 수 있습니다.</span>
        </div>
        <UItem class="preview-form">
          <span>수신번호</span>
          <UTextBox></UTextBox>
          <UButton text="테스트 발송하기" type="is-filled"></UButton>
        </UItem>
      </UItem>-->
      <!-- // 카톡미리보기 -->

      <!-- 입력 미리보기 -->
      <UItem class="card is-sub preview write" ratio="4">
        <div class="preview-text">
          <div class="preview_title_wrap">
            <h2>{{ handleTitle }}</h2>
          </div>
          <div class="desc">
            <p v-html="handleDesc"></p>
          </div>
          <!-- <div class="byte"><strong>102</strong>/<span>3000</span>byte</div> -->
        </div>
        <UItem class="preview-form">
          <span>수신번호</span>
          <UTextBox></UTextBox>
          <UButton text="테스트 발송하기" type="is-filled"></UButton>
        </UItem>
      </UItem>
      <!-- 입력 미리보기 -->

      <!-- 우측 영역 -->
      <UItem class="card is-sub" ratio="8">
        <UBox class="table-title-wrap" direction="row">
          <UItem itemDirection="row" :ratio="1">
            <UButtonBox class="table-buttons">
              <UButton text="신규" type="is-outline" />
              <UButton text="저장" type="is-filled" />
            </UButtonBox>
          </UItem>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1, 1]">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField required label="발송유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1, 1]">
            <UField required label="발송수단">
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField required label="발송형태">
              <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1, 1]">
            <UField required label="템플릿ID">
              <UTextBox></UTextBox>
            </UField>
            <UField required label="템플릿명">
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1, 1]">
            <UField required label="사용여부">
              <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
            </UField>
            <UField blank></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1, 1]">
            <UField label="발신프로필키">
              <UTextBox></UTextBox>
            </UField>
            <UField label="템플릿코드">
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1]">
            <UField required label="제목">
              <UBox>
                <UTextBox style="width: 100px" v-model="pTitle" />
                <UTextBox v-model="title"></UTextBox>
              </UBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField required label="내용">
              <UTextBox type="textarea" v-model="desc" rows="15" />
              <UTextBox style="margin-left: 0" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="첨부파일">
              <UMultiFileUploader ref="uploader" fileGroupId="menuIcon" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="사용변수">
              <UBox class="table-title-wrap">
                <UButtonBox class="table-buttons">
                  <UButton text="추가" type="is-outline" />
                  <UButton text="삭제" type="is-outline" />
                  <UButton text="저장" type="is-filled" />
                </UButtonBox>
              </UBox>

              <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2" style="margin-top: 0">
                <WjFlexGridColumn header="선택" binding="col1" width="*" align="center">
                  <WjFlexGridCellTemplate cellType="Cell">
                    <div style="margin-top: 10px">
                      <UCheckGroupBox :items-source="[{ text: '' }]" style="width: 16px; margin-right: 0" />
                    </div>
                  </WjFlexGridCellTemplate>
                </WjFlexGridColumn>
                <WjFlexGridColumn header="No" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="변수명" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="표현식" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="형식" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="기본값" binding="col1" width="*"></WjFlexGridColumn>
              </WjFlexGrid>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: true,
})

const ckEditor = useUstraCkEditor5()

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

const solarItems = reactive([
  { value: '1', text: '예' },
  { value: '2', text: '아니오' },
])
const solarValue = ref('1')

const itemsSourceGrid = ref([{ col1: '텍스트' }, { col1: '텍스트2' }, { col1: '텍스트3' }])

const pTitle = ref('광고')
const title = ref('포인트 소멸 안내입니다.')
const desc = ref(
  '홍길동 회원님,안녕하세요.\n회원님께서 보유하신 멤버스 포인트가 소멸될예정입니다.\n\n단, 선포인트로 추가된 포인트는 소멸 날짜가 다를 수 있습니다.\n회원님의 포인트는 정관장 매장에서 결제수단으로 사용하실 수 있습니다.\n정관장과 함께 항상 건강하시고 행복한 날 되시기 바랍니다. 감사합니다.',
)

const handleDesc = computed(() => (desc.value === null ? (desc.value = '') : desc.value.replaceAll('\n', '<br />')))
const handleTitle = computed(() => {
  if (pTitle.value === null || pTitle.value === undefined) pTitle.value = ''
  if (title.value === null || title.value === undefined) title.value = ''

  return pTitle.value === '' ? `${pTitle.value} ${title.value}` : `[${pTitle.value}] ${title.value}`
})
</script>

<style lang="scss" scoped>
.img_desc {
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 13px;
  color: #8e8e8e;
}

.preview-text {
  // padding-top: 0;

  .desc {
    max-height: 530px;
    overflow-y: auto;
    overflow-x: hidden;
    word-break: break-all;
    overflow-wrap: break-word;
  }
}

.preview_title_wrap {
  padding: 15px 18px;
  min-height: 51px;

  h2 {
    color: #000;
    font-weight: 600;
    font-size: 16px;
    line-height: 20px;
    word-break: break-all;
    overflow-wrap: break-word;
  }
}
</style>
