<template>
  <div class="loader">
    <div class="spinner">
      <span class="visually-hidden">Loading...</span>
    </div>
  </div>

  <div class="loading d-none">
    <svg class="loading__circle" viewBox="0 0 54 54">
      <circle cx="50%" cy="50%" r="25"></circle>
    </svg>
  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.before-load {
  overflow: hidden;
}

.loader {
  .spinner {
    width: 6.6rem;
    height: 6.6rem;
    border-width: 0.6rem;
    border-style: solid;
    border-color: #151515;
    border-bottom-color: #e5e5e5;
    border-radius: 50%;
    animation: rotation 0.66s linear infinite;
  }
}

@keyframes rotation {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

// svg loading
.loading {
  z-index: 100;
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  // opacity: 0;
  transition: 0.5s;
  background-color: #fff;
}

@-webkit-keyframes loading-spin {
  100% {
    transform: rotate(360deg);
  }
}

@keyframes loading-spin {
  100% {
    transform: rotate(360deg);
  }
}

@-webkit-keyframes loading-circle-ani {
  0% {
    stroke-dashoffset: 157;
  }
  75% {
    stroke-dashoffset: -147;
  }
  100% {
    stroke-dashoffset: -157;
  }
}

@keyframes loading-circle-ani {
  0% {
    stroke-dashoffset: 157;
  }
  75% {
    stroke-dashoffset: -147;
  }
  100% {
    stroke-dashoffset: -157;
  }
}

.loading__circle {
  width: 54px;
  height: 54px;
  -webkit-animation: loading-spin 3s infinite;
  animation: loading-spin 3s infinite;

  circle {
    stroke: #000;
    stroke-width: 4;
    stroke-dasharray: 157;
    stroke-dashoffset: 0;
    fill: transparent;
    -webkit-animation: loading-circle-ani 1s infinite;
    animation: loading-circle-ani 1s infinite;
  }
}

.visually-hidden {
  clip: rect(0,0,0,0)!important;
  border: 0!important;
  height: 0.1rem!important;
  margin: -0.1rem!important;
  overflow: hidden!important;
  padding: 0!important;
  position: absolute!important;
  white-space: nowrap!important;
  width: 0.1rem!important;
}
</style>
