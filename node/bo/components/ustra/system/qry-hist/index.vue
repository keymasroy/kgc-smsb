<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '300px']">
            <UField label="프로세스 아이디">
              <UTextBox type="text" v-model="searchAction.searchParam.procId" />
            </UField>
            <UField label="요청 아이디">
              <UTextBox type="text" v-model="searchAction.searchParam.reqId" />
            </UField>
            <UField label="인터페이스 아이디">
              <UTextBox type="text" v-model="searchAction.searchParam.ifId" />
            </UField>
            <!-- <UField direction="row" label="URL">
            <UTextBox type="text" v-model="searchAction.searchParam.url" style="width: 230px" />
          </UField> -->
            <UField blank>
              <div class="search-btn">
                <UButton text="엑셀다운로드" icon="excel" type="default" @click="gridAction.excelDownload" />
                <UButton class="gray ico_reset"><span class="blind">초기화</span></UButton>
                <UButton text="조회" type="is-search" @click="searchAction.loadSearchedData" />
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, 1, '300px']">
            <UField label="URL">
              <UTextBox type="text" v-model="searchAction.searchParam.url" />
            </UField>
            <UField direction="row" label="채널 코드">
              <UCodeComboBox grpCd="CHNL_CD" v-model="searchAction.searchParam.chnlCd" :displayNullText="'전체'" />
            </UField>
            <UField direction="row" label="성공 여부">
              <WjComboBox
                v-model="searchAction.searchParam.succYn"
                :itemsSource="searchAction.succYnItems"
                displayMemberPath="text"
                selectedValuePath="value"
              />
            </UField>
            <UField blank></UField>
            <!-- <UField direction="row" label="응답 코드 값">
            <UTextBox type="text" v-model="searchAction.searchParam.resCdVal" style="width: 230px" />
          </UField> -->
          </UFieldRow>
          <UFieldRow :ratio="[1, 2, '300px']">
            <UField direction="row" label="응답 코드 값">
              <UTextBox type="text" v-model="searchAction.searchParam.resCdVal" />
            </UField>
            <UField label="기간">
              <UDatePeriodBox
                v-model:start="searchAction.searchParam.searchSrtDttm"
                v-model:end="searchAction.searchParam.searchEndDttm"
                mode="datetime"
                displayFormat="yyyy-MM-dd HH:mm"
                valueFormat="yyyyMMddHHmm"
              />
              <UField blank></UField>
              <UField blank></UField>
            </UField>
          </UFieldRow>
        </UFieldSet>
        <!-- <UButtonBox :center="true">
        <UButton class="gray ico_reset" @click="searchAction.clearSearchParam"><span class="blind">초기화</span></UButton>
        <UButton text="조회" class="primary ico_search" @click="searchAction.loadSearchedData" />
        <UButton text="엑셀다운로드" icon="xlsxfile" type="default" @click="gridAction.excelDownload" />
      </UButtonBox> -->
      </UItem>
    </UBox>
    <!-- // 검색영역 -->

    <UBox class="columns" direction="row" v-if="true">
      <UItem class="card is-sub" ratio="1">
        <UBox direction="row" style="gap: 5px">
          <!-- 인터페이스 list -->
          <UItem :ratio="4">
            <WjFlexGrid style="height: 500px" :initialized="gridAction.histGrid.initialize">
              <WjFlexGridColumn binding="usrKey" header="사용자키" width="*" />
              <WjFlexGridColumn binding="usrKey" header="사용자명" width="*" />
              <WjFlexGridColumn binding="mnuNn" header="메뉴명" width="*" />
              <WjFlexGridColumn binding="rmk" header="액션" width="*" />
              <WjFlexGridColumn binding="procId" header="프로세스 아이디" width="*" />
              <WjFlexGridColumn binding="reqId" header="요청아이디" width="*" />
              <!-- <WjFlexGridColumn binding="reqNo" header="요청번호" width="*" /> -->
              <!-- <WjFlexGridColumn binding="ifId" header="I/F아이디" width="*" /> -->
              <!-- <WjFlexGridColumn binding="ifVer" header="I/F버전" width="*" /> -->
              <!-- <WjFlexGridColumn binding="ifNm" header="I/F명" width="*" /> -->
              <!-- <WjFlexGridColumn binding="sysCd" header="시스템코드" width="*" /> -->
              <!-- <WjFlexGridColumn binding="chnlCd" header="채널코드" width="*" /> -->
              <!-- <WjFlexGridColumn binding="url" header="url" width="*" /> -->
              <!-- <WjFlexGridColumn binding="httpMethCd" header="http메소드코드" width="*" /> -->
              <!-- <WjFlexGridColumn binding="succYn" header="성공여부" width="*" /> -->
              <!-- <WjFlexGridColumn binding="resCdVal" header="응답코드값" width="*" /> -->
              <!-- <WjFlexGridColumn binding="httpSttCdVal" header="http상태코드값" width="*" /> -->
              <!-- <WjFlexGridColumn binding="usrId" header="사용자아이디" width="*" /> -->
              <WjFlexGridColumn binding="regDttm" header="처리일시" width="*" :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)" />
            </WjFlexGrid>
          </UItem>

          <!-- 상세 list -->
          <UItem :ratio="6" v-if="gridAction.detailVisible.value">
            <WjFlexGrid style="height: 500px" :itemsSource="gridAction.qryDetail.value">
              <!-- <WjFlexGridColumn binding="no" header="no" width="*" /> -->
              <WjFlexGridColumn binding="execQryCont" header="execQryCont" width="5*">
                <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                  <textarea cols="110" rows="20">{{ cell.item.execQryCont }}</textarea>
                </WjFlexGridCellTemplate>
              </WjFlexGridColumn>
              <WjFlexGridColumn binding="regDttm" header="처리일시" width="*" :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)" />
            </WjFlexGrid>
            <!-- 
            <UFieldSet>
            <UFieldRow>
              <UField label="요청 헤더 내용"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.reqHedCont" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="요청 파라메터 내용"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.reqPrmCont" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="요청 메시지"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.reqMsgCont" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="응답 헤더 내용"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.resHedCont" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="응답 메시지"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.resMsgCont" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="비고"><UTextBox type="textarea" rows="2" noResize v-model="formAction.inputData.rmk" /> </UField>
            </UFieldRow>
            <UFieldRow>
              <UButtonBox :right="true">
                <UButton text="확인" @click="formAction.close" />
              </UButtonBox>
            </UFieldRow>
          </UFieldSet> -->
          </UItem>
        </UBox>
      </UItem>
    </UBox>
  </div>
