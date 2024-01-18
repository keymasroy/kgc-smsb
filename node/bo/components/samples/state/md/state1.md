```
<UTextBox v-model="textValue" :width="200"></UTextBox>

<UButton text="store set" @click="setStringStore" />
<UButton text="store get" type="is-outline" @click="getStringStore" />
```
```
const textValue = ref<string>(null)

function setStringStore() {
  useStringStore().set(textValue.value)
}

function getStringStore() {
  alert(useStringStore().get)
}
```
