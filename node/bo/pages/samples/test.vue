<template>
  <div>
    <UBox direction="row">
      <UItem ratio="1">
        <UButtonBar title="제목">
          <UButtonBox center>
            <UButton text="성공" type="primary" @click="success()" />
            <UButton text="실패" @click="fail()" />
          </UButtonBox>
        </UButtonBar>
      </UItem>
    </UBox>
  </div>
</template>
<script lang="ts" setup>
import { useSampleService } from '~/services/sample/sample-service'
const service = useSampleService()
function success() {
  useOnError(
    async () => {
      const data = await service.getProc_success()
      console.log('data', data)
    },
    {
      message: err => `${err.message}`,
    },
  )()
}

function fail() {
  useOnError(
    async () => {
      const data = await service.getProc_error()
      console.log('data', data)
    },
    {
      message: err => `${err.message}`,
    },
  )()
}
const definePageMeta = (arg: any) => {}
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})
</script>
<script lang="ts">
export default {
  name: 'TestComponent',
}
</script>
