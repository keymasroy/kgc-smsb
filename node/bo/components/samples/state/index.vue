import { mapActions } from '@ustra/nuxt/src/store';
<template>
  <VCard title="상태 관리 사용 예제">
    <template #text>
      common 프로젝트의 state-pinia.ts 를 통해 문자 데이터를 상태 관리에 사용할 수 있습니다.
      <UMarkdownViewer :content="state1" />
      <div><UTextBox v-model="textValue" :width="200"></UTextBox></div>
      <div>
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          store data : {{ useStringStore().get }}
        </v-chip>
      </div>
      <div>
        <UButton text="store set" @click="setStringStore" />
        <UButton text="store get" type="is-outline" @click="getStringStore" />
      </div>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
// @ts-ignore
import state1 from './md/state1.md'

const textValue = ref<string>(null)

function setStringStore() {
  useStringStore().set(textValue.value)
}
function getStringStore() {
  alert(useStringStore().get)
}
</script>
