import { baseModels } from '#ustra/core/data'
/**
 * 쿼리로그
 * @exports {@link QryHist} {@link QryHistCriteria}
 * @packageDocumentation
 */

import { baseModels, apiModels } from '#ustra/core/data'

export interface QryHist extends baseModels.BaseModel {
  dbmsQryHistId: number
  procId?: string
  reqId?: string
  procMs?: number
  orgQryCont?: string
  execQryCont?: string
}

export interface QryHistCriteria {
  procId?: string
  reqId?: string
}
