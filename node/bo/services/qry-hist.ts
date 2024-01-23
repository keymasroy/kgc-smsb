import { QryHist, QryHistCriteria } from './../models/interfaces'
import { apiModels } from '#ustra/core/data'
import { defineUstraService } from '#ustra/nuxt/composables'

/**
 * 쿼리 로깅 서비스
 */
export const useQryHistService = defineUstraService(({ api }) => {
  /**
   * 쿼리 로그 상세 정보 조회
   * @param procId 프로세스 아이디
   * @param reqId 요청 아이디
   * @returns 쿼리 로그 상세 정보
   */
  async function getQryHist(criteria?: Partial<QryHistCriteria>) {
    return (
      await api.call<apiModels.ApiResponse<QryHist>>({
        url: '/api/system/log/qryHistory2',
        method: 'POST',
        data: criteria,
      })
    )?.data?.body
  }

  return { getQryHist }
})