</template>
<script lang="ts" setup>
import { ref, reactive, useOnError } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  WjComboBox,
  WjFlexGridCellTemplate,
} from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { IfsCriteria, IfsHist } from '#ustra/nuxt/management/models/interfaces'
import { QryHist, QryHistCriteria } from '~/models/qry-hist'
import { useUstraInterfaceService } from '#ustra/nuxt/management'
import { useQryHistService } from '~/services/qry-hist'

const service = useUstraInterfaceService()
const histService = useQryHistService()

const searchAction = (function () {
  const searchParam: IfsCriteria = reactive({
    procId: null,
    reqId: null,
    ifId: null,
    sysCd: null,
    chnlCd: null,
    url: null,
    succYn: null,
    resCdVal: null,
    searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMddHHmm'),
    searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMddHHmm'),
  })

  function clearSearchParam() {
    Object.assign(searchParam, {
      procId: null,
      reqId: null,
      ifId: null,
      sysCd: null,
      chnlCd: null,
      url: null,
      succYn: null,
      resCdVal: null,
      searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMddHHmm'),
      searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMddHHmm'),
    })
  }

  async function loadSearchedData() {
    formAction.isFormVisible.value = false
    gridAction.histGrid.pagination.loadPageData(1)
  }

  const succYnItems = reactive([
    { value: null, text: '전체' },
    { value: 'Y', text: '성공' },
    { value: 'N', text: '실패' },
  ])

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
    succYnItems,
  }
})()

// const detailAction = (() => {
//   const detailGrid = useWijmoFlexGrid({})

//   // const qryDetail = ref<QryHist[]>([])
//   // const users = ref<User[]>([])

//   const detailVisible = ref(false)

//   return {
//     detailGrid,
//     qryDetail,
//     detailVisible,
//   }
// })()

const gridAction = (function () {
  const qryDetail = ref<QryHist[]>([])
  const detailVisible = ref(false)

  const histGrid = useWijmoFlexGrid({
    async onCellClick(col, row, data) {
      const qryHistCriteria: QryHistCriteria = {
        procId: data.procId,
        reqId: data.reqId,
      }

      qryDetail.value = await histService.getQryHist(qryHistCriteria)
      detailVisible.value = true
    },
    pagination: {
      mode: 'infinite',
      handler(currentPage, pageSize, orders) {
        return useOnError(
          async () => {
            const saveData: IfsCriteria = reactive({})
            Object.assign(saveData, searchAction.searchParam)
            saveData.searchSrtDttm = searchAction.searchParam.searchSrtDttm
              ? searchAction.searchParam.searchSrtDttm.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5')
              : null
            saveData.searchEndDttm = searchAction.searchParam.searchEndDttm
              ? searchAction.searchParam.searchEndDttm.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5')
              : null

            const result = await service.getIntefaceHistories({
              header: {
                currentPage,
                pageSize,
                orders,
              },
              searchValue: {
                ...saveData,
              },
            })
            return {
              data: result.body,
              totalRecords: result.header.totalRecords,
            }
          },
          { message: '데이터 조회 중 오류가 발생하였습니다.' },
        )()
      },
      pageSize: 20,
    },
  })

  function excelDownload() {
    const saveData: IfsCriteria = reactive({})
    Object.assign(saveData, searchAction.searchParam)
    saveData.searchSrtDttm = searchAction.searchParam.searchSrtDttm
      ? searchAction.searchParam.searchSrtDttm.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5')
      : null
    saveData.searchEndDttm = searchAction.searchParam.searchEndDttm
      ? searchAction.searchParam.searchEndDttm.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5')
      : null

    if (histGrid.pagination.collectionView.items.length < 1) {
      alert('엑셀 다운로드할 데이터가 없습니다.')
      return
    } else {
      const url = $ustra.api
        .urlBuilder('/api/system/ifshist/download/excel')
        .addBase64('paginationRequest', {
          currentPage: 0,
          pageSize: 0,
          orders: null,
        })
        .addBase64('criteria', { searchValue: saveData })
        .build()
      $ustra.api.downloadFile({
        fileName: '인터페이스이력.xlsx',
        url,
        method: 'GET',
      })
    }
  }

  return {
    histGrid,
    excelDownload,
    detailVisible,
    qryDetail,
  }
})()

const formAction = (function () {
  const inputData = reactive({
    reqHedCont: null,
    reqPrmCont: null,
    reqMsgCont: null,
    resHedCont: null,
    resMsgCont: null,
    rmk: null,
  })

  const isFormVisible = ref(false)
  function close() {
    isFormVisible.value = false
  }
  return { inputData, isFormVisible, close }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemIfsHist',
}
</script>
<style scoped></style>
