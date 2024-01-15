<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">업무도움말 미리보기</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="800" title="업무도움말 미리보기">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="담당업무" binding="col1" width="*" />
          <WjFlexGridColumn header="담당부서" binding="col1" width="*" />
          <WjFlexGridColumn header="담당자" binding="col1" width="*" />
          <WjFlexGridColumn header="연락처" binding="col1" width="*" />
          <WjFlexGridColumn header="이메일" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>

      <UItem class="file-uploader">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
              <span>첨부파일</span>
          </h2>
        </UBox>
        <UMultiFileUploader ref="uploader" :readonly="true"/>
      </UItem>

      <UItem>
        <UBox class="table-title-wrap">
          <h2 class="table-title">
              <span>상세내역</span>
          </h2>
        </UBox>
        <UTextBox type="textarea" v-model="test"/>
      </UItem>

      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

const itemsSourceGrid = ref([
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
]);


</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>