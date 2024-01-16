<template>
  <Sidebar
    v-model:visible="isShow"
    position="bottom"
    style="height: 500px"
  >
    <h1 class="title"> 정관장 멤버스 모바일 카드 </h1>
    
    <div class="barcode">
      <i ></i>
      <span class="number">
        4321  9904  0114  6160
      </span>
    </div>

    <div class="validTime">
      <span>유효시간</span>
      <span class="time">19:29</span>
      <i class="refresh"></i>
    </div>
  </Sidebar>
</template>

<script lang="ts" setup>

const props = defineProps({
  /**
   * Barcode Menu Open 여부
   */
  showBarcode: {
    type: Boolean,
    default: true,
  },
})

const emit = defineEmits(['update:showBarcode']);

const isShow = computed({
  get: () => props.showBarcode,
  set: (n) => emit('update:showBarcode', n),
});

</script>

<style lang="scss" scoped>
h1.title {
  font-size: 24px;
  font-weight: 700;
}

.barcode {
  margin-top: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;

  i {
    background-image: url("data:image/svg+xml,%3Csvg width='300' height='120' viewBox='0 0 300 120' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_766_7218)'%3E%3Cpath d='M39 -11H31V134H39V-11Z' fill='black'/%3E%3Cpath d='M49 -11H46V134H49V-11Z' fill='black'/%3E%3Cpath d='M51 -11H54V134H51V-11Z' fill='black'/%3E%3Cpath d='M57 -11H56V134H57V-11Z' fill='black'/%3E%3Cpath d='M61 -11H62V134H61V-11Z' fill='black'/%3E%3Cpath d='M71 -11H66V134H71V-11Z' fill='black'/%3E%3Cpath d='M73 -11H77V134H73V-11Z' fill='black'/%3E%3Cpath d='M81 -11H80V134H81V-11Z' fill='black'/%3E%3Cpath d='M59 -1H56V144H59V-1Z' fill='black'/%3E%3Cpath d='M61 -1H64V144H61V-1Z' fill='black'/%3E%3Cpath d='M67 -1H66V144H67V-1Z' fill='black'/%3E%3Cpath d='M71 -1H72V144H71V-1Z' fill='black'/%3E%3Cpath d='M14 -5H11V140H14V-5Z' fill='black'/%3E%3Cpath d='M16 -5H19V140H16V-5Z' fill='black'/%3E%3Cpath d='M22 -5H21V140H22V-5Z' fill='black'/%3E%3Cpath d='M26 -5H27V140H26V-5Z' fill='black'/%3E%3Cpath d='M7 -3H4V142H7V-3Z' fill='black'/%3E%3Cpath d='M98 -11H90V134H98V-11Z' fill='black'/%3E%3Cpath d='M108 -11H105V134H108V-11Z' fill='black'/%3E%3Cpath d='M110 -11H113V134H110V-11Z' fill='black'/%3E%3Cpath d='M116 -11H115V134H116V-11Z' fill='black'/%3E%3Cpath d='M120 -11H121V134H120V-11Z' fill='black'/%3E%3Cpath d='M130 -11H125V134H130V-11Z' fill='black'/%3E%3Cpath d='M132 -11H136V134H132V-11Z' fill='black'/%3E%3Cpath d='M140 -11H139V134H140V-11Z' fill='black'/%3E%3Cpath d='M183 -11H191V134H183V-11Z' fill='black'/%3E%3Cpath d='M173 -11H176V134H173V-11Z' fill='black'/%3E%3Cpath d='M171 -11H168V134H171V-11Z' fill='black'/%3E%3Cpath d='M165 -11H166V134H165V-11Z' fill='black'/%3E%3Cpath d='M161 -11H160V134H161V-11Z' fill='black'/%3E%3Cpath d='M151 -11H156V134H151V-11Z' fill='black'/%3E%3Cpath d='M149 -11H145V134H149V-11Z' fill='black'/%3E%3Cpath d='M141 -11H142V134H141V-11Z' fill='black'/%3E%3Cpath d='M242 -11H244V134H242V-11Z' fill='black'/%3E%3Cpath d='M232 -11H235V134H232V-11Z' fill='black'/%3E%3Cpath d='M230 -11H227V134H230V-11Z' fill='black'/%3E%3Cpath d='M224 -11H225V134H224V-11Z' fill='black'/%3E%3Cpath d='M220 -11H219V134H220V-11Z' fill='black'/%3E%3Cpath d='M210 -11H215V134H210V-11Z' fill='black'/%3E%3Cpath d='M208 -11H204V134H208V-11Z' fill='black'/%3E%3Cpath d='M200 -11H201V134H200V-11Z' fill='black'/%3E%3Cpath d='M248 -1H246V144H248V-1Z' fill='black'/%3E%3Cpath d='M258 -1H255V144H258V-1Z' fill='black'/%3E%3Cpath d='M260 -1H263V144H260V-1Z' fill='black'/%3E%3Cpath d='M266 -1H265V144H266V-1Z' fill='black'/%3E%3Cpath d='M270 -1H271V144H270V-1Z' fill='black'/%3E%3Cpath d='M280 -1H275V144H280V-1Z' fill='black'/%3E%3Cpath d='M282 -1H286V144H282V-1Z' fill='black'/%3E%3Cpath d='M290 -1H289V144H290V-1Z' fill='black'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_766_7218'%3E%3Crect width='300' height='120' rx='12' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
    width: 300px;
    height: 120px
  }
  .number {
    margin-top: 10px;
    font-size: 15px;
    line-height: 22.5px;
    color: var(--j-gray500);
  }
}

.validTime {
  padding: 6px 20px;
  margin-top: 95px;
  background: var(--j-bluegray300);
  border-radius: 360px;
  font-size: 15px;
  color: var(--j-gray500);
  height: 36px;
  display: flex;
  align-items: center;

  .time {
    margin-left: 5px;
    font-weight: 700;
  }

  .refresh {
    width: 20px;
    height: 20px;
    display: inline-block;
    margin-left: 15px;
    background-image: url("data:image/svg+xml,%3Csvg width='20' height='21' viewBox='0 0 20 21' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M3.60585 17.8944V16.6444H6.04175L5.43598 16.0642C4.77678 15.4051 4.29628 14.6895 3.99446 13.9176C3.69265 13.1457 3.54175 12.3591 3.54175 11.5579C3.54175 10.1177 3.96348 8.82631 4.80696 7.68369C5.65043 6.54106 6.75646 5.7566 8.12504 5.33031V6.64758C7.11971 7.04075 6.31282 7.68471 5.70437 8.57948C5.09593 9.47426 4.79171 10.467 4.79171 11.5579C4.79171 12.2096 4.91511 12.8426 5.16191 13.4569C5.40871 14.0712 5.79278 14.6391 6.31414 15.1604L6.84302 15.6893V13.4072H8.093V17.8944H3.60585ZM11.8751 17.67V16.3527C12.8804 15.9596 13.6873 15.3156 14.2957 14.4209C14.9042 13.5261 15.2084 12.5333 15.2084 11.4425C15.2084 10.7908 15.085 10.1577 14.8382 9.54344C14.5914 8.92912 14.2073 8.36127 13.686 7.83989L13.1571 7.31102V9.5931H11.9071V5.10596H16.3943V6.35592H13.9584L14.5641 6.93608C15.2233 7.59526 15.7038 8.3108 16.0057 9.08271C16.3075 9.85461 16.4584 10.6412 16.4584 11.4425C16.4584 12.8826 16.0366 14.174 15.1932 15.3166C14.3497 16.4593 13.2437 17.2437 11.8751 17.67Z' fill='black'/%3E%3C/svg%3E%0A");

    &:focus,
    &:active {
      transform: rotate(-360deg);
      transition: all 0.5s;
    }
  }
}
</style>
