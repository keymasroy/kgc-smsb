import { defineStore } from '#ustra/nuxt/store'
import { ref, computed } from '#ustra/nuxt'

export const useStringStore = defineStore('string-store', () => {
  const value = ref<string>(null)

  const get = computed(() => {
    return value.value
  })

  function set(val: string) {
    value.value = val
  }

  return { get, set }
})
