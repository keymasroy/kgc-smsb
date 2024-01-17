<template>
  <div class="px-[120px]">
    <h2 class="text-[24px] font-bold mb-[20px] mt-[30px]">Compoents Documentation</h2>

    <div class="list">
      <div class="list__header">
        <span class="label">Name</span>
        <span class="content">Content</span>
        <span class="url">Url</span>
      </div>

      <div
        v-for="(item, idx) in list"
        :key="idx"
        class="item"
      >
        <span class="label">{{ item.label }}</span>
        <span class="content">{{ item.content }}</span>
        <router-link class="url" :to="item.url">{{ item.url }}</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
const list = [
  { label: 'Button', content: '버튼', url: '/docs/buttons' },
  { label: 'Form', content: 'Input, Dropdown, Checkox, Radio', url: '/docs/forms' },
  { label: 'Popup', content: 'Popup, Alert', url: '/docs/popup' },
  { label: 'Calendar', content: 'Calendar / Date Picker', url: '/docs/calendar' },
  { label: 'Tab', content: 'Tab', url: '/docs/tab' },
]
</script>


<style lang="scss" scoped>
.list {
  display: flex;
  flex-direction: column;
  border: 1px solid #e7e7e7;
  border-radius: 8px;
  margin-top: 30px;

  .list__header {
    display: flex;
    font-size: 18px;
    font-weight: 700;
    padding: 15px 30px;
    border-bottom: 1px solid #e7e7e7;
    background-color: #F9FAFC;
  }

  .item {
    display: flex;
    padding: 20px 30px;
    font-size: 15px;

    &:not(:last-child) {
      border-bottom: 1px solid #e7e7e7;
    }

    .label {
      font-weight: 500;
    }

    .url {
      text-decoration: underline;
    }
  }

  .label {
    width: 100px;
  }

  .content {
    width: 300px;
  }

  .url {
    width: 150px;
  }
}
</style>
