<template>
  <UPopup :width="800" :height="600" title="커스텀 설정111" v-model="modelValue" theme="light" @shown="init">
    <VApp>
      <VNavigationDrawer v-model="drawer" app :width="200" density="compact" theme="dark">
        <VList
          ref="menuList"
          density="compact"
          :mandatory="true"
          @click:select="
            ({ id, value, path }) => {
              if (value) {
                selectedMenuValue = id
              }
            }
          "
        >
          <!-- <template v-for="item in configMenus" :key="item.id">
            <VListItem :prepend-icon="item.icon" :value="item.id" :title="item.title" density="compact"></VListItem>
            {{ item.id }}
          </template> -->
          <VListItem prepend-icon="mdi-application" value="application" title="Application" density="compact"></VListItem>
        </VList>
      </VNavigationDrawer>
      <VMain>
        <VContainer>
          <v-btn
            icon="mdi-menu-open"
            color="success"
            variant="elevated"
            style="position: absolute; right: 0; top: 0; z-index: 1"
            @click="drawer = !drawer"
          ></v-btn>
          <component v-if="currentComponent" :is="currentComponent" @requiredClose="() => (modelValue = false)" />
        </VContainer>
      </VMain>
    </VApp>
  </UPopup>
</template>
<script lang="ts" setup>
import { defineProps, shallowRef, ref, computed, onMounted } from '#ustra/nuxt'
import { UPopup } from '#ustra/nuxt-wijmo/components'
import { useVModel, computedAsync } from '@vueuse/core'
import { VList } from 'vuetify/components'

const drawer = ref(true)
const toggle = ref(null)
const props = defineProps<{
  modelValue: boolean
}>()
const modelValue = useVModel(props, 'modelValue')

const selectedMenuValue = ref(null)
const configMenus = computedAsync(async () => await $ustra.management.config.getConfigMenus(), [])

const menuList = ref<InstanceType<typeof VList>>()

// 선택된 컴포넌트
const currentComponent = computed(() => {
  // return !selectedMenuValue.value ? null : configMenus.value.find(menu => menu.id === selectedMenuValue.value).component
  return !selectedMenuValue.value ? null : defineAsyncComponent(() => import('~/layouts/config/custom-application.vue'))
})

function init() {
  selectedMenuValue.value = configMenus.value.length > 0 ? configMenus.value[0].id : null

  if (configMenus.value.length > 0) {
    menuList.value.select(configMenus.value[0].id, true)
  }
}
</script>
<script lang="ts">
export default {
  name: 'CustomConfigPopup',
}
</script>
