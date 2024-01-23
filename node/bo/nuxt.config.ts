export default defineNuxtConfig({
  ssr: false,
  vite: {
    optimizeDeps: {
      exclude: ['@grapecity/wijmo', '@grapecity/wijmo.vue2.grid', 'lodash/toString', 'lodash/isEqual'],
    },
  },
  modules: ['@ustra/nuxt', '@kgc/smsb-common'],
  css: ['~/assets/styles/framework/index.scss', '~/assets/styles/management/index.scss'],
  experimental: {
    emitRouteChunkError: 'automatic',
  },
  routeRules: {
    '/api/**': { proxy: 'http://localhost:11051/api/**' },
    //'/api/**': { proxy: 'http://192.168.41.221:11051/api/**' },
  },
  ustra: {
    i18n: {
      enabled: true,
    },
    auth: {
      enabled: true,
      type: 'jwt',
      jwt: {
        accessTokenKey: 'X-SMSB-BO-AUTH',
        refreshTokenKey: 'X-SMSB-BO-RAUTH',
      },
    },
    // server: {
    //   middleware: {
    //     proxy: {
    //       proxies: {
    //         '/api/': 'http://localhost:11051',
    //       },
    //     },
    //   },
    // },
    nuxt: {
      meta: {
        auth: {
          required: true,
        },
      },
      env: {
        secret: 'NXAxZXQ2ZmtnOGNsMWgxOQ==',
      },
      ckeditor5: {
        enabled: true,
      },
      wijmo: {
        enabled: true,
        styles: {
          theme: 'light',
          addFrameworkCustomStyle: false,
        },
        culture: 'ko',
        samples: {
          additionalMenus: [
            {
              title: 'KGC 영업마케팅',
              icon: 'mdi-group',
              items: [
                { title: '퍼블리싱', componentPath: '~/components/samples/publish/index.vue' },
                { title: '서비스 생성 예제', componentPath: '~/components/samples/service/index.vue' },
                { title: 'Dialog', icon: 'mdi-alert-octagram-outline', componentPath: '~/components/samples/dialog/index.vue' },
                { title: '[Grid]수정가능한 열 설정', componentPath: '~/components/samples/grid-header/index.vue' },
                { title: 'File', componentPath: '~/components/samples/file/index.vue' },
                { title: '프로시져', componentPath: '~/components/samples/procedure/index.vue' },
                { title: '상태관리', componentPath: '~/components/samples/state/index.vue' },
              ],
            },
          ],
          copyResource: {
            enabled: true,
            overwrite: false,
          },
        },
      },
      management: {
        enabled: true,
        ui: {
          tabMenu: {
            enabled: true,
            maximumTabNumbers: 10,
          },
          defaultPage: {
            system: {
              copyResource: {
                enabled: true,
                overwrite: false,
              },
            },
            login: {
              include: false,
            },
            main: {
              include: false,
            },
            layout: {
              include: false,
            },
          },
        },
      },
    },
  },
})
